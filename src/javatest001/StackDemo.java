package javatest001;
/**
 * ջ��ʵ��
 * @author lws
 *
 * @param <E>
 */
public class StackDemo<E> {
	 
	private Object[] data = null;
	private int capacity;
	private int top;
 
	/**
	 * Ĭ��ջ����Ϊ10
	 */
	public StackDemo() {
		this(10);
	}
 
	/**
	 * ��ʼ��ջ����
	 * 
	 * @param initSize
	 */
	public StackDemo(int initSize) {
		if (initSize >= 0) {
			capacity = initSize;
			data = new Object[initSize];
			top = 0;
		} else {
			throw new RuntimeException("��ʼ��ջ������С����С��0" + initSize);
		}
	}
 
	/**
	 * �ж�ջ�Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return top == 0 ? true : false;
	}
 
	/**
	 * ��ȡջ��Ԫ�أ����ǲ�����
	 * 
	 */
	public E peek() {
		return (E) data[top - 1];
	}
 
	/**
	 * ����ջ��Ԫ��
	 * 
	 * @return
	 */
	public E pop() {
		if (isEmpty()) {
			throw new RuntimeException("ջ�ѿգ�û��Ԫ�ؿ��Ե�����");
		}
		return (E) data[--top];
	}
 
	/**
	 * ��ջ��ѹ��e
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
	 * ���洢��������������������������������ݷ��򲻲�����
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
		// TODO �Զ����ɵķ������
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
