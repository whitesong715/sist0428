package com.sist.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
//@RequestMapping("list.do")
@Retention(RUNTIME)
@Target(METHOD)
public @interface requestMapping {
	public String value();//문자열을 이용하여 구분한다는 의미
}
