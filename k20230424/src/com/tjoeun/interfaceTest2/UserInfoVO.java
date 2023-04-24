package com.tjoeun.interfaceTest2;

// VO(Value Object) : 사용자 정보(데이터 1건)와 데이터를 처리할 메소드가 저장되는 클래스. => DTO
public class UserInfoVO {
	
//	bean : 데이터와 데이터 입출력을 모아놓은 것.
	
//	데이터
	private String userID;
	private String userName;
	private String userPassword;
	
//	데이터 입출력 (getter & setter)
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
//	데이터가 잘 들어왔는지 확인하기 위해 문자열을 보기위하여 toString() 오버라이드
	@Override
	public String toString() {
		return "UserInfoVO [userID=" + userID + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
	
	
	

}
