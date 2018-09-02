package COA.memoryAllocation;
import java.util.*;

/*
 * Created by Rebecca D'souza on 05/03/2018
 * */

public class MemoryAllocation {
    public static void bestFit(Integer memPart[], Integer procBlocks[]){
        System.out.println("\nBEST FIT : \n");
        for(int i = 0; i<procBlocks.length;i++){
            boolean allocated = false;
            Arrays.sort(memPart);
            for(int j = 0;j<memPart.length;j++){
                if(procBlocks[i]<=memPart[j]){
                    int newPart = memPart[j]-procBlocks[i];
                    System.out.println(procBlocks[i]+" ----> "+memPart[j]+"( "+memPart[j]+" - "+procBlocks[i]+" = "+newPart+" NP )");
                    memPart[j] = newPart;
                    allocated = true;
                    break;
                }
            }
            if(!allocated)
                System.out.println(procBlocks[i]+" ---->  WAIT");
        }
    }
    public static void firstFit(Integer memPart[], Integer procBlocks[]){
        System.out.println("\nFIRST FIT : \n");
        for(int i = 0; i<procBlocks.length;i++){
            boolean allocated = false;
            for(int j = 0;j<memPart.length;j++){
                if(procBlocks[i]<=memPart[j]){
                    int newPart = memPart[j]-procBlocks[i];
                    System.out.println(procBlocks[i]+" ----> "+memPart[j]+"( "+memPart[j]+" - "+procBlocks[i]+" = "+newPart+" NP )");
                    memPart[j] = newPart;
                    allocated = true;
                    break;
                }
            }
            if(!allocated)
                System.out.println(procBlocks[i]+" ---->  WAIT");
        }
    }
    public static void worstFit(Integer memPart[], Integer procBlocks[]){
        System.out.println("\nWORST FIT : \n");
        for(int i = 0; i<procBlocks.length;i++){
            boolean allocated = false;
            Arrays.sort(memPart, Collections.reverseOrder());
            for(int j = 0;j<memPart.length;j++){
                if(procBlocks[i]<=memPart[j]){
                    int newPart = memPart[j]-procBlocks[i];
                    System.out.println(procBlocks[i]+" ----> "+memPart[j]+"( "+memPart[j]+" - "+procBlocks[i]+" = "+newPart+" NP )");
                    memPart[j] = newPart;
                    allocated = true;
                    break;
                }
            }
            if(!allocated)
                System.out.println(procBlocks[i]+" ---->  WAIT");
        }
    }
    public static void main(String args[]){
        Integer [] memPart = new Integer[]{100, 500, 200, 300, 600};
        Integer [] procBlocks = new Integer[]{212,417,112,426};
        Integer [] memPart1 = new Integer[memPart.length];
        Integer [] memPart2 = new Integer[memPart.length];
        Integer [] memPart3 = new Integer[memPart.length];
        System.arraycopy(memPart,0,memPart1,0,memPart.length);
        System.arraycopy(memPart,0,memPart2,0,memPart.length);
        System.arraycopy(memPart,0,memPart3,0,memPart.length);
        firstFit(memPart1,procBlocks);
        bestFit(memPart2,procBlocks);
        worstFit(memPart3,procBlocks);
    }
}
/*

FIRST FIT :

212 ----> 500( 500 - 212 = 288 NP )
417 ----> 600( 600 - 417 = 183 NP )
112 ----> 288( 288 - 112 = 176 NP )
426 ---->  WAIT

BEST FIT :

212 ----> 300( 300 - 212 = 88 NP )
417 ----> 500( 500 - 417 = 83 NP )
112 ----> 200( 200 - 112 = 88 NP )
426 ----> 600( 600 - 426 = 174 NP )

WORST FIT :

212 ----> 600( 600 - 212 = 388 NP )
417 ----> 500( 500 - 417 = 83 NP )
112 ----> 388( 388 - 112 = 276 NP )
426 ---->  WAIT

Process finished with exit code 0
 */