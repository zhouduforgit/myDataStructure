package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 力扣 T20
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：          示例 2：               示例 3：          示例 4：           示例 5：
 * 输入：s = "()"    输入：s = "()[]{}"     输入：s = "(]"    输入：s = "([)]"   输入：s = "{[]}"
 * 输出：true        输出：true             输出：false       输出：false        输出：true
 */
public class ValidBrackets {
    /**
     *  思路：有效的括号只有两种情况
     *      1:括号成双成对 比如： "{}[]()"
     *      2:括号以中线对称 比如 "{[()]}"
     *  暴力解法
     *      关键点在：一旦出现的反括号，反括号的前一个必须是对应的正括号
     *      创建2个下标  j和j+1 用判断是否是一对括号
     *      若是一对括号就删除，从头遍历，不是一对就往后移动
     *      每次删除一对减少2个长度，所以循环s.len/2次
     *      遍历在数组中间若 charAt(j)和charAt(j+1)不匹配就证明是不有效括号，就不需要往下遍历
     */
    public static boolean isValid1(String s) {
        StringBuilder ssbb=new StringBuilder(s);
        int count=ssbb.length()/2;
        for(int i=0;i<count;i++){
            for(int j=0;j<ssbb.length()-1;j++){
                char c1=ssbb.charAt(j);
                char c2=ssbb.charAt(j+1);
                if(isMatch(c1,c2)){
                    ssbb.delete(j,j+2);//delete（）左闭右开
                    break;
                }
            }
        }
        return ssbb.length()==0;
    }
    public static boolean isMatch(char c1,char c2){
        if(c1=='{')   return c2=='}';
        if (c1=='[')  return c2==']';
        if(c1=='(')  return c2==')';
        else   return false;
    }

    /**
     * 解法二：hashMap存三种括号的对应关系
     *  凡是出现右括号就要马上比较前一个是否是对应的左括号。
     *  因为暴力解法时间复杂度很高 n的平方：每次找到对应括号就删除并且重新开始遍历，每次循环数组长度的一半s.len/2
     *  所以要解决重复从头节点遍历问题。而且每次遍历的都是左括号。
     *  要找个数据结构来记录左括号的位置，或者删除左括号.类似边匹配便删除的思想
     *  栈空间可满足匹配的特点，循环越后面的左括号刚好存入栈顶。
     *  第一次出现的右括号和前面一个括号比较(就是栈顶的左括号)，
     *  若匹配就删除。删除后，新的栈顶的左括号方便和第二次出现的右括号匹配
     *  若循环结束栈是空的，说明匹配全部成功。
     */
    public static boolean isValid2(String s) {
        HashMap<Character,Character> hashMap=new HashMap<>(); //key是左括号，value右括号
        hashMap.put('{','}'); hashMap.put('[',']');  hashMap.put('(',')');
        char[] cchh=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (char cc:cchh){
            if(hashMap.containsKey(cc)){
                stack.push(cc);
            }else{ //右括号
                if(stack.isEmpty()) {
                    System.out.println("右括号出现之前没有左括号,右括号是第一个char");
                    return false;
                }
                char top=stack.peek();
                if(!hashMap.get(top).equals(cc)){
                    System.out.println("右括号和前面的左括号不匹配");
                    return false;
                }
                stack.pop(); //匹配取出栈顶左括号
            }
        }
        if(!stack.isEmpty()) {
            System.out.println("右括号抵消完毕后，还有多余的左括号");
            return false;
        }
        return true;
    }

    /**
     * 思路：如果出现左括号就马上存右括号
     * 若出现右括号就和栈顶的右括号比较，不管是不是一样都要弹出栈顶的右括号
     * 最后判断栈里有没有元素。若无则表示
     * @param ss
     * @return
     */
    public static boolean isValid3(String ss){
        Stack<Character> stack=new Stack<>();
        for(char cc:ss.toCharArray()){
            if(cc=='{'){
                stack.push('}');
            }else if(cc=='['){
                stack.push(']');
            }else if(cc=='('){
                stack.push(')');
            }else if(stack.isEmpty() || cc!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String ss="{}[]()()[]{}";
        System.out.println(isValid1(ss));
        String ss22="[]{(}])";
        System.out.println(isValid1(ss22));
        System.out.println("---=====----");
        String s1="{{])";
        String s2=")[]()";
        String s3="{([])";
        String s4="{[]}";
        System.out.println(isValid2(s1));
        System.out.println(isValid2(s2));
        System.out.println(isValid2(s3));
        System.out.println(isValid2(s4));
    }
}
