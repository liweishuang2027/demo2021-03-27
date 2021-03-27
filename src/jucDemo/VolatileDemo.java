package jucDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
	volatile int number = 0;
	
	public void addTo60() {
		this.number = 60;
	}
	
	public void addSelf(){
	    number++;
	}
	
	AtomicInteger atomicInteger = new AtomicInteger();
    public void atomicAddSelf(){
        atomicInteger.getAndIncrement();
    }

}

public class VolatileDemo {
	public static void main(String[] args) {
		atomicByVolatile();
	}
		
	 /**
     * volatile���Ա�֤�ɼ��ԣ���ʱ֪ͨ�����̣߳��������ڴ��ֵ�Ѿ����޸�
     */
   public static void visibilityByVolatile() {
		MyData myData = new MyData();
		
		//��һ���߳�
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                //�߳���ͣ3s
            	TimeUnit.SECONDS.sleep(3);
                myData.addTo60();
                System.out.println(Thread.currentThread().getName() + "\t update value:" + myData.number);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }, "thread1").start();
       
        while(myData.number==0) {
        	
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over, num value is " + myData.number);
	}

	/**
     * volatile����֤ԭ����
     * �Լ�ʹ��Atomic��֤ԭ����
     */
    public static void atomicByVolatile(){
        MyData myData = new MyData();
        for(int i = 1; i <= 20; i++){
            new Thread(() ->{
                for(int j = 1; j <= 1000; j++){
                    myData.addSelf();
                    myData.atomicAddSelf();
                }
            },"Thread "+i).start();
        }
        //�ȴ�������̶߳�������ɺ�����main�߳�ȡ�����ս��ֵ
        
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally num value is "+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finally num value is "+myData.atomicInteger);
    }
}
