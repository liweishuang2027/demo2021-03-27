package jucDemo;
/**
 * 继承Thread类 demo
 * @author lws
 *
 */
class MyThread extends Thread {
    private int work = 4;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5000; i++) {
            if (work > 0) {
               System.out.println("=====Thread"+name + "上班" + work-- + "个小时");
            }
        }
    }
    
    public static void main(String[] args) {
    	 MyThread mt1 = new MyThread("张三");
    	    MyThread mt2 = new MyThread("李四");
    	    MyThread mt3 = new MyThread("赵五");
    	    mt1.start();
    	    mt2.start();
    	    mt3.start();
	}
}
