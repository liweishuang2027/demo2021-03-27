package javatest001;

/** 
 * ���е�ʵ�� 
 * @param <E>  
 * @author 
 */  
public class Queue<E> {  
    Object[] data = null;  
    private int capacity; // capacity�� �ӵ�����  
    private int tail; // tail�� ��βָ��  
    /** 
     * ��ʼ��Ϊ������С��������Ϊ10�� 
     */  
    Queue() {  
        this(10);  
    }  
    /** 
     * ��ʼ�����У������������ݵ������С�� 
     * @param initialSize ���еĳ�ʼ����С 
     */  
    Queue(int initialSize) {  
        if (initialSize >= 0) {  
            this.capacity = initialSize;  
            data = new Object[initialSize];  
            tail = 0;  
        } else {  
            throw new RuntimeException("��ʼ����С����С��0��" + initialSize);  
        }  
    }  
    /** 
     * �ж϶����Ƿ�Ϊ�� 
     * @return 
     */  
    public boolean empty() {  
        return tail == 0 ? true : false;  
    }  
    /** 
     * �ڶ�β����Ԫ�� 
     * @param e �������Ԫ�� 
     * @return 
     */  
    public boolean add(E e) {  
        ensureCapacity();  
        data[tail] = e;  
        ++tail;  
        return true;  
    }  
    /** 
     * ��ȡ���׵�Ԫ�����ݣ���������Ԫ�س��ӡ� 
     * @return 
     */  
    public E peek() {  
        return (E) data[0];  
    }  
    /** 
     * ������Ԫ�س��ӡ� 
     * @return 
     */  
    public E poll() {  
        E e = (E) data[0];  
        for (int index = 1; index < tail; ++index) {  
            data[index - 1] = data[index];  
        }  
        data[tail - 1] = null;  
        --tail;  
        return e;  
    }  
    /** 
     * ���洢���ݵ�������������������Ѿ��������������������򲻲����� 
     */  
    private void ensureCapacity() {  
        int index;  
        if (tail == capacity) {  
            capacity *= 2;  
            Object[] newData = new Object[capacity];  
            for (index = 0; index < tail; ++index) {  
                newData[index] = data[index];  
            }  
            data = newData;  
        }  
    }  
    @Override  
    public String toString() {  
        String str = "";  
        for (int index = 0; index < tail; ++index) {  
            if (data[index] != null) {  
                str += (data[index] + " ");  
            }  
        }  
        return str;  
    }  
}  