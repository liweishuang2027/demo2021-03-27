package javatest001;

/** 
 * 队列的实现 
 * @param <E>  
 * @author 
 */  
public class Queue<E> {  
    Object[] data = null;  
    private int capacity; // capacity： 队的容量  
    private int tail; // tail： 队尾指针  
    /** 
     * 初始化为声明大小，则设置为10。 
     */  
    Queue() {  
        this(10);  
    }  
    /** 
     * 初始化队列，声明保存数据的数组大小。 
     * @param initialSize 队列的初始化大小 
     */  
    Queue(int initialSize) {  
        if (initialSize >= 0) {  
            this.capacity = initialSize;  
            data = new Object[initialSize];  
            tail = 0;  
        } else {  
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);  
        }  
    }  
    /** 
     * 判断队列是否为空 
     * @return 
     */  
    public boolean empty() {  
        return tail == 0 ? true : false;  
    }  
    /** 
     * 在队尾插入元素 
     * @param e 待插入的元素 
     * @return 
     */  
    public boolean add(E e) {  
        ensureCapacity();  
        data[tail] = e;  
        ++tail;  
        return true;  
    }  
    /** 
     * 获取队首的元素内容，但不将该元素出队。 
     * @return 
     */  
    public E peek() {  
        return (E) data[0];  
    }  
    /** 
     * 将队首元素出队。 
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
     * 检查存储数据的数组容量，如果数组已经满，则扩充容量；否则不操作。 
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