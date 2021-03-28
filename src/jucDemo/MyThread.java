package jucDemo;
/**
 * �̳�Thread�� demo
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
               System.out.println("=====Thread"+name + "�ϰ�" + work-- + "��Сʱ");
            }
        }
    }
    
    public static void main(String[] args) {
    	 MyThread mt1 = new MyThread("����");
    	    MyThread mt2 = new MyThread("����");
    	    MyThread mt3 = new MyThread("����");
    	    mt1.start();
    	    mt2.start();
    	    mt3.start();
	}
}
