package fileDemo;

import java.io.File;
import java.io.IOException;
/**
 * IO�ļ�������
 * @author lws
 *
 */
public class file001 {
	public static void main(String[] args) {
		String pathSeparator = File.pathSeparator;//·���ָ��� windowsϵͳ����;  linuxϵͳ���� ��
		String separator = File.separator;//�ļ����Ʒָ��� windowsϵͳ����\  linuxϵͳ���� /
		
//		System.out.println("pathSeparator:"+pathSeparator);
//		System.out.println("separator:"+separator);
		
		
		File file = new File("D:\\javaѧϰ��Ƶ\\IOfile\\test001.txt");
		System.out.println(file);
		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		
		File file2 = new File("D:\\javaѧϰ��Ƶ\\IOfile\\test002.txt");
		try {
			boolean b1 = file2.createNewFile();
			System.out.println("b1:"+b1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
