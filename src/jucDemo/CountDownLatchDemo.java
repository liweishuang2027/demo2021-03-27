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
				System.out.println(Thread.currentThread().getName()+"\t ������ϰ���뿪����");
				countDownLatch.countDown();
			},"Thread->"+i).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"->�೤���������ˣ�");
	}
	
	
	public static void countDownLatchTest() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for(int i=1;i<=6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t ����");
				countDownLatch.countDown();
			},CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"->�س�ͳһ��");
	}
}
