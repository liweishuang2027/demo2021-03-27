package fileDemo;

import java.io.File;
import java.io.IOException;
/**
 * IO文件流测试
 * @author lws
 *
 */
public class file001 {
	public static void main(String[] args) {
		String pathSeparator = File.pathSeparator;//路径分隔符 windows系统下是;  linux系统下是 ：
		String separator = File.separator;//文件名称分隔符 windows系统下是\  linux系统下是 /
		
//		System.out.println("pathSeparator:"+pathSeparator);
//		System.out.println("separator:"+separator);
		
		
		File file = new File("D:\\java学习视频\\IOfile\\test001.txt");
		System.out.println(file);
		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		
		File file2 = new File("D:\\java学习视频\\IOfile\\test002.txt");
		try {
			boolean b1 = file2.createNewFile();
			System.out.println("b1:"+b1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
