package com.tjoeun.dbTest;

import java.sql.Connection;

public class MySQLConnectionTest2 {

	public static void main(String[] args) {
		
		Connection conn = DBUtil.getMySQLConnection();
		
//		변경되는 부분을 코딩한다.
		System.out.println("연결 성공 : " + conn);
		DBUtil.close(conn);
		
	}// main

}
