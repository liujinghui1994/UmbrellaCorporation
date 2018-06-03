package com.umbrella.common.model;

/**
*返回包装后的结果
*/
public class Result {
	
	private boolean flag;
	
	private Object returnMsg;
	
	public Result() {
		
	}
	
	public Result(boolean flag, Object data) {
		this.flag = flag;
		this.returnMsg = data;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Object getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(Object returnMsg) {
		this.returnMsg = returnMsg;
	}

}
