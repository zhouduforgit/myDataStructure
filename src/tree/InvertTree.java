package tree;

import sun.reflect.generics.tree.Tree;

/**
 * @Description TODO
 * @Author 周都
 * @Date 2021/6/5 9:01
 */
public class InvertTree {
    /**
    * Description:
     * 思路 ：把根节点的左右子树交换（root.left node1 <--> node2 root.right）
     * 再把 左子树node1的左右子树交换，右子树node2的左右子树交换
     * 这是前序遍历 根左右
    * @author: 周都
    * @date: 2021/6/5 9:02
    * @param:
    * @return:
    */
    public static TreeNode invertTreeByPre(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeByPre(root.left);
        invertTreeByPre(root.right);
        return root;
    }
    /**
    * Description: 思路2 参照中序遍历 左根右
     * 先交换根节点的左子树node1的左右子树
     * 再把根节点的左右子树 node1和node2交换
     * 交换后原来的右子树node2变成左子树
     * 交换当前的根节点的左子树node2的左右子树
    * @author: 周都
    * @date: 2021/6/5 9:42
    * @param:
    * @return:
    */
    public static TreeNode invertTreeByMiddle(TreeNode root) {
        if(root == null) {
            return null;
        }
        invertTreeByMiddle(root.left);
        TreeNode temporary = root.left;
        root.left =root.right;
        root.right = temporary;
        invertTreeByMiddle(root.left);
        return root;
    }

    public static TreeNode invertTreeByBehind(TreeNode root) {
        if(root == null) {
            return null;
        }
        invertTreeByBehind(root.left);
        invertTreeByBehind(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,2,7,1,3,6,9};
        TreeNode node = CreateTree.createByArray(arr,0);
        invertTreeByBehind(node);
        System.out.println();
    }
}
