package exception;
/*
 * Error����demo
 * Error:Java������޷�������������⡣�磺JVMϵͳ�ڲ�������Դ�ľ���������������磺java.lang.StackOverflowError
 * һ�㲻��д����Դ��봦��
 */
public class ErrorTest {
	public static void main(String[] args) {
		//1.ջ�����Exception in thread "main" java.lang.StackOverflowError
		//main(args);
		//2.�������java.lang.OutOfMemoryError: Java heap space
		Integer[] arr = new Integer[1024*1024*1024];
	}

}
