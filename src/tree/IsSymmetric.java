package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * 力扣101
 *给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class IsSymmetric {

    public static boolean isSymmetric2(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.right);
        queue.offer(root.left);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll(); //左子树
            TreeNode node2 = queue.poll(); //右子树
            if (node1 == null && node2  == null) {
                continue;
            }
            if(node1 == null || node2 ==null) {
                return false;
            }
            if(node1.val != node2.val) {
                return false;
            }
            // 把node1的左节点和node2的右节点 入栈
            queue.offer(node1.left);
            queue.offer(node2.right);
            // 把node1的右节点 和 node2左节点 入栈
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    /**
    * Description:
    * @author: 周都
    * @date: 2021/5/22 10:06
    * @param:
    * @return:
    */
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return  isMirror(root.left,root.right);
    }
    public static boolean isMirror(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }
        if(node1.val != node2.val) {
            return  false;
        }
        return isMirror(node1.left, node2.right)&& isMirror(node1.right, node2.left);
    }

    public static void main(String[] args) {
        Integer [] arr = new Integer[]{1,2,2,3,4,4,3};
        TreeNode node = CreateTree.createByArray(arr, 0);
        System.out.println(isSymmetric(node));

        Integer[] arr2 = new Integer[]{1,2,2,null,3,null,3};
        TreeNode node22 = CreateTree.createByArray(arr2, 0);
        System.out.println(isSymmetric2(node22));
    }
}
