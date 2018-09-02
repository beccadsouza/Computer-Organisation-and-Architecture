package COA.algebra;
import static COA.algebra.Logic.*;

/*
 * Created by Rebecca D'souza on 21/02/2018.
 * */

public class Restoring {
    public static void divide(int dividend, int divisor) {
        System.out.println("Dividing "+dividend+" by "+divisor+" using the Restoring Division Algorithm.");
        String Q = Integer.toBinaryString(dividend);
        String M = Integer.toBinaryString(divisor);
        String A = "";
        int t = Q.length();
        for (int i = 0; i < count - t; i++)
            Q = "0".concat(Q);
        int tp = M.length();
        for (int i = 0; i < count - tp; i++)
            M = "0".concat(M);
        for (int i = 0; i < count; i++)
            A = A.concat("0");
        System.out.println("Initially\n" + "M = " + M + "\nQ = " + Q + "\nA = " + A);
        for (int i = 0; i < count; i++) {
            System.out.println("\ncount = "+ i);
            A = A.substring(1) + Q.substring(0, 1);
            Q = Q.substring(1);
            System.out.println("Left Shift");
            System.out.println("A = " + A + " Q = " + Q);
            A = subtractBinary(A, M);
            System.out.println("A = A - M");
            System.out.println("A = " + A);
            if (A.substring(0, 1).equalsIgnoreCase("0")) {
                Q = Q.concat("1");
                System.out.println("Q = " + Q);
            } else {
                Q = Q.concat("0");
                A = addBinary(A, M);
                System.out.println("Q = " + Q);
                System.out.println("A = A + M");
                System.out.println("A = " + A);
            }
        }
        System.out.println("\n\nQuotient : " + Integer.parseInt(Q, 2));
        System.out.println("Remainder : " + Integer.parseInt(A, 2));
    }
}