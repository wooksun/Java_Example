package com.tjoeun.interfaceTest2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class UserInfoClient {

	public static void main(String[] args) {
		
		String dbType = "";
		
//		FileInputStream : 클래스는 파일에 바이트 단위로 데이터를 읽어온다.
		FileInputStream fis  = null;
		
		
		try {
//			String filepath = "db.properties";
			String filepath = "./src/com/tjoeun/interfaceTest2/db.properties";
//		FileInputStream 클래스 생성자의 인수로 읽을 파일의 경로와 이름을 넘겨주면 파일을 읽어온다.
//		FileInputStream 클래스 생성자의 인수로 읽을 파일의 이름만 넘겨주면, 프로젝트 이름의 폴더(k20230424)에서 파일을 읽어온다.
			fis = new FileInputStream(filepath);
//			System.out.println("디스크에 파일이 존재합니다."); //파일이 존재하는 것 확인 후 주석처리
			
//			read() : 메소드는 FileInputStream 클래스 객체에서 1바이트의 데이터를 읽어온다.
//			read 메소드는 코드값으로 읽어오기 때문에, 문자로 출력하려면 형변환이 필요하다.
//			System.out.println((char) fis.read());
			// fis.read() = 68 => DBTYPE=MYSQL의 D를 가져오는데, D는 코드값 68
//			(char) fis.read() = D => 형변환을 하여, D가 나옴
			
//			read() 메소드는 읽어들인 데이터가 있으면, 읽어들인 데이터를 코드값으로 리턴하고, 읽어들인 데이터가 없으면(끝까지 다 읽었으면) -1이 리턴된다.
//			int ch;
//			String prop = "";
//			while((ch = fis.read()) != -1) { //-1이 아닌동안
//				System.out.println((char)ch);
//				prop += (char) ch;
//			}
//			System.out.println("\n" + prop);
//			System.out.println(Arrays.toString(prop.split("=")));
			
//			Properties 클래스는 FileInputStream 객체로 읽어들인 properties 파일의 데이터를 읽어온다.
			Properties  properties = new Properties();
			
//			load() : FileInputStream 객체로 읽어들인 properties 파일을 읽어온다.
			properties.load(fis);
			
//			getProperty() 메소드에 인수로 지정된 properties 파일의 key("=" 왼쪽부분)에 해당되는 value("=" 오른쪽부분)을 얻어온다.
//			getProperty() 메소드의 2번째 인수로 properties 파일에 key가 존재하지 않을 경우 사용할 기본값을 지정할 수 있다.
//			System.out.println(properties.getProperty("DBTYPE", "없음")); //MYSQL
			dbType = properties.getProperty("DBTYPE", "없음");
			System.out.println("DBTYPE : " + dbType); //DBTYPE : MYSQL, DBTYPE : ORACLE => db.properties 파일에서 value값을 바꾸면 값이 바뀐다.
			
		} catch (FileNotFoundException e) { //FileInputStream(filepath)에 대한 예외처리
			e.printStackTrace();
			System.out.println("디스크에 파일이 존재하지 않습니다.");
		} catch (IOException e) { //fis.read()에 대한 예외처리
			e.printStackTrace();
		}
		
		UserInfoVO vo = new UserInfoVO();
		vo.setUserID("qwert");
		vo.setUserName("홍길동");
		vo.setUserPassword("12345");
		System.out.println(vo);
		
		UserInfoDAO dao = null;
		if(dbType.equals("MYSQL")) {
			dao = new UserInfoMySqlDAO();
		}else if (dbType.equals("ORACLE")){
			dao = new UserInfoOracleDAO();
		}else {
			System.out.println(dbType + "은(는) 지원되지 않는 데이터베이스 입니다.");
			return; //return이 없으면 DBTYPE에 MYSQL 혹은 ORACLE이 아닌 데이터가 입력됐을 경우, Exception이 뜬다.
		}
		
		dao.insertUserInfo(vo);
		dao.updateUserInfo(vo);
		dao.deleteUserInfo(vo);
		
	}

}
