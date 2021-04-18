package jucDemo;

import java.util.concurrent.TimeUnit;

/**
 * 死锁demo
 * 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象,若无外力干涉那它们都将无法推进下去
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
			System.out.println(String.format("%s 自己持有%s，尝试持有%s",// 
					Thread.currentThread().getName(), resourceA, resourceB));
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (resourceB) {
				System.out.println(String.format("%s 同时持有%s，%s",// 
						Thread.currentThread().getName(), resourceA, resourceB));
			}
		}
	}
}

