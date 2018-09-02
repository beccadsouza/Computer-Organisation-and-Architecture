package COA.pageReplacement;
import java.util.*;

/*
 * Created by Rebecca D'souza on 23/02/2018
 * */

public class PageReplacement {
    private static HashMap<Integer,Character> hm1 = new HashMap<>();
    private static HashMap<Integer,Character> hm2 = new HashMap<>();
    private static HashMap<Integer,Character> hm3 = new HashMap<>();
    private static ArrayList<Character> al = new ArrayList<>();
    private static ArrayList<Integer> insertOrder = new ArrayList<>();
    private  static Integer getKey(char value){
        for (Object o : hm2.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            if ((Character) pair.getValue() == value)
                return (Integer) pair.getKey();
        }
        return -1;
    }
    private static int findIndex(List<Character> rem){
        int index =0,max =0,time;
        for(Integer y : hm3.keySet()){
            time = 0;
            for(Character x : rem){
                time++;
                if(hm3.get(y)==x)
                    break;
            }
            if(time>max){
                max = time;
                index = y;
            }
        }
        return index;
    }
    private static void FIFO(int n, int noFrames){
        System.out.println("\nFIFO algorithm : \n");
        System.out.println();
        int noHits = 0,front=0;
        for(int i = 0;i<n;i++){
        if(hm1.containsValue(al.get(i)))
            noHits++;
        else{
            hm1.put(front,al.get(i));
            front = (front+1)%noFrames;
        }
        System.out.println(al.get(i)+" "+hm1.values());
    }
        int x = n - noHits;
        System.out.println("No of Faults"+x);
        float faultRatio = (float)x/n;
        System.out.println("\nFAULT RATIO = "+faultRatio);

    }
    private static void LRU(int n, int noFrames){
        System.out.println("\nLRU algorithm : \n");
        System.out.println();
        int noHits = 0,index;
        for(int i = 0;i<noFrames;i++)
            insertOrder.add(i);
        for(int i = 0;i<n;i++){
            if(hm2.containsValue(al.get(i))){
                noHits++;
                insertOrder.remove(getKey(al.get(i)));
                insertOrder.add(getKey(al.get(i)));
            }
            else{
                index = insertOrder.get(0);
                hm2.put(index,al.get(i));
                insertOrder.remove(getKey(al.get(i)));
                insertOrder.add(index);
            }
            System.out.println(al.get(i)+" "+hm2.values());
        }
        int x = n - noHits;
        System.out.println("No of Faults"+x);
        float faultRatio = (float)x/n;
        System.out.println("\nFAULT RATIO = "+faultRatio);
    }
    private static void Optimal(int n, int noFrames){
        System.out.println("\nOptimal algorithm : \n");
        System.out.println();
        int noHits = 0,index;
        for(int i = 0;i<n;i++){
            if(hm3.containsValue(al.get(i)))
                noHits++;
            else if(hm3.size()>=noFrames){
                index = findIndex(al.subList(i+1,n));
                hm3.put(index,al.get(i));
            }
            else
                hm3.put(i,al.get(i));
            System.out.println(al.get(i)+" "+hm3.values());
        }
        int x = n - noHits;
        System.out.println("No of Faults"+x);
        float faultRatio = (float)x/n;
        System.out.println("\nFAULT RATIO = "+faultRatio);

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int noFrames = sc.nextInt(), n = sc.nextInt();
        for(int i = 0;i<n;i++)
            al.add(sc.next().charAt(0));
        FIFO(n,noFrames);
        LRU(n,noFrames);
        Optimal(n,noFrames);
    }
}
/*
4 10
C A D B E B A B C D

FIFO algorithm :

F1 F2 F3 F4
[C]
[C, A]
[C, A, D]
[C, A, D, B]
[E, A, D, B]
[E, A, D, B]
[E, A, D, B]
[E, A, D, B]
[E, C, D, B]
[E, C, D, B]

FAULT RATIO = 0.6

LRU algorithm :

F1 F2 F3 F4
[C]
[C, A]
[C, A, D]
[C, A, D, B]
[E, A, D, B]
[E, A, D, B]
[E, A, D, B]
[E, A, D, B]
[E, A, C, B]
[D, A, C, B]

FAULT RATIO = 0.7

Optimal algorithm :

F1 F2 F3 F4
[C]
[C, A]
[C, A, D]
[C, A, D, B]
[C, A, E, B]
[C, A, E, B]
[C, A, E, B]
[C, A, E, B]
[C, A, E, B]
[D, A, E, B]

FAULT RATIO = 0.6

Process finished with exit code 0

*/
