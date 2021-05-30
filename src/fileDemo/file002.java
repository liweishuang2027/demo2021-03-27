package fileDemo;
/**
 * 递归调用，栈内存溢出 错误
 * @author lws
 *
 */
public class file002 {
	public static void main(String[] args) {
		a();
	}
	
	public static void a() {
		System.out.println("调用a方法");
		a();
	}

}
