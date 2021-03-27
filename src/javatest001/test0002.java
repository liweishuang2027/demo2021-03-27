package javatest001;

public class test0002 {
	
	public static void main(String[] args) {
		System.out.println("test:"+test());
	}
	
	private static int test() {
		int num = 10;
		try {
			System.out.println("try");
			return num+=80;
		}catch(Exception e) {
			System.out.println("error");
		}finally {
			if(num>20) {
				System.out.println("num>20:"+num);
			}
			System.out.println("finally");
			return 100;
		}
	}

}
