package JVMDemo;

public class JVMMemory {
    public static void main(String[] args) {
        // ���� Java �������ͼʹ�õ�����ڴ���
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("MAX_MEMORY = " + maxMemory + "���ֽڣ���" + (maxMemory / (double) 1024 / 1024) + "MB");
        // ���� Java ������е��ڴ�����
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("TOTAL_MEMORY = " + totalMemory + "���ֽڣ���" + (totalMemory / (double) 1024 / 1024) + "MB");
    }
}



