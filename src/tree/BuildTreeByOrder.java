package tree;

import javax.xml.bind.annotation.XmlID;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author 周都
 * @Date 2021/6/5 22:36
 */
public class BuildTreeByOrder {
    /**
    * Description: 思路 根据前序遍历和中序遍历画出树
     * 这些前序、中序遍历的数组存在preOrder[]和middleOrder[]里
     * 在preOrder中索引越靠前越是根节点
     * 先在preOrder中找出整颗树的根节点root,并在middleOrder中记录root的索引index
     * root节点的左子树的节点个数就是index，
     * 再根据根节点root找出其左右子树
     * 在preOrder中左子树的范围[1,index+1)
     * 在middleOrder中左子树范围[0,index)
     * 在preOrder和middleOrder中右子树范围一样[index,end)
     * @author: 周都
    * @date: 2021/6/5 22:41
    * @param:
    * @return:
    */
    public static TreeNode buildTreeByOrder(int[] preOrder,int[] middleOrder){
        if (preOrder.length ==0){
            return null;
        }
        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        // 找出根节点在中序遍历中的索引，就是root左子树的节点的个数
        int leftSize = find(middleOrder,rootValue);
        //  求出root的左子树的前序和中序结果
        int[] leftPreOrder = Arrays.copyOfRange(preOrder,1,leftSize+1);
        int[] leftMiddleOrder = Arrays.copyOfRange(middleOrder,0,leftSize);
        root.left = buildTreeByOrder(leftPreOrder,leftMiddleOrder);
        int[] rightPreOrder = Arrays.copyOfRange(preOrder,leftSize+1,preOrder.length);
        int[] rightMiddleOrder = Arrays.copyOfRange(middleOrder,leftSize+1,preOrder.length);
        root.right = buildTreeByOrder(rightPreOrder,rightMiddleOrder);
        return root;
    }

    /**
    * Description: 思路二 通过后序和中序遍历生成树
     * 先在后续遍历的数组behindOrder找到最后一个索引元素，就是根节点root
     * 在中序遍历的数组meddleOrder里找到根节点的索引index
     * 根节点root 的左子树的中序、后序遍历的数组为
     * leftMiddleOrder = [0,index)
     * leftBehindOrder = [0,index)
     * 根节点root 的右子树的中序、后序遍历的数组为
     * rightMid= [index+1,len)
     * rightBehind =[index,index+1)
    * @author: 周都
    * @date: 2021/6/6 9:25
    * @param:
    * @return:
    */
    public static TreeNode buildTreeByOrder22(int[] meddleOrder,int[] behindOrder){
        if(behindOrder.length == 0) {
            return null;
        }
        int rootValue = behindOrder[behindOrder.length -1];
        TreeNode root = new TreeNode(rootValue);
        int index = find(meddleOrder, rootValue);
        int[] leftMiddleOrder = Arrays.copyOfRange(meddleOrder,0,index);
        int[] leftbefindOrder = Arrays.copyOfRange(behindOrder,0,index);
        root.left = buildTreeByOrder22(leftMiddleOrder,leftbefindOrder);
        int[] rightMiddleOrder = Arrays.copyOfRange(meddleOrder,index+1,meddleOrder.length);
        int[] rightBehindOrder = Arrays.copyOfRange(behindOrder,index,meddleOrder.length-1);
        root.right =buildTreeByOrder22(rightMiddleOrder,rightBehindOrder);
        return root;

    }
    // 此方法找出根节点在中序遍历中的索引
    public static int find(int[] array, int value) {
        for(int i =0; i<array.length; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preOrder = {1,2,3,4,5};
        int[] middleOrder ={3,4,2,1,5};
        TreeNode node1 =buildTreeByOrder(preOrder,middleOrder);
        System.out.println();
        int[] behindOrder = {4,3,2,5,1};
        TreeNode node2 = buildTreeByOrder22(middleOrder,behindOrder);
        System.out.println();
    }
}
