package com.tjoeun.bookshop;

import java.text.DecimalFormat;
import java.util.Arrays;

// 여러권의 책 정보(BookVO 클래스)를 기억하는 클래스
public class BookList {

//	1. 필드 선언
	private BookVO[] bookList; // 여러권의 책 정보를 기억할 배열을 선언만 함. => null로 초기화 된다.
	private int size; // 배열의 크기
	private int index; // 배열의 인덱스, 배열에 저장된 데이터의 '개수'

//	2. 생성자 선언
//	기본 생성자로 객체를 생성하면, 10권의 책 정보를 기억할 수 있는 배열을 만들고, 배열의 크기를 넘겨받는 생성자가 실행되면,
//	인수로 넘겨받은 크기만큼의 크기를 가지는 배열을 만든다. => 기본 1개, 넘겨받는것 1개
	public BookList() { // 생성자
//		10권의 책 정보를 기억할 수 있는 배열을 만든다.
//		size = 10; // 10권이니까 배열의 크기는 10으로 지정.
//		bookList = new BookVO[size];
		this(10); // 여기서 this(10)은 아래 public BookList(int size)에 (int size)로 들어감. / 코딩 줄이기
	}

	public BookList(int size) {
//		생성자의 인수로 넘겨받은 size개 만큼의 책 정보를 기억할 수 있는 배열을 만든다.
		super();
		this.size = size; // 필드임을 알려주기 위해 this.
		bookList = new BookVO[this.size];
	}

//	3. getters & setters 선언
	public BookVO[] getBookList() {
		return bookList;
	}

	public void setBookList(BookVO[] bookList) {
		this.bookList = bookList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

//	4. toString() 메소드 Override
	@Override
	public String toString() {
//		return "BookList [bookList=" + Arrays.toString(bookList) + "]";
		
		String str = "";
		str += "===================================\n";
		str += "도서면 저자 출판사 출판일 가격\n";
		str += "===================================\n";
		
		double sum = 0.0;
//		일반 for
//		for(int i=0; i<size; i++) {
//			if(bookList[i] == null) {
//				break;
//			}
//			str += bookList[i] + "\n";
////			각각의 배열 요소에 저장된 BookVO 클래스 객체에서 price만 꺼내서 더해준다.
//			sum += bookList[i].getPrice();
//		}
		
//		향상된 for
		for(BookVO vo : bookList) {
			if(vo == null) {
				break;
			}
			str += vo + "\n";
			sum += vo.getPrice();
		}
		
		DecimalFormat df = new DecimalFormat("$#,##0.00");
		str += "===================================\n";
		str += "합계 금액 : " + df.format(sum) + "\n";
		str += "===================================\n";
		return str;
	}

//	5. BookList 클래스의 bookList 배열에 인수로 넘겨받은 도서 정보를 저장하는 메소드
	public void addBook(BookVO book) {
//		if를 사용하는 전통적인 예외처리 => 배열의 인덱스는 배열의 크기보다 작아야한다. => if(index < 5)
//		if(index < size) {
//			bookList[index++] = book;
//			
//		}else {
//			System.out.println("배열이 가득차서 "+ book.getAuthor() +"의 도서 정보를 저장할 수 없습니다.");
//		}

//		자바의 예외(Exception) 처리 => try ~ catch ~ finally
//		예외가 발생될것으로 예상되는 문장을 try 블록에 코딩한다.
//		예외가 발생되면, 처리할 문장을 catch 블록에 코딩한다.
//		try 블록의 문장들을 실행하다가 예외가 발생되면, 더이상 try 블록의 문장을 실행하지 않고, 해당 예외의 catch 블록의 문장을 실행한다.
//		예외 발생 여부와 상관없이 실행해야 할 문장이 있다면, finally 블록에 코딩한다.

		try {
			bookList[index++] = book;
//			int i = 10 / 0; //예외
//			String str = null;
//			str.trim();

		} catch (ArithmeticException e) {
//			예외를 무시하려면 catch 블록을 비워두면 된다.
			System.out.println("나눗셈은 0으로 할 수 없다."); 
//실행결과:	나눗셈은 0으로 할 수 없다. -> bookList가 6번 실행되어서.
//			나눗셈은 0으로 할 수 없다.
//			나눗셈은 0으로 할 수 없다.
//			나눗셈은 0으로 할 수 없다.
//			나눗셈은 0으로 할 수 없다.
//			나눗셈은 0으로 할 수 없다.
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열이 가득차서 "+ book.getAuthor() +"의 도서 정보를 저장할 수 없습니다.");
//			e.printStackTrace();
//			printStackTrace() : 예외 메세지를 출력하고, 예외가 발생되기 전에 실행된 문장을 실행순의 역순으로 추적한다.
		} catch(Exception e) {
//			예외를 처리하는 모든 클래스는 Exception 클래스를 상속받아 만들어졌기 때문에, 
//			catch 블록에 Exception 클래스만 사용하면 모든 예외를 처리할 수 있다. => Exception은 예외 중 최고 조상
//			Exception 클래스만 사용하려면 반드시 맨 마지막 catch 블록에 사용해야 한다. => catch 블록 최상단에 있으면 예외를 Exception이 혼자 처리
		} finally {
//			System.out.println("꺅~~~~~~~~~");
		}

	}

}
