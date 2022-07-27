package com.sist.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> clsList=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		clsList.add("com.sist.model.FoodModel");
	}
	/*
	 * 	http://localhost:8080/_JSPMVCProject5/food/category.do => URL
	 *                        ---------------contextpath
	 *                        --------------------------------URI
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			//사용자가 요청한 URL 읽어오기 => .do
			String uri=request.getRequestURI();
			System.out.println("uri:"+uri);
			uri=uri.substring(request.getContextPath().length()+1);
			System.out.println("uri_2:"+uri);
			
			for(String cls:clsList)
			{
				Class clsName=Class.forName(cls);
				if(clsName.isAnnotationPresent(Controller.class)==false)
					continue;
				Object obj=clsName.getDeclaredConstructor().newInstance();
				
				//메소드 찾기
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods)
				{
					requestMapping rm=m.getAnnotation(requestMapping.class);
					//메소드에 있는 어노테이션(RequestMapping)을 불러옴 -> 어노테이션은 여러개 사용 가능
					if(uri.equals(rm.value())) //requestMapping이 uri와 동일한가?
					{
						String jsp=(String)m.invoke(obj, request);
						//                               -------FoodModel메소드의 매개변수, 없을 시 null
						RequestDispatcher rd=request.getRequestDispatcher(jsp);
						rd.forward(request, response);
						
						return;
					}
				}
			}
		}catch(Exception ex) {}
	}

}
