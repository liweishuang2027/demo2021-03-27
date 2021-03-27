package jucDemo;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch demo
 * @author lws
 *
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		general();
	}
	
	public static void general() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for(int i=0;i<6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t ������ϰ���뿪����");
				countDownLatch.countDown();
			},"Thread->"+i).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"->�೤���������ˣ�");
	}
	
	
	public static void countDownLatchTest() {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for(int i=0;i<6;i++) {
			new Thread(()->{
				System.out.println();
			}).start();
		}
		
	}
}
