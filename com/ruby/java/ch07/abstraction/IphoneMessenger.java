package com.ruby.java.ch07.abstraction;

public class IphoneMessenger implements Messenger {
	
	public String getMessage() {
		return "iPhone";
	}
	
	public void setMessage(String msg) {
		System.out.println("msg : " + msg);
	}
	

}
