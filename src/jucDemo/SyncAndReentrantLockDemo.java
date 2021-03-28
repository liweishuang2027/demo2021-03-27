package jucDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized��lock����
 * <p===lock�ɰ󶨶������===
 * ���߳�֮�䰴˳����ã�ʵ��A>B>C�����߳�������Ҫ�����£�
 * AA��ӡ5�Σ�BB��ӡ10�Σ�CC��ӡ15��
 * ������
 * AA��ӡ5�Σ�BB��ӡ10�Σ�CC��ӡ15��
 * ��������
 * ��ʮ��
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareData1 shareData = new ShareData1();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareData.print5();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareData.print10();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareData.print15();
            }
        }, "C").start();
    }

}

class ShareData1 {
    private int number = 1;//A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //�ж�
            while (number != 1) {
                condition1.await();
            }
            //�ɻ�
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //֪ͨ
            number = 2;
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10() {
        lock.lock();
        try {
            //�ж�
            while (number != 2) {
                condition2.await();
            }
            //�ɻ�
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //֪ͨ
            number = 3;
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15() {
        lock.lock();
        try {
            //�ж�
            while (number != 3) {
                condition3.await();
            }
            //�ɻ�
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //֪ͨ
            number = 1;
            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}