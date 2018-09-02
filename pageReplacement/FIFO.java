package COA.pageReplacement;
import java.util.*;
/*
 * Created by Rebecca D'souza on 23/02/2018
 * */
public class FIFO{
    private static HashMap<Integer,Character> hm = new HashMap<>();
    private static ArrayList<Character> al = new ArrayList<>();
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int noFrames = sc.nextInt(), n = sc.nextInt(), noHits = 0, front=0;
        for(int i = 0;i<n;i++)
            al.add(sc.next().charAt(0));
        for(int i = 1;i<=noFrames;i++)
            System.out.print("F"+i+" ");
        System.out.println();
        for(int i = 0;i<n;i++){
            if(hm.containsValue(al.get(i)))
                noHits++;
            else{
                hm.put(front,al.get(i));
                front = (front+1)%noFrames;
            }
            System.out.println(hm.values());
        }
        float faultRatio = 1 - (float)noHits/n;
        System.out.println("FAULT RATIO = "+faultRatio);
    }
}