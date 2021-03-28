package jucDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lws
 * һ����ʼֵΪ��ı����������̶߳��佻�������һ����1һ����1����5��
 * 1. �߳�  ����  ��Դ��
 * 2. �ж�  �ɻ�  ֪ͨ
 * 3. ��ֹ��ٻ������
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "ProductorA " + i).start();
        }
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "ConsumerA  " + i).start();
        }
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "ProductorB " + i).start();
        }
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "ConsumerB  " + i).start();
        }
    }
}

class ShareData {//��Դ��
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //1.�ж�
            while (number != 0) {
                //�ȴ���������
                condition.await();
            }
            //2.�ɻ�
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.֪ͨ
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //1.�ж�
            while (number == 0) {
                //�ȴ���������
                condition.await();
            }
            //2.����
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.֪ͨ
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
