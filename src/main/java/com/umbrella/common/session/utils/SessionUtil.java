package com.umbrella.common.session.utils;

import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

public class SessionUtil {

        static String cookname="JAVA_JSESSIONID";
        static String path="YourWebsiteDomain";

        //默认session缓存生存时间,以秒为单位,session过期时间为2分钟
        private final int sessionLife = 120;

        //访问的Redis端口
        Properties properties = System.getProperties();



        static int port=7000;

        private Jedis jedis;
        public SessionUtil(){
            jedis=new Jedis(path,port);
        }
        public SessionUtil(String path){
            jedis=new Jedis(path);
        }
        public static String getCookname() {
            return cookname;
        }
        public static void setCookname(String cookname) {
            SessionUtil.cookname = cookname;
        }
        public static String getPath() {
            return path;
        }
        public static void setPath(String path) {
            SessionUtil.path = path;
        }

        /**
         * 往redis的session里增添新内容 
         * @param sessionId
         * @param key
         * @param value
         */
        public void putSessionValue(String sessionId,String key,String value){
            if(sessionId!=null&&!sessionId.equals("")){
                //如果原来已有数据，则在原来的JSONObject的基础上增加用户态属性的键值  
                if(jedis.exists(sessionId)){
                    String jsonStr=jedis.get(sessionId);
                    JSONObject jsonObj=JSONObject.fromObject(jsonStr);
                    jsonObj.put(key, value);
                    jedis.set(sessionId, jsonObj.toString());
                    //设置jedis该键session的过期时间  
                    jedis.expire(key, sessionLife);
                }
                //否则在redis里新增一个session  
                else{
                    JSONObject jsonObj=new JSONObject();
                    jsonObj.put(key, value);
                    jedis.set(sessionId, jsonObj.toString());
                }
            }
        }

        /**
         * 从redis的session里获得属性 
         * @param sessionId
         * @param key
         * @param
         * @return
         */
        public Object getSessionValue(String sessionId,String key){
            if(sessionId!=null&&!sessionId.equals("")&&jedis.exists(sessionId)){
                //根据sessionId活动了session的json对象后再进行操作  
                String jsonStr=jedis.get(sessionId);
                JSONObject jsonObj=JSONObject.fromObject(jsonStr);
                return jsonObj.get(key);
            }
            return null;
        }

        /**
         * 从redis删除session 
         * @param sessionId
         * @return
         */
        public void removeSession(String sessionId){
            jedis.del(sessionId);
        }

        /**
         * 是否存在改session 
         * @param sessionId
         * @return
         */
        public boolean isExitSession(String sessionId){
            return jedis.exists(sessionId);
        }

        /**
         * 从请求中获得客户端给的cookie中对应的sessionId 
         * @return
         */
        public String getSessionId(HttpServletRequest request){
            String sessionId=null;
            //获得该有效路径下的所有cookie  
            Cookie[] cookie = request.getCookies();
            if(cookie!=null){
                for (int i = 0; i < cookie.length; i++) {
                    Cookie cook = cookie[i];
                    //遍历cookies，找到制定cookiename的cookie,从键值对中取出sessionId  
                    if(cook.getName().equals(cookname)){
                        sessionId=cook.getValue().toString();
                    }
                }
            }
            return sessionId;
        }

        /**
         * 生成cookie给客户端 
         * @return
         */
        public void createSession(String key,String value,HttpServletRequest request,HttpServletResponse response){
            //用MD5加密算法生成sessionId(由属性值加上时间戳）  
            String sessionId =value+System.currentTimeMillis();
            //将session的Id存储到指定名字的cookie中  
            Cookie cookie = new Cookie(cookname, sessionId);
            //设置cookie的有效路径  
            cookie.setPath(request.getContextPath());
            //将session相关信息保存到Redis里  
            putSessionValue(sessionId,key,value);
            //将cookie返回给客户端  
            response.addCookie(cookie);
        }


    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.3.101",6379,10000);
        System.out.println("测试连接："+jedis.ping());
    }

    
}
