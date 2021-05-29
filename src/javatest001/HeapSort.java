package javatest001;
/**
 * ������
 * @author lws
 *
 */
public class HeapSort {
	
	public static void main(String[] args) {
        // ��ʼ��һ������
        int[] array = {
                1, 3, 4, 5, 2, 6, 9, 7, 8, 0
        };
 
        // ���ÿ������򷽷�
        HeapSort heap = new HeapSort();
        System.out.print("����ǰ:\t");
        heap.printPart(array, 0, array.length - 1);
        heap.heapSort(array);
        System.out.print("�����:\t");
        heap.printPart(array, 0, array.length - 1);
    }
	 
    public void HeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp���浱ǰ���ڵ�
        int child = 2 * parent + 1; // �Ȼ������
 
        while (child < length) {
            // ������Һ��ӽ�㣬�����Һ��ӽ���ֵ�������ӽ�㣬��ѡȡ�Һ��ӽ��
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }
 
            // ���������ֵ�Ѿ����ں��ӽ���ֵ����ֱ�ӽ���
            if (temp >= array[child])
                break;
 
            // �Ѻ��ӽ���ֵ���������
            array[parent] = array[child];
 
            // ѡȡ���ӽ������ӽ��,��������ɸѡ
            parent = child;
            child = 2 * child + 1;
        }
 
        array[parent] = temp;
    }
 
    public void heapSort(int[] list) {
        // ѭ��������ʼ��
        for (int i = list.length / 2; i >= 0; i--) {
            HeapAdjust(list, i, list.length);
        }
 
        // ����n-1��ѭ�����������
        for (int i = list.length - 1; i > 0; i--) {
            // ���һ��Ԫ�غ͵�һԪ�ؽ��н���
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
 
            // ɸѡ R[0] ��㣬�õ�i-1�����Ķ�
            HeapAdjust(list, 0, i);
            System.out.format("�� %d ��: \t", list.length - i);
            printPart(list, 0, list.length - 1);
        }
    }
 
    // ��ӡ����
    public void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }
 
    
}