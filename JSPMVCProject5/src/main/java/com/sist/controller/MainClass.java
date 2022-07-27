package com.sist.controller;

import java.lang.reflect.Method;
import java.util.*;

class Model{
	@requestMapping("list.do")
	public void aaa()//list
	{
		System.out.println("게시물 목록");
	}
	@requestMapping("find.do")
	public void bbb()//Find
	{
		System.out.println("게시물 찾기");
	}
	@requestMapping("insert.do")
	public void ccc()//insert
	{
		System.out.println("게시물 추가");
	}
}

public class MainClass {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("url입력:");
		String url=scan.next();//list.do
		try
		{
			Class clsName=Class.forName("com.sist.controller.Model");//클래스가 가진 모든 정보 읽기(멤버변수 제어, 메소드 호출, 메모리 할당 가능)
			Object obj=clsName.getDeclaredConstructor().newInstance();
			//New Model
			//선언된 메소드
			Method[] methods=clsName.getDeclaredMethods();
			for(Method m: methods)
			{
				requestMapping rm=m.getAnnotation(requestMapping.class);
				if(url.equals(rm.value()))
				{
					m.invoke(obj, null);
				}
			}
		}catch(Exception ex) {}
	}
}







