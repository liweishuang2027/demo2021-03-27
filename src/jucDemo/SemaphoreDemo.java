package jucDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * �ź��� demo
 * @author lws
 *
 */
public class SemaphoreDemo {
	public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//ģ������ͣ��λ
        for (int i = 1; i <= 6; i++) {//ģ��6������
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t������λ");
                    try {
                        TimeUnit.SECONDS.sleep(3);//ͣ��3s
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\tͣ��3s���뿪��λ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, "Car " + i).start();
        }
    }
}
