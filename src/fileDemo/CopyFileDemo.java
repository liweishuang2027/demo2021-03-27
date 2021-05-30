package fileDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制demo
 * @author lws
 *
 */
public class CopyFileDemo {
	
	public static void main(String[] args) throws IOException {
		//字符流输入对象
		FileInputStream fis = new FileInputStream("D:\\java学习视频\\IOfile\\picture1.png");
		//字符流输出对象
		FileOutputStream fos = new FileOutputStream("D:\\java学习视频\\IOfile1\\picture1.png");
		
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
