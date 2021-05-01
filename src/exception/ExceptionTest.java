package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Exception Demo
 * @author lws
 *
 */
public class ExceptionTest {
	
	public static void test1() {
		String str = "123";
		str = "abc";
		try {
			int num = Integer.parseInt(str);
			System.out.println("----------------1------------------");
		}catch(NullPointerException e) {
			System.out.println("NullPointerException!");
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
			System.out.println("出现数值转换异常！");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("出现异常！");
		}
		System.out.println("----------------2------------------");
	}
	
	public static void throwsExceptionTest() throws IOException {
		File file = new File("test.txt");
		FileInputStream fis = new FileInputStream(file);
		
		int data = fis.read();
		while(data != -1) {
			System.out.println(data);
			data = fis.read();
		}
		
		fis.close();
	}
	
	public static void throwsExceptionTest2() {
		try {
			throwsExceptionTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test1();
		throwsExceptionTest2();
	}

}
