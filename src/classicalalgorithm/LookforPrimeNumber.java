package classicalalgorithm;

public class LookforPrimeNumber {
    //此方法在leetCode中不行
    /*
        给出一个数 ， 判断从0到这个数的num之间的素数的个数
        并且打印哪个是素数哪个不是
     */
    public  static int countPrimes(int num) {
        int count=0;
        if(num==1){
            return 0;
        }
        for (int c=2;c<= num; c++) { //外层循环记录 c从2到num
            boolean bb=true; //bb表示此c是否是质数
            for (int i = 2; i <=c / 2; i++) { //内层循环判断是否是质数从,i是分母
                if (c % i == 0) {
                    bb =false;
                    System.out.println("此c："+c+"不是质素");
                    break;
                }
            }
            if(bb) {
                System.out.println("此c：" + c + "是质素");
                count++;
            }
        }
        return count;
    }

    //给定一个数n 判断i [2,n]范围内，有几个质数，分别是什么
    public static int countPrimes2(int n){
        int res=0;
        for(int i=2;i<n;++i){
            res+=isPrime(i)?1:0;
        }
        return res;
    }
    //判断输入的x是不是质数
    public static boolean isPrime(int x){
        for(int i=2;i*i<=x;i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int ccc=countPrimes(103);
        System.out.println(ccc);

       /* int cc2=countPrimes2(103);
        System.out.println(cc2);*/
    }
}
