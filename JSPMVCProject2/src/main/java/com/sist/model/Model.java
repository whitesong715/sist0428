package com.sist.model;

import javax.servlet.http.HttpServletRequest;

/*
 *	interface: 유사 클래스를 모아 한번에 관리 
 *	-----------------------------------
 */
public interface Model {
	public String execute(HttpServletRequest request);
}
