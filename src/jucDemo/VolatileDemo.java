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
     * volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
     */
   public static void visibilityByVolatile() {
		MyData myData = new MyData();
		
		//第一个线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                //线程暂停3s
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
     * volatile不保证原子性
     * 以及使用Atomic保证原子性
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
        //等待上面的线程都计算完成后，再用main线程取得最终结果值
        
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally num value is "+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finally num value is "+myData.atomicInteger);
    }
}
