package fileDemo;
/**
 * 文件输出流
 * @author lws
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
//		File file = new File("D:\\java学习视频\\IOfile\\test001.txt");
//		System.out.println(file);
		
		FileOutputStream fos = new FileOutputStream("D:\\java学习视频\\IOfile\\test004.txt");
		fos.write(49);
		fos.write(48);
		fos.write(48);
		
		byte[] bytes = {-65,-66,-67,68,69};
		fos.write(bytes);
		fos.close();
		
		
	}
	
}
