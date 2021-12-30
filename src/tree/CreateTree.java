package tree;

import com.sun.prism.shader.DrawEllipse_LinearGradient_REFLECT_AlphaTest_Loader;
import linkedlist.Test1;

import java.util.LinkedList;
import java.util.List;


public class CreateTree {
    /**
    * Description: 创建一个int[] 存储每个节点的值
    * @author: 周都
    * @date: 2021/4/29 9:16
    */
    private static List<TreeNode> nodeList=new LinkedList<>();

    /**
    * Description: 创建一个List存储TreeNode节点
    * @author: 周都
    * @date: 2021/4/29 9:20
    * @param:
    * @return:
    */
    private static int[] array={1,2,3,4,5,6,7,8,9};

    /**
     * 此方法是生成树
     *   1 for循环创建节点并赋值，然后存入list
     *   2 设置所有节点的位置信息
     * @return
     */
    public static TreeNode createTree(){
        for(int i=0; i<array.length; i++){
            TreeNode treeNode=new TreeNode(array[i]);
            nodeList.add(treeNode);
        }
        // 某个节点的值是k，此节点的父节点是k/2;
        // 左子节点是2k,若右子节点存在则是2k+1
        int count=nodeList.size() /2;
        for(int j=0; j <count ; j++){
            //得到父节点
            TreeNode node=nodeList.get(j);
            //j是0开始的
            node.left=nodeList.get(2 * j+1);
            if(2 * j+2 <= nodeList.size()) {
                node.right = nodeList.get(2 * j + 2);
            }
        }
        return nodeList.get(0);
    }

    // 用数组创建二叉树
    // 根节点索引和其左右子树的索引的关系
    // index        2*index+1        2*index+2
    public static TreeNode createByArray(Integer[] arr, int index) {
        if(index >= arr.length) {
            return null;
        }
        if(arr[index] == null) {
            return  null;
        }
        TreeNode node = new TreeNode(arr[index]);
        node.left = createByArray(arr, 2*index + 1);
        node.right = createByArray(arr, 2*index + 2);
        return node;
    }
    public static void main(String[] args) {
        //TreeNode node=createTree();
        Integer[] arr1= {1,2,2,3,4,4,3};
        TreeNode node1=createByArray(arr1,0);
        System.out.println(node1);
        Integer[] arr2={1,2,12,1,1,3};
        TreeNode node2 = createByArray(arr2,0);
        System.out.println(node2);
        Integer[] arr3 = {1,2,2,null,3,null,3};
        TreeNode node3 = createByArray(arr3,0);
        System.out.println(node3);
    }
}
