package fileDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ�����demo
 * @author lws
 *
 */
public class CopyFileDemo {
	
	public static void main(String[] args) throws IOException {
		//�ַ����������
		FileInputStream fis = new FileInputStream("D:\\javaѧϰ��Ƶ\\IOfile\\picture1.png");
		//�ַ����������
		FileOutputStream fos = new FileOutputStream("D:\\javaѧϰ��Ƶ\\IOfile1\\picture1.png");
		
		byte[] bytes = new byte[1024];
		int len = 0;
		while((len=fis.read(bytes))!=-1) {
			System.out.println("len:"+len);
			fos.write(bytes,0,len);
		}
		
		fis.close();
		fos.close();
	}

}
