package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> mm1=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mm1.put(nums[i],i);
        }
        for (int i = 0; i <nums.length ; i++) {
            int tem=target-nums[i];
            if(mm1.containsKey(tem) && mm1.get(tem)!=i){
                return new int[]{i,mm1.get(tem)};
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> mm2=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(mm2.containsKey(temp)){
                return new int[]{i,mm2.get(temp)};
            }
            mm2.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int [] nnns={2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nnns,9)));
        System.out.println(Arrays.toString(twoSum2(nnns,26)));
    }
}
