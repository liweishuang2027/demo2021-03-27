package jucDemo;

class MyRunnable implements Runnable {
    private int work = 8;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 500; i++) {
            if (work > 0) {
                System.out.println("=====Runnable"+Thread.currentThread().getName() + "上班" + work-- + "个小时");
            }
        }
    }
    
    public static void main(String[] args) {
    	 MyRunnable mt = new MyRunnable();
	     Thread t1 = new Thread(mt, "张三");
	     Thread t2 = new Thread(mt, "李四");
	     Thread t3 = new Thread(mt, "赵五");
	     t1.start();
	     t2.start();
	     t3.start();
	}
}
