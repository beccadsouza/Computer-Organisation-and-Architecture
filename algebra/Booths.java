package COA.algebra;
import static COA.algebra.Logic.*;

/*
 * Created by Rebecca D'souza on 21/02/2018.
 * */

public class Booths {
    public static int multiply(int multiplier, int multiplicand){
        System.out.println("Multiplying "+multiplier+" by "+multiplicand+" using Booth's Algorithm.");
        boolean twosFlag = false, negFlag = false;
        if(multiplicand*multiplier<0)
            negFlag = true;
        if(multiplier>=0)
            twosFlag = true;
        String A="";
        String M = Integer.toBinaryString(Math.abs(multiplicand));
        String Q = Integer.toBinaryString(Math.abs(multiplier));
        int t = Q.length();
        for(int i = 0;i<count-t;i++)
            Q = "0".concat(Q);
        int tp = M.length();
        for(int i = 0;i<count-tp;i++)
            M = "0".concat(M);
        M = twosComplement(M);
        if(multiplier<0)
            Q = twosComplement(Q);
        for(int i = 0;i<count;i++)
            A = A .concat("0");
        String q = "0";
        System.out.println("Initially\n"+"M = "+M+"\nQ = "+Q+"\nA = "+A+"\nq = "+q);
        for(int i = 0;i<count;i++){
            String temp = Q.substring(count-1)+q;
            System.out.println("\ncount = "+ i);
            if(temp.equalsIgnoreCase("01")){
                A = addBinary(A,M);
                System.out.println("Q0Q-1 = "+temp);
                System.out.println("A = A + M");
                System.out.println("A = "+A);
            }
            else if(temp.equalsIgnoreCase("10")){
                A = subtractBinary(A,M);
                System.out.println("Q0Q-1 = "+temp);
                System.out.println("A = A - M");
                System.out.println("A = "+A);
            }
            q = Q.substring(count-1);
            Q = A.substring(count-1)+Q.substring(0,count-1);
            A = A.substring(0,1)+A.substring(0,count-1);
            System.out.println("Right Shift");
            System.out.println("A = "+A+" Q = "+Q+" q = "+q+"\n\n");
        }
        String ans = A + Q;
        if(twosFlag){
            ans = twosComplement(ans);
            if(negFlag)
                return(-1*Integer.parseInt(ans,2));
            else return Integer.parseInt(ans,2);
        }
        else {
            if(negFlag)
                return (-1*Integer.parseInt(ans,2));
            else return Integer.parseInt(ans,2);
        }
    }
}