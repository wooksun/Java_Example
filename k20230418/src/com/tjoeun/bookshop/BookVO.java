package com.tjoeun.bookshop;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

//	설계도(조리법)
public class BookVO { // 도서정보 1건을 기억하는 클래스

	private String title = ""; // 도서명 / 접근권한지정자만 다를 뿐 변수 만드는것과 같다.
	private String author = ""; // 저자
	private String publisher = ""; // 출판사
	private Date writeDate = new Date(); // 출판일
	private double price = 0.0; // 가격

	public BookVO() { // ctrl + space => BookVO라고 기본 생성자 나옴.
		System.out.println("기본 생성자가 실행됩니다.");

	}

	public BookVO(String title, String author, String publisher, Date writeDate, double price) {

		this.title = title;
		this.author = author;
		this.publisher = publisher;

		writeDate.setYear(writeDate.getYear() - 1900);
		writeDate.setMonth(writeDate.getMonth() - 1);

		this.writeDate = writeDate;
		this.price = price;
	}

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

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM.dd(E)");

		DecimalFormat df = new DecimalFormat("#,##0원"); // price=35,000원

		return String.format("%s,%s,%s,%s,%s", title, author, publisher, sdf.format(writeDate), df.format(price));

	}

	@Override
	public int hashCode() {
		return Objects.hash(author, price, publisher, title, writeDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookVO other = (BookVO) obj;
		return Objects.equals(author, other.author)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(publisher, other.publisher) && Objects.equals(title, other.title)
				&& Objects.equals(writeDate, other.writeDate);
	}

}
