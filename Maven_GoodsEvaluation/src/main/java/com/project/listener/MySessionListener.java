package com.project.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.SessionListenerAdapter;

/**
 * ����session������ 
 * ʵ��SessionListener�ӿ�
 * �̳�SessionListenerAdapter
 * @author Mac Book Pro
 *
 */
public class MySessionListener implements SessionListener{

	@Override
	public void onStart(Session session) {
		System.out.println("session创建监听");
		
	}
	@Override
	public void onStop(Session session) {
		// TODO Auto-generated method stub
		System.out.println("session销毁监听");
	}

	@Override
	public void onExpiration(Session session) {
		// TODO Auto-generated method stub
		System.out.println("session过期监听");
	}

}
