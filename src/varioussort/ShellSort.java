package varioussort;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * 希尔排序是插入排序的优化版
 * 把一段长的数组分成小段  比如原数组nums[] = {3,1,2,4,9,8,6,5}
 * 先以间距是4来对比  比如index=0和index=4的比，index=1和index=5, 2---6, 3---7
 * 小的在前面  大的在后面
 * 第一次后没有变化  {3,1,2,4,9,8,6,5}
 * 第二次 以间距是2来对比  0---2  1---3  2---4  3---5  4---6  5---7
 * index[0]=3  >  index[2]=2  交换 || index[1]=1 < index[3]=4 不交换
 *  * 交换后  2,1,3,4
 * index[2]=3 < index[4]=9  不交换 || index[3]=4 < index[5]=8  不交换
 *    交换后  2,1,3,4,9,8
 * index[4]=9 > index[6]=6    交换 || index[5]=8 > index[7]=5  交换
 *    交换后  2,1,3,4,6,5,9,8
 *    最后    1,2,3,4,5,6,7,8
 */
public class ShellSort {
    public static void main(String[] args) {
        File path = new File("src");
        String[] list;
        if(args.length == 0) {
            list = path.list();
        }else {
            list = path.list(filter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirname : list) {
            System.out.println(dirname);
        }
    }
    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
}
