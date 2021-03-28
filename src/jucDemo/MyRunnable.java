package jucDemo;

class MyRunnable implements Runnable {
    private int work = 8;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 500; i++) {
            if (work > 0) {
                System.out.println("=====Runnable"+Thread.currentThread().getName() + "�ϰ�" + work-- + "��Сʱ");
            }
        }
    }
    
    public static void main(String[] args) {
    	 MyRunnable mt = new MyRunnable();
	     Thread t1 = new Thread(mt, "����");
	     Thread t2 = new Thread(mt, "����");
	     Thread t3 = new Thread(mt, "����");
	     t1.start();
	     t2.start();
	     t3.start();
	}
}
