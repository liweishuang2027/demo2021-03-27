package javatest001;

public class Get {
    //��ȡ����������ַ�ʽ
    public static void main(String[] args) throws ClassNotFoundException {
        //��ʽһ(ͨ����������)
        Student stu = new Student();
        Class classobj1 = stu.getClass();
        System.out.println(classobj1.getName());
        //��ʽ��������ͨ��·��-���·����
        Class classobj2 = Class.forName("javatest001.Student");
        System.out.println(classobj2.getName());
        //��ʽ����ͨ��������
        Class classobj3 = Student.class;
        System.out.println(classobj3.getName());
    }
}
