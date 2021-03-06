package jucDemo;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch demo
 * @author lws
 *
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		//System.out.println(CountryEnum.forEach_CountryEnum(2).getRetMessage());
		countDownLatchTest();
	}
	
	public static void general() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for(int i=0;i<6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
				countDownLatch.countDown();
			},"Thread->"+i).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"->班长最后关门走人！");
	}
	
	
	public static void countDownLatchTest() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for(int i=1;i<=6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t 被灭！");
				countDownLatch.countDown();
			},CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"->秦朝统一！");
	}
}
