package com.tjoeun.syncronizedBlockTest;

import java.util.Scanner;

// 통장
public class Account {

	String accountNo; //계좌번호
	String name; //고객 이름
	int money; //잔고
	
	public Account() { }

	public Account(String accountNo, String name, int money) {
		this.accountNo = accountNo;
		this.name = name;
		this.money = money;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", money=" + money + "]";
	}
	
//	입금 메소드
	public void deposit(int amount) {
		money += amount;
		
	}
	
//	출금 메소드
	public int withDraw(int amount) {
//		출금요청 금액이 잔고보다 크면 출금 불가
		if(amount > money) {
			System.out.println(accountNo + "(" + name + ")계좌의 잔액이 부족합니다.");
			return 0;
		} 
		money -= amount; // 계좌 보유 금액 - 출금 요청 금액
		return amount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
