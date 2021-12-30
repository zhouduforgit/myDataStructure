package tree;

import jdk.nashorn.internal.ir.IfNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
* Description: 树的各种遍历方式
* @author: 周都
* @date: 2021/5/11 14:35
*/
public class TreeSearch {
    public static void main(String[] args) {
        TreeNode node= CreateTree.createTree();
        System.out.println("=========前序遍历==========");
        preOrder(node);
        System.out.println();
        preOrder2(node);
        System.out.println();

        System.out.println("======中序遍历=========");
        middleOrder(node);
        System.out.println();
        middleOrder2(node);
        System.out.println();

        System.out.println("=========后续遍历===========");
        behindOrder(node);
        System.out.println();
        behindOrder2(node);
        System.out.println();
        System.out.println("========广度优先遍历========");
        BFSSearch(node);



    }

    /** 此方法完成前序遍历  ：根 左 右 */
    public static void preOrder(TreeNode node){
        if( node == null ) {
            return ;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
    * Description: 不用递归完成先序遍历
     * 思路： 先序遍历 ，根左右
     * 用栈存储树的节点 入栈的顺序就是遍历的输出
     *  最先入栈是所有左子树
     *  当存入最底层的左子树时，就弹栈。弹到父节点判断此父节点有没有右子树若有弹出此父节点和左子树然后入栈右子树
    * @author: 周都
    * @date: 2021/5/11 15:16
    */
    public static void preOrder2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        // 用变量p 记录当前节点
        TreeNode point=node;
        while (point != null || !stack.isEmpty()) {
            //入栈 先把最底层的左子树和其所有的根节点存入栈
            // 入栈顺序 ： 根节点-->左子树--->第二层左子树-->第三层左子树--->最底层左子树
            while(point != null) {
                System.out.print(point.val+" ");
                stack.push(point);
                point = point.left;
            }
            // 弹栈 先谈出栈顶 最底层左子树 再弹出其父节点
            // 若这父节点有右子树 先弹出父节点再 point指向其右子树
            if (!stack.isEmpty()) {
                point = stack.pop();
                point = point.right;
            }
        }
    }
    /**  此方法完成中序遍历  左根右 */
    public static void middleOrder(TreeNode node){
        if( node == null ) {
            return;
        }
        middleOrder(node.left);
        System.out.print(node.val+" ");
        middleOrder(node.right);
    }

    /**
    * Description:  中序遍历的非递归方法
     * 思路前序遍历的出栈顺序就是树的中序遍历
    * @author: 周都
    * @date: 2021/5/22 8:57
    * @param:
    * @return:
    */
    public static void middleOrder2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        // 用变量p 记录当前节点
        TreeNode point=node;
        while (point != null || !stack.isEmpty()) {
            //入栈 先把最底层的左子树和其所有的根节点存入栈
            // 入栈顺序 ： 根节点-->左子树--->第二层左子树-->第三层左子树--->最底层左子树
            while(point != null) {
                stack.push(point);
                point = point.left;
            }
            // 弹栈 先谈出栈顶 最底层左子树 再弹出其父节点
            // 若这父节点有右子树 先弹出父节点再 point指向其右子树
            if (!stack.isEmpty()) {
                point = stack.pop();
                System.out.print(point.val+" ");
                point = point.right;
            }
        }
    }
    /** 此方法完成后序遍历  ：左 右 根 */
    public static void behindOrder(TreeNode node){
        if(node == null) {
            return;
        }
        behindOrder(node.left);
        behindOrder(node.right);
        System.out.print(node.val+" ");
    }

    /**
    * Description: 后续遍历非递归形式，左右根
     * 思路：先把所有的左子树压栈
     *  出栈时2种情况
     *  1 当前节点时叶子节点
     *  2 上一次出栈的节点时当前节点的右子树
    * @author: 周都
    * @date: 2021/5/22 9:06
    */
    public static void behindOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = node;
        TreeNode prevNode = null;
        while (currNode != null || !stack.isEmpty()) {
            // 入栈压入所有左子树
            while(currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            // 出栈 谈出栈顶元素 找到栈顶元素的根节点的右子树
            if(!stack.isEmpty()) {
                currNode = stack.pop();
                if(currNode.right == null || prevNode == currNode.right) {
                    System.out.print(currNode.val + " ");
                    prevNode = currNode;
                    currNode =null;
                }else {
                    stack.push(currNode);
                    currNode = currNode.right;
                }
            }
        }
    }

    /** 树的广度优先BFS  一层一层的遍历
     *  队列的出队顺序就是广度优先遍历的结果
     * */
    public static void BFSSearch(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 存入树的根节点
        queue.offer(node);
        while (queue.size() > 0) {
            TreeNode Fnode=queue.poll();
            System.out.print(Fnode.val + " ");
            if (Fnode.left != null) {
                queue.offer(Fnode.left);
            }
            if (Fnode.right != null) {
                queue.offer(Fnode.right);
            }
        }
    }
}
