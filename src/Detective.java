/**
 * @Description TODO
 * @Author 周都
 * @Date 2021/6/6 10:43
 */
public class Detective {
    public static void main(String[] args) {
        int A,B,C,D,E,F;
        int t1,t2,t3,t4,t5,t6;
        for(A=0; A<=1; A++) {
            for(B=0; B<=1; B++){
                for(C=0; C<=1; C++){
                    for(D=0; D<=1; D++){
                        for(E=0; E<=1; E++){
                            for(F=0; F<=1; F++){
                                t1 = A|B;
                                t2 = (A&E) | (A&F) | (E&F);
                                t3 = ~(A&D);
                                t4 = (B&C) | (~B&~C);
                                t5 = (C&~D) | (~C&D);
                                t6 = D|(~D&~E);
                                int t = t1 & t2 & t3 & t4 & t5 & t6;
                                if(t == 1) {
                                    System.out.printf("%d%d%d%d%d%d",A,B,C,D,E,F);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
