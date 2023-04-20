package com.tjoeun.customer;

public class CustomerTest {

	public static void main(String[] args) {
//		일반 고객 객체 생성
		Customer customerLee = new Customer();
		customerLee.setCustomerID(10010);
		customerLee.setCustomerName("최진욱");
		customerLee.setBonusPoint(1000); 
		
		System.out.println("회원 정보 : " + customerLee.showCustomerInfo());
		System.out.println("보너스 포인트 : " + customerLee.calcBonus(35000)); //구매금액 35000에 발생되는 보너스 포인트 금액
		System.out.println("누적 보너스 포인트 : " + customerLee.calcPrice(35000)); //보너스 포인트가 누적되어 나오는 금액
		
//		우수 고객 객체 생성
		VIPCustomer customerLim = new VIPCustomer();
		customerLim.setCustomerID(50050);
		customerLim.setCustomerName("홍길동");
		customerLim.setBonusPoint(10000);
		
		System.out.println("회원 정보 : " + customerLim.showCustomerInfo());
		System.out.println("실제 구매 금액 : " + customerLim.calcSales(10000));
		System.out.println("보너스 포인트 : " + customerLim.calcBonus(10000)); 
		System.out.println("누적 보너스 포인트 : " + customerLim.calcPrice(10000)); 
		
	}

}
