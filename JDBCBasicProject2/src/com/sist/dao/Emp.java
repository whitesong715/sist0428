package com.sist.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/*
 *   오라클 데이터형
 *   문자형
 *   	CHAR(1~2000Byte) => 고정
 *   	CHAR(10)=> aaa => 메모리는 10Byte
 *   	VARCHAR2(1~4000Byte) => 가변
 *   	VARCHAR2(4000) => 가변 => 메모리 3byte 가변
 *      => 한글 바이트 => 3byte
 *      CLOB => 4기가 => 가변형
 *      ---------------------자바 매칭(String)
 *   숫자형
 *   	NUMBER(4) => 정수
 *   	NUMVBER(7,2) => 정수/실수
 *   날짜형
 *   기타형
 */
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
	
}
