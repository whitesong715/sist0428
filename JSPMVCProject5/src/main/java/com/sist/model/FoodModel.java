package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.requestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FoodModel {
	@requestMapping("food/category.do")
	public String food_category(HttpServletRequest request)
	{
		System.out.println("food_category() call..");
		request.setAttribute("msg", "카테고리 출력");
		return "../food/category.jsp";
	}
	@requestMapping("food/food_list.do")
	public String food_list(HttpServletRequest request)
	{
		System.out.println("food_list() call..");
		request.setAttribute("msg", "카테고리별 맛집 출력");
		return "../food/category.jsp";
	}
	@requestMapping("food/detail.do")
	public String food_detail(HttpServletRequest request)
	{
		System.out.println("detail() call..");
		request.setAttribute("msg", "맛집 상세페이지 출력");
		return "../food/category.jsp";
	}
	
}
