package exception;
/*
 * Error错误demo
 * Error:Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如：java.lang.StackOverflowError
 * 一般不编写针对性代码处理
 */
public class ErrorTest {
	public static void main(String[] args) {
		//1.栈溢出：Exception in thread "main" java.lang.StackOverflowError
		//main(args);
		//2.堆溢出：java.lang.OutOfMemoryError: Java heap space
		Integer[] arr = new Integer[1024*1024*1024];
	}

}
