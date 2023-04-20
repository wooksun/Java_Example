package com.tjoeun.memoList;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MemoVO {

	public static int count; 
	private int idx; 
	private String name; 
	private String pwd; 
	private String memo; 
	private Date writeDate; 

	public MemoVO() {
	} // 기본 생성자

	public MemoVO(String name, String pwd, String memo) { 
		idx = ++count;
		this.name = name;
		this.pwd = pwd;
		this.memo = memo;
		writeDate = new Date();
	}


	public int getIdx() {
		return idx;
	}

	public MemoVO(int idx, String name, String pwd, String memo, Date writeDate) {
		super();
		this.idx = idx;
		this.name = name;
		this.pwd = pwd;
		this.memo = memo;
		this.writeDate = writeDate;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E) HH:mm:ss.SSS");
		return String.format("%d. %s(%s)님이 %s에 남긴 글\n%s", idx, name, pwd, sdf.format(writeDate), memo);
	}
	
	

}
