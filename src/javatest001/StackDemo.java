package javatest001;
/**
 * 栈的实现
 * @author lws
 *
 * @param <E>
 */
public class StackDemo<E> {
	 
	private Object[] data = null;
	private int capacity;
	private int top;
 
	/**
	 * 默认栈容量为10
	 */
	public StackDemo() {
		this(10);
	}
 
	/**
	 * 初始化栈容量
	 * 
	 * @param initSize
	 */
	public StackDemo(int initSize) {
		if (initSize >= 0) {
			capacity = initSize;
			data = new Object[initSize];
			top = 0;
		} else {
			throw new RuntimeException("初始化栈容量大小不能小于0" + initSize);
		}
	}
 
	/**
	 * 判断栈是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return top == 0 ? true : false;
	}
 
	/**
	 * 获取栈顶元素，但是不弹出
	 * 
	 */
	public E peek() {
		return (E) data[top - 1];
	}
 
	/**
	 * 弹出栈顶元素
	 * 
	 * @return
	 */
	public E pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈已空，没有元素可以弹出。");
		}
		return (E) data[--top];
	}
 
	/**
	 * 向栈顶压入e
	 * 
	 * @param e
	 * @return
	 */
	public boolean push(E e) {
		ensureCapacity();
		data[top] = e;
		top++;
		return true;
	}
 
	/**
	 * 检查存储数据数组容量，如果数组已满，则扩容否则不操作。
	 */
	private void ensureCapacity() {
		if (top == capacity) {
			capacity *= 2;
			Object[] newData = new Object[capacity];
			for (int i = 0; i < top; i++) {
				newData[i] = data[i];
			}
			data = newData;
		}
	}
 
	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < top; i++) {
			string += (data[i] + " ");
		}
		return string;
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		StackDemo<Double> stackDemo = new StackDemo<>();
		for (int i = 0; i < 15; i++) {
			stackDemo.push(i+1.0);
			System.out.println(stackDemo.toString());
		}
 
		System.out.println(stackDemo.peek() + " ");
		for (int i = 0; i < 15; i++) {
			System.out.println(stackDemo.pop() + "");
		}
	}
 
}
