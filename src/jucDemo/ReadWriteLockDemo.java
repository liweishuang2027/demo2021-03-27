package jucDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ����߳�ͬʱ��һ����Դ��û���κ����⣬����Ϊ�����㲢��������ȡ������ԴӦ�ÿ���ͬʱ���С�
 * ����
 * �����һ���߳���ȡд������Դ�����Ͳ�Ӧ�����������߳̿��Զ���Դ���ж���д
 * �ܽ�
 * �����ܹ���
 * ��д���ܹ���
 * дд���ܹ���
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, "Thread " + i).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, "Thread " + i).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt * 2);
            }, "Thread====" + i).start();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * д������ԭ��+��ռ
     * �������̱�����һ��������ͳһ�壬�м䲻���ָ�������
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t����д�룺" + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\tд�����");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    public void get(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t���ڶ�ȡ��" + key);
            TimeUnit.MILLISECONDS.sleep(3000);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t��ȡ���: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }

    }

    public void clear() {
        map.clear();
    }
}