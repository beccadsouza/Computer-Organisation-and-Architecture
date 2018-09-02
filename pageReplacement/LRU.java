package COA.pageReplacement;
import java.util.*;
/*
 * Created by Rebecca D'souza on 23/02/2018
 * */
public class LRU{
    private static HashMap<Integer,Character> hm = new HashMap<>();
    private static ArrayList<Character> al = new ArrayList<>();
    private static ArrayList<Integer> insertOrder = new ArrayList<>();
    private  static Integer getKey(char value){
        for (Object o : hm.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            if ((Character) pair.getValue() == value)
                return (Integer) pair.getKey();
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int noFrames = sc.nextInt(), n = sc.nextInt(), noHits = 0, index;
        for(int i = 0;i<noFrames;i++)
            insertOrder.add(i);
        for(int i = 0;i<n;i++)
            al.add(sc.next().charAt(0));
        for(int i = 0;i<n;i++){
            if(hm.containsValue(al.get(i))){
                noHits++;
                insertOrder.remove(getKey(al.get(i)));
                insertOrder.add(getKey(al.get(i)));
            }
            else{
                index = insertOrder.get(0);
                hm.put(index,al.get(i));
                insertOrder.remove(getKey(al.get(i)));
                insertOrder.add(index);
            }
            System.out.println(hm.values());
        }
        float faultRatio = 1 - (float)noHits/n;
        System.out.println("FAULT RATIO = "+faultRatio);
    }
}