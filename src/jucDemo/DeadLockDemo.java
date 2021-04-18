package jucDemo;

import java.util.concurrent.TimeUnit;

/**
 * ����demo
 * ������ָ�������������ϵĽ�����ִ�й����У���������Դ����ɵ�һ�ֻ���ȴ�������,�����������������Ƕ����޷��ƽ���ȥ
 * @author lws
 *
 */
public class DeadLockDemo {
	public static void main(String[] args) {
		Object resourceA = new Object();
		Object resourceB = new Object();
		
		new Thread(new MyTask(resourceA, resourceB),"Thread A").start();
		new Thread(new MyTask(resourceB, resourceA),"Thread B").start();
	}
}

class MyTask implements Runnable{

	private Object resourceA, resourceB;
	
	public MyTask(Object resourceA, Object resourceB) {
		this.resourceA = resourceA;
		this.resourceB = resourceB;
	}

	@Override
	public void run() {
		synchronized (resourceA) {
			System.out.println(String.format("%s �Լ�����%s�����Գ���%s",// 
					Thread.currentThread().getName(), resourceA, resourceB));
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (resourceB) {
				System.out.println(String.format("%s ͬʱ����%s��%s",// 
						Thread.currentThread().getName(), resourceA, resourceB));
			}
		}
	}
}

