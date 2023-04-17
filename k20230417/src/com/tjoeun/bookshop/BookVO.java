package com.tjoeun.bookshop;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//	VO(Value Object) 클래스 : 1건의 데이터와 데이터를 처리하는 메소드를 모아놓은 클래스이다.
//	VO 클래스는 DTO(Data Transfer Object)클래스라고도 부른다.
//	=>라면 한봉지, 면(데이터) , 조리법(명령어)이 써있는 것 / 라면사리 : 면(데이터)만 있음

//	bean : 처리할 데이터를 기억하는 변수와 변수에 데이터를 입출력 할 수 있는 getter & setter 메소드로만 구성되는 클래스.

//	설계도(조리법)
public class BookVO { // 도서정보 1건을 기억하는 클래스

//	데이터를 기억할 멤버 변수(필드)를 선언한다. => 클래스 내부에 선언되는 모든 메소드에서 사용할 수 있다.
//	일반 변수를 선언하면 변수에는 어떤값이 들어있는지 모르지만(쓰레기), 클래스에서 선언하는 필드는 별도로 초기화를 하지 않아도 
//	숫자는 0, 문자는 공백, boolean은 false, 클래스로 만든 객체(참조변수)는 null로 자동초기화된다.
//★	this. => 필드 (멤버) / this.를 안쓰면 지역변수

	private String title = ""; // 도서명 / 접근권한지정자만 다를 뿐 변수 만드는것과 같다.
	private String author = ""; // 저자
	private String publisher = ""; // 출판사
	private Date writeDate = new Date(); // 출판일
	private double price = 0.0; // 가격

//	=================================================================================================================================================

//	생성자 메소드(이하 생성자)를 선언한다.
//	생성자 이름은 반드시 클래스 이름과 같아야 한다.
//	생성자를 선언하지 않으면, 컴파일러가 자동으로 아무런 일도 하지않는 생성자 (기본 생성자)를 만들어 준다.
//	프로그래머가 생성자를 선언하면, 기본 생성자를 자동으로 만들어주지 않는다.
//	생성자는 리턴타입을 사용하지 않고, 생성자 내부에서 return도 사용하지 않는다.
//	생성자는 객체가 생성될 때 자동으로 실행되고, 필드에 데이터 초기화를 목적으로 사용한다.

//	기본 생성자
	public BookVO() { // ctrl + space => BookVO라고 기본 생성자 나옴.
		System.out.println("기본 생성자가 실행됩니다.");
//		여기서 BookVO()는 BookshopMain에서 new BookVO();로 저장.

	}

//	데이터를 넘겨받아 필드를 초기화시키는 생성자
	public BookVO(String title, String author, String publisher, Date writeDate, double price) {
//		super(); // 자동으로 만들어지는 Object의 생성자이다.(현재 부모클래스 x) / 없어도 됨.
//		super(); : 부모클래스 생성자의 기본 생성자 호출한다. 생략해도 자바 컴파일러가 자동으로 붙여준다.
//		this(); : 현재 클래스의 기본 생성자를 호출한다.
//		super()와 this()는 반드시 생성자의 첫 문장으로 적어야 한다. => 동시에 사용할 수 없다.
//		super는 부모클래스를 의미하고, this는 현재 클래스를 의미한다.
		this.title = title;
		this.author = author;
		this.publisher = publisher;

//		인수로 넘어온 writeDate에 저장된 날짜 데이터에서 년은 1900을, 월은 1을 빼서 다시 저장한다.
//		★
		writeDate.setYear(writeDate.getYear() - 1900);
		writeDate.setMonth(writeDate.getMonth() - 1);

		this.writeDate = writeDate;
		this.price = price;
	}
	
//	getters & setters메소드를 선언한다.
//	getters & setters메소드는 private 권한으로 선언된 필드를 클래스 외부에서 접근할 수 있또록 예외 규정을 만든다. 
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public Date getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	

	// 클래스 객체에 저장된 데이터를 보고싶다면, toString() 메소드를 @Override(재정의) 해야 한다.
//	@Override 어노테이션 : 이 메소드가 부모클래스에서 상속받은 메소드를 @Override한 메소드임을 의미한다.
//	@Override 어노테이션이 붙어있는 메소드는 메소드 이름을 수정해서 상속받은 메소드 이름과 다르게 하면, 에러를 발생시킨다.
	@Override
	public String toString() { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM.dd(E)");
		
//		숫자 데이터 출력 서식 만들기 => return 타입에 price 부분에서 수정 가능
//		NumberFormat 클래스로 숫자 출력 서식 지정하기 => 미리 제작되어 제공되는 서식만 사용할 수 있다.
//		NumberFormat nf = NumberFormat.getNumberInstance(); //천 단위 구분 기호 ex) 35,000
//		NumberFormat nf = NumberFormat.getCurrencyInstance(); //통화표시와 천 단위 구분 기호 ex) ₩35,000
//		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US); // ex) $35,000.00 => Locale.국가 
//		NumberFormat nf = NumberFormat.getPercentInstance(); // ex) 3,500,000% / 백분유르 자동으로 100이 곱해진다
		
//		DecimalFormat 클래스로 숫자 출력 서식 지정하기 => 만들어 사용한다.
//		형식 : DecimalFormat df = new DecimalFormat("출력 서식");
//		출력 서식에는 "#,##0"을 입력하고 앞, 뒤로 서식에 필요한 문자를 직접 입력해서 만든다.
//		DecimalFormat df = new DecimalFormat("#,##0"); //price=35,000 / NumberFormat.getNumberInstance();와 같다.
//		소수점 아래 숫자를 출력하려면 "."을 입력하고 보고싶은 자리만큼 "0"을 입력한다.
//		DecimalFormat df = new DecimalFormat("#,##0.00");  //price=35,000.00
		DecimalFormat df = new DecimalFormat("#,##0원");  //price=35,000원
		
		
		
		
		return "BookVO [title=" + title + ", author=" + author + ", publisher=" + publisher + ", writeDate=" + sdf.format(writeDate)
				+ ", price=" + df.format(price) + "]";
	}


}
