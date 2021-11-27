package classicalalgorithm;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description TODO
 * @Author 周都
 * @Date 2021/9/20 16:58
 */
public class Test {
    public static int[] twoSum(int[] numbers, int target) {
        int pre =0;
        int next =0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int j=0; j<numbers.length; j++) {
            hashMap.put(numbers[j],j);
        }
        for(int j=0; j<numbers.length; j++) {
            int cha =target -numbers[j];
            if(hashMap.containsKey(cha)){
                pre =j;
                next = hashMap.get(cha);
                break;
            }
        }
        return new int[]{pre+1,next+1};
    }
    public static boolean checkPermutation(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        int ch1Len = ch1.length;
        int ch2Length = ch2.length;
        int index = ch1Len > ch2Length?ch2Length:ch1Len;
        int count =0;
        while( count<index) {
            if(ch1[index] != ch2[index]) {
                return false;
            }
            count++;
        }
        return true;
    }
    public static int lengthOfLastWord(String s) {
        String changes = s.trim().replaceAll("\\s{1,}", " ");
        StringBuilder stringBuilder = new StringBuilder(changes);
        String ss22 =stringBuilder.reverse().toString();
        String space = " ";
        if(!ss22.contains(space)){
            return ss22.length();
        }

        int index =0;
        for(int i=0;i<ss22.length();i++ ){
            if(ss22.charAt(i)==' '){
                index = i;
                break;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println();
        String ss11= "aa bb    cc  dd  ee   cs";
        StringBuilder ssbb = new StringBuilder(ss11);
        String sss222 = ssbb.reverse().toString();
        // 把多个空格合并一个空格
        String tes =  ss11.replaceAll("\\s{1,}", " ");
        System.out.println(tes);
        String a  ="abc";
        String b = "bca";
      int[] numsss = {2,7,11,15};
        System.out.println(twoSum(numsss,9));
    }

}
