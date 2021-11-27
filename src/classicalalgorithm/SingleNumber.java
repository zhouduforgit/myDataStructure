package classicalalgorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description TODO
 * @Author 周都
 * @Date 2021/9/19 16:12
 */
public class SingleNumber {
    /**
    * 思路一，先用hashMap存储nums中每个元素出现的个数
     * <Integer,Integer> key--->nums[i] value ---->itemCount
     * 遍历hashMap，若map.get(nums[i])>1 return nums[i]
    */
    public static int singleNumber1(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res =0;
        for (int i = 0; i < nums.length ; i++) {
            int element = nums[i];
            if(!hashMap.containsKey(element)) {
                hashMap.put(element,1);
            }else {
                hashMap.put(element, hashMap.get(element) + 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> entries = hashMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            Integer elementCount = entry.getValue();
            if (elementCount == 1) {
                res =  entry.getKey();
            }
        }
        return res;
    }
    /**
    * Description: 思路二，一遍遍历nums，一边把nums[i]存入hashset
     * 若 hashset中没有nums[i]就存入，然后往后遍历若存在nums[i]，说明此nums[i]重复出现了
     * 就把此nums[i]变成负数，循环结束后hashset中哪个元素是正数，哪个元素就是只出现过一次
     *
     *    原始数组 nums{1,2,2,1,4,5,5};
     *    hashset     {}
     *
    */
    public static int  singleNumber2(int[] nums) {
        int res = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i< nums.length; i++) {
            int element = nums[i];
            if(!hashSet.contains(element)) {
                hashSet.add(element);
            }else {
                hashSet.remove(element);
            }
        }
        return hashSet.iterator().next();
    }

    public static int singleNumber23(int[] nums) {
        int res = 0;
        if(nums != null && nums.length == 1) {
            return nums[0];
        }
        for(int i =0; i<nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static int hammingWeight(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        int chLength = ch.length;
        int ideaSum = chLength;
        int res = 0;
        for(int i=0; i < ch.length; i++) {
            res = res +(ch[i]-'0');
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numss = new int[]{1,2,2,1,4,5,5};
        int a = 00000000000000000000000010000000;
        String ch = String.valueOf(a);
        System.out.println(ch);
        System.out.println(singleNumber1(numss));
        System.out.println(singleNumber2(numss));
        System.out.println(singleNumber23(numss));
    }
}
