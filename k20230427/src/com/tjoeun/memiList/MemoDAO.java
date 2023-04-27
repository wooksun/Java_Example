package com.tjoeun.memiList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// MemoService 클래스에서 전처리 작업이 완료되서 넘어온 SQL 명령을 실행하는 클래스
public class MemoDAO {

//	테이블에 저장할 데이터가 저장된 MemoVO 클래스 객체를 넘겨받아 테이블에 데이터를 저장하는 메소드
	public static boolean insert(MemoVO vo) {
		
		boolean result = true;
		
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			MySQL에 연결한다.
			conn = DBUtil.getMySQLConnection();
			
//			SQL 명령을 만든다
			String sql = "insert into memo(name, password, memo) values(?, ?, ?)";
			
//			SQL 명령을 임시로 실행한다.
			pstmt = conn.prepareStatement(sql);
			
//			"?"에 데이터를 넣어준다.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getMemo());
			
//			"?"가 채워진 SQL 명령을 최종적으로 실행한다.
			pstmt.executeUpdate();
//			System.out.println(vo.getName() + "님 글 저장완료.");
		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("SQL 명령이 올바르게 실행되지 않았습니다.");
			result = false;
		} finally {
			DBUtil.close(conn);
		}
		return result;
		
	}

//	테이블에 저장된 메모 목록을 최신글 순으로 얻어오는 메소드
	public static ArrayList<MemoVO> select() {
		
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null; //db연결필요
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		메모 목록을 저장해서 리턴시킬 ArrayList를 선언한다.
		ArrayList<MemoVO> list = null;
		
		try {
//			MySQL에 연결한다.
			conn = DBUtil.getMySQLConnection();
			
//			SQL 명령을 만든다
			String sql = "select * from memo order by idx desc";
			
//			SQL 명령을 임시로 실행한다.
			pstmt = conn.prepareStatement(sql);
			
//			select SQL 명령의 실행 결과를 ResultSet 객체에 저장한다.
			rs = pstmt.executeQuery();
			
//			테이블에서 성공적으로 데이터를 얻어왔으므로 결과를 저장해서 리턴시킬 ArrayList 객체를 만든다.
			list = new ArrayList<>();
			
//			ResultSet 객체에 데이터가 있는동안 반복하며 ResultSet 객체에 저장된 데이터를 MemoVO 객체로 만들어서 ArrayList에 저장한다.
//			next() 메소드 :  ResultSet 객체에 저장된 다음 데이터로 접근한다.
//			next() 메소드는 다음 데이터가 있으면 true, 없으면 false를 리턴한다.
			while(rs.next()) { //다음 데이터가 있으면 접근해라.
//				ResultSet 객체의 데이터를 읽어서 MemoVO 클래스 객체에 저장한다.
				MemoVO vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
//				System.out.println(vo);
				
//				MemoVO 클래스 객체를 ArrayList에 저장한다.
				list.add(vo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 명령이 올바르게 실행되지 않았습니다.");
		} finally {
			DBUtil.close(conn);
		}
		
		return list;
	}

//	테이블에서 글 1건을 얻어오는 메소드
	public static MemoVO selectByIdx(int idx) {
		
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		메모 1건을 저장해서 리턴시킬 MemoVO 클래스 객체를 선언한다.
		MemoVO vo = null;
		
		try {
//			MySQL에 연결한다.
			conn = DBUtil.getMySQLConnection();
			
//			SQL 명령을 만든다
			String sql = "select * from memo where idx = ?";
			
//			SQL 명령을 임시로 실행한다.
			pstmt = conn.prepareStatement(sql);
			
//			"?"에 데이터를 넣어준다.
			pstmt.setInt(1, idx);
			
//			select SQL 명령의 실행 결과를 ResultSet 객체에 저장한다.
			rs = pstmt.executeQuery();
			
			
//			ResultSet 객체의 데이터를 MemoVO클래스 객체에 저장한다.
			if(rs.next()) { 
//			테이블에서 성공적으로 데이터를 얻어왔으므로 결과를 저장해서 리턴시킬 MemoVO 클래스 객체를 만든다.
				vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
//				System.out.println(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 명령이 올바르게 실행되지 않았습니다.");
		} finally {
			DBUtil.close(conn);
		}
		
		return vo;
	}

//	테이블에 저장된 메모 1건을 삭제하는 메소드
	public static void delete(int idx) {
		
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		try {
//			MySQL에 연결한다.
			conn = DBUtil.getMySQLConnection();
			
//			SQL 명령을 만든다
			String sql = "delete from memo where idx = ?";
			
//			SQL 명령을 임시로 실행한다.
			pstmt = conn.prepareStatement(sql);
			
//			"?"에 데이터를 넣어준다.
			pstmt.setInt(1, idx);
			
//			"?"가 채워진 SQL 명령을 최종적으로 실행한다.
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 명령이 올바르게 실행되지 않았습니다.");
		} finally {
			DBUtil.close(conn);
		}
	}

//	테이블에 저장된 메모 1건을 수정하는 메소드
	public static void update(int idx, String name ,String memo) {
		
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		try {
//			MySQL에 연결한다.
			conn = DBUtil.getMySQLConnection();
			
//			SQL 명령을 만든다
			String sql = "update memo set name = ?, memo = ? where idx = ?";
			
//			SQL 명령을 임시로 실행한다.
			pstmt = conn.prepareStatement(sql);
			
//			"?"에 데이터를 넣어준다.
			pstmt.setString(1, name);
			pstmt.setString(2, memo);
			pstmt.setInt(3, idx);
			
//			"?"가 채워진 SQL 명령을 최종적으로 실행한다.
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 명령이 올바르게 실행되지 않았습니다.");
		} finally {
			DBUtil.close(conn);
		}
	}

}
