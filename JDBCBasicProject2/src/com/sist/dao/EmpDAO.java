package com.sist.dao;
import java.util.*; //ArrayList
import java.sql.*; //오라클 연결

public class EmpDAO {
	// 오라클 연결 객체
	private Connection conn;
	// SQL문장 전송
	private PreparedStatement ps;
	//연결 => URL(오라클 서버 주소)
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	//1. 드라이버 등록
	public EmpDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	//2. 오라클 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	
	//3. 오라클 닫기
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
			//exit
		}catch(Exception ex) {}
	}
	
	//4. 기능처리
	//4-1. 목록출력 => NVL ==> Emp(14)
	//클래스는 한명, 한개에 대한 정보 => new => 모아서 관리 => list
	public ArrayList<Emp> empListData()
	{
		ArrayList<Emp> list=new ArrayList<Emp>();
		try
		{
			//1.연결
			getConnection();
			//2.SQL문장을 만든다
			String sql="SELECT empno,ename,job,hiredate,sal,NVL(comm,0)"
					   +"FROM emp";
			//3.오라클 전송
			ps=conn.prepareStatement(sql);
			//4.결과값 받기
			ResultSet rs=ps.executeQuery();
			while(rs.next())//처음부터 마지막까지
			{
				Emp emp=new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setHiredate(rs.getDate(4));
				emp.setSal(rs.getInt(5));
				emp.setComm(rs.getInt(6));
				
				list.add(emp);
			}
			rs.close();
		}catch(Exception ex) 
		{
			//오류 처리
			ex.printStackTrace();
		}
		finally
		{
			//오라클 닫기
			disConnection();
		}
		return list;
	}
	
	//4-2. 상세보기 => WHERE
	//4-5. 찾기(검색) => LIKE 
}
