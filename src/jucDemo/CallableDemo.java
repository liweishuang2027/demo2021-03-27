package jucDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * ���߳��У������ֻ�ö��̵߳ķ�ʽ
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FutureTask(Callable<V> callable)
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread2());

        new Thread(futureTask, "AAA").start();
//        new Thread(futureTask, "BBB").start();//���ã�ֱ��ȡֵ����Ҫ���������߳�
        int a = 100;
        int b = 0;
        //b = futureTask.get();//Ҫ����Callable�̵߳ļ����������û�м�����ɾ�Ҫȥǿ�󣬻ᵼ�¶�����ֱ���������
        while (!futureTask.isDone()) {//��futureTask��ɺ�ȡֵ
            b = futureTask.get();
        }
        System.out.println("*******Result" + (a + b));
    }
}

class MyThread1 implements Runnable {
    @Override
    public void run() {
    }
}

class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Callable come in");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1024;
    }
}

