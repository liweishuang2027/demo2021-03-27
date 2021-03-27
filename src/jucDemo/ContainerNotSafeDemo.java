package jucDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * 容器线程修改不安全异常demo
 * @author lws
 */
public class ContainerNotSafeDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		//List<String> list = new CopyOnWriteArrayList<String>();
		for(int i=1;i<=30;i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(list);
			}, String.valueOf(i)).start();
		}
	}
	
}
