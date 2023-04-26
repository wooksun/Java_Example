package com.tjoeun.dbTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {
	
	public static void main(String[] args) {
		
//		테이블에 저장할 데이터를 키보드로 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine().trim();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine().trim();
		System.out.print("메모 : ");
		String memo = sc.nextLine().trim();
		
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
//		MySQL에 연결한다.
		conn = DBUtil.getMySQLConnection(); //MYSQL에 연결됨
		if(conn != null) {
			
			try {
//				System.out.println("연결 성공 : " + conn);
//				MYSQL에 정상적으로 연결이 되었으므로 입력받은 데이터를 테이블에 저장한다.
				
				/*
//				Statement를 사용해서 입력받은 데이터를 테이블에 저장한다.
//				SQL 명령을 만든다.
//				문자열은 반드시 작은따옴표로 묶어야 하고, 문장 끝에 ';'을 입력하면 안된다.
//				String sql = "insert into memo(name, password, memo) values ('" + name + "', '" + password + "', '" + memo +"')";
				String sql = String.format("insert into memo(name, password, memo) values ('%s','%s','%s')", name, password, memo);
//				System.out.println(sql);

//				SQL 명령을 실행할 준비를 한다.
				stmt = conn.createStatement();
//				SQL 명령을 실행
//				executeQuery() : 테이블에 저장된 데이터가 변경되지 않는 SQL 명령을 실행한다. => select명령할 때
//				executeUpdate() : 테이블에 저장된 데이터가 변경되는 SQL 명령을 실행한다. => insert, delete, update
				stmt.executeUpdate(sql);
				*/
				
//				PreparedStatement를 사용해서 입력받은 데이터를 테이블에 저장한다
//				SQL 명령을 만든다.
//				변수에 저장된 데이터가 대입될 자리에 "?"를 입력하고, 나중에 "?"에 데이터를 대입한다.
//				문자열 데이터일 경우 Statement처럼 작은따옴표를 사용할 필요가 없다.
				String sql = "insert into memo(name, password, memo) values (?, ?, ?)";
//				SQL 명령을 임시로 실행한다. => 위의 코드는 불완전한 코드이기 때문 => ?,?,?는 어떤 값이 들어간다라고만 표시한 것.
				pstmt = conn.prepareStatement(sql);
//				"?"에 데이터를 넣어준다.
				pstmt.setString(1, name);
				pstmt.setString(2, password);
				pstmt.setString(3, memo);
//				"?"가 채워진 SQL 명령을 확정 실행한다.
				pstmt.executeUpdate(); //PreparedStatement는 이미 데이터를 채웠기 때문에 executeUpdate()안에 적지 않아도 됨.
				System.out.println("저장완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} else {
			System.out.println("연결 실패");
		}
		
	}
	
}
