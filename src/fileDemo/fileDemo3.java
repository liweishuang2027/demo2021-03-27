package fileDemo;

/**
 * µ›πÈDemo
 * @author lws
 *
 */
public class fileDemo3 {
	
	public static void main(String[] args) {
		int s = sum(10);
		System.out.println(s);
	}
	
	public static int sum(int n) {
		if(n==1) {
			return 1;
		}
		
		return n + sum(n-1);
	}

}
