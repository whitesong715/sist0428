package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class ListModel {
	//Model -> 요청처리
	public void execute(HttpServletRequest request)
	{
		request.setAttribute("msg", "게시판 목록");
	}
}
