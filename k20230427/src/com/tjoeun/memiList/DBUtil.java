package com.tjoeun.memiList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
//	MySQL에 연결하는 Connection을 만들어 리턴하는 메소드
	public static Connection getMySQLConnection() {
		
		Connection conn = null;
		
		try {
//			드라이버 클래스를 읽어온다.
			Class.forName("com.mysql.jdbc.Driver"); // mysql 5.x 사용자
//			MySQL에 연결한다.
//			url에 사용할 MySQL이 설치된 경로와 테이블 이름을 적는다.
			String url = "jdbc:mysql://localhost:3306/javaam?useUnicode=true&characterEncoding=UTF-8"; // mysql 5.x 사용자
			conn = DriverManager.getConnection(url, "root", "0000");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		}
		
		return conn;
	}
//	데이터베이스 작업에 사용한 객체를 닫는 메소드 (Connection을 close하는 메소드)
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
