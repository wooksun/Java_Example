package com.tjoeun.interfaceTest2;

public class UserInfoMySqlDAO implements UserInfoDAO {

	@Override
	public void insertUserInfo(UserInfoVO userInfoVO) {
		System.out.println("insert into MYSQL DB userID = " + userInfoVO.getUserID());
	}

	@Override
	public void updateUserInfo(UserInfoVO userInfoVO) {
		System.out.println("update into MYSQL DB userID = " + userInfoVO.getUserID());

	}

	@Override
	public void deleteUserInfo(UserInfoVO userInfoVO) {
		System.out.println("delete into MYSQL DB userID = " + userInfoVO.getUserID());

	}

}
