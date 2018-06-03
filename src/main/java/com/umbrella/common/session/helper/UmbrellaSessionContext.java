package com.umbrella.common.session.helper;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.HashMap;

public class UmbrellaSessionContext {

    private static class UmbrellaSessionContextSingletonCreater {
        private static final UmbrellaSessionContext INSTANCE = new UmbrellaSessionContext();
    }

    public static final UmbrellaSessionContext getInstance() {
        return UmbrellaSessionContextSingletonCreater.INSTANCE;
    }
    private Map<String, HttpSession> map;


    private UmbrellaSessionContext() {
        map = new HashMap<String, HttpSession>();
    }

    //添加
    public synchronized void addSession(HttpSession session) {
        if(session!= null)
            map.put(session.getId(), session);
    }

    //获取
    public synchronized HttpSession getSession(String sessionId) {
        if(sessionId == null)
            return null;
        return map.get(sessionId);
    }

    //删除
    public synchronized void delSession(HttpSession session) {
        if(session!= null)
            map.remove(session.getId());
    }

}
