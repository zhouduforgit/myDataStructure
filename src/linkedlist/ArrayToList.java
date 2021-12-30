package linkedlist;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 此类的主要方法是把数组变成单项链表
 */
public class ArrayToList {
    private String data;
    private ArrayToList next;
    public  ArrayToList (String data){
        this.data=data;
    }

    public static ArrayToList arrayToList(String[] arr){
        if(arr.length==0) {
            return null;
        }
        //头节点
        ArrayToList first=new ArrayToList(arr[0]);
        //当前节点,当只有一个节点时 first.next==null, first就是next
        ArrayToList currentNode=first;
        for(int i=1;i<arr.length;i++){
            ArrayToList newNode=new ArrayToList(arr[i]);
            currentNode.next=newNode;
            currentNode=newNode;
        }
        return first;
    }


    public static void main(String[] args) {
        String[] arrr={"和平精英","王者荣耀","斗地主","植物大战僵尸","象棋"};
        ArrayToList list=arrayToList(arrr);
        System.out.println(list);
    }
}
