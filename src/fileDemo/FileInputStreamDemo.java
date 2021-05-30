package fileDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("D:\\java—ßœ∞ ”∆µ\\IOfile\\test004.txt");
		
		byte[] bytes = new byte[2];
		int len = fis.read(bytes);
		System.out.println(len);
		System.out.println(new String(bytes));
		
		len = fis.read(bytes);
		System.out.println(len);
		System.out.println(new String(bytes));
		
		len = fis.read(bytes);
		System.out.println(len);
		System.out.println(new String(bytes));
		
		len = fis.read(bytes);
		System.out.println(len);
		System.out.println(new String(bytes));
	}

}
