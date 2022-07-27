package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.requestMapping;
import com.sist.dao.CategoryVO;
import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FoodModel {
	@requestMapping("food/category.do")
	public String food_category(HttpServletRequest request)
	{
		String no=request.getParameter("no");
		if(no==null)
			no="1";
		FoodDAO dao=new FoodDAO();
		List<CategoryVO> list=dao.categoryListData(Integer.parseInt(no));
		request.setAttribute("list",list);
		return "../food/category.jsp";
	}
	
	@requestMapping("food/food_list.do")
	public String food_list(HttpServletRequest request)
	{
		String cno=request.getParameter("cno");
		FoodDAO dao=new FoodDAO();
		List<FoodVO> list=dao.food_list(Integer.parseInt(cno));
		request.setAttribute("list", list);
		return "../food/food_list.jsp";
	}
	
	@requestMapping("food/detail.do")
	public String food_detail(HttpServletRequest request)
	{
		System.out.println("detail() call..");
		request.setAttribute("msg", "맛집 상세페이지 출력");
		return "../food/detail.jsp";
	}
	
}
