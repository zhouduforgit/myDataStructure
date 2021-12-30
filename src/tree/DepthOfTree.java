package tree;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class DepthOfTree {
    //思路：数的深度就是根节点的左右子树较大深度+1
    public static int maxDepth(TreeNode root) {
        if(root ==null ){
            return 0;
        }
        int leftLength=maxDepth(root.left);
        int rightLength=maxDepth(root.right);
        return Math.max(leftLength,rightLength)+1;
    }

    public static void main(String[] args) {
        //先生成数
        TreeNode treeNode=new TreeNode(3);
        TreeNode leftTree=new TreeNode(9);
        treeNode.left=leftTree;
        TreeNode rightNode=new TreeNode(20);
        treeNode.right=rightNode;
        TreeNode rlt=new TreeNode(15);
        rightNode.left=rlt;
        TreeNode rrt=new TreeNode(7);
        rightNode.right=rrt;
        System.out.println(maxDepth(treeNode));
    }
}
