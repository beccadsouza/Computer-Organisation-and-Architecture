package COA.algebra;

/*
 * Created by Rebecca D'souza on 21/02/2018.
 * */

public class Logic {
    public static int count=16;
    static String addBinary(String a, String b) {
        int aBit,bBit,carry = 0,temp;
        StringBuilder sum = new StringBuilder();
        for(int i = count-1;i>=0;i--){
            aBit = Integer.parseInt(a.substring(i,i+1));
            bBit = Integer.parseInt(b.substring(i,i+1));
            temp = aBit^bBit^carry;
            carry = (aBit&bBit)|(aBit&carry)|(bBit&carry);
            sum.append(String.valueOf(temp));
        }
        return sum.reverse().toString();
    }
    static String twosComplement(String B){
        boolean flag = false;
        StringBuilder b = new StringBuilder(B);
        for(int i = b.length()-1;i>=0;i--){
            if(b.charAt(i)=='1' && !flag) {
                flag = true;
            }
            else if(flag)
                if(b.charAt(i)=='1')
                    b.replace(i,i+1,"0");
                else b.replace(i,i+1,"1");
        }
        return b.toString();
    }
    static String subtractBinary(String a, String b){
        b = twosComplement(b);
        return addBinary(a,b);
    }
}