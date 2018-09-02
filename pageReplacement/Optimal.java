package COA.pageReplacement;
import java.util.*;
/*
 * Created by Rebecca D'souza on 24/02/2018
 * */
public class Optimal {
    private static HashMap<Integer,Character> hm = new HashMap<>();
    private static ArrayList<Character> al = new ArrayList<>();
    private static int findIndex(List<Character> rem){
        int index =0,max =0,time;
        for(Integer y : hm.keySet()){
            time = 0;
            for(Character x : rem){
                time++;
                if(hm.get(y)==x)
                       break;
            }
            if(time>max){
                max = time;
                index = y;
            }
        }
        return index;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int noFrames = sc.nextInt(), n = sc.nextInt(), noHits = 0, index;
        for(int i = 0;i<n;i++)
            al.add(sc.next().charAt(0));
        for(int i = 0;i<n;i++){
            if(hm.containsValue(al.get(i)))
                noHits++;
            else if(hm.size()>=noFrames){
                index = findIndex(al.subList(i+1,n));
                hm.put(index,al.get(i));
            }
            else
                hm.put(i,al.get(i));
            System.out.println(hm.values());
        }
        float faultRatio = 1 - (float)noHits/n;
        System.out.println("FAULT RATIO = "+faultRatio);
    }
}