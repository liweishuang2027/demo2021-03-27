package javatest001;
/**
 * Javaʵ���ж����Ŷ������Ƿ���ͬ
 * @author lws
 *
 */
public class test0005 {
	
	public static void main(String[] args) {

        long startTime = System.currentTimeMillis();    //��ȡ��ʼʱ��

        TreeNode tree1 = new TreeNode(2);
        TreeNode tree2 = new TreeNode(3);
        TreeNode tree3 = new TreeNode(1, tree1, tree2);


        TreeNode tree4 = new TreeNode(2);
        TreeNode tree5 = new TreeNode(3);
        TreeNode tree6 = new TreeNode(1, tree4, tree5);
        System.out.println(isSameTree(tree3, tree6));

        long endTime = System.currentTimeMillis();    //��ȡ����ʱ��
        System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");    //�����������ʱ��
    }

	private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
