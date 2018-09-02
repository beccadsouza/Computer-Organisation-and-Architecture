package COA.memoryAllocation;

import java.util.Arrays;
import java.util.Collections;

/*
 * Created by Rebecca D'souza on 05/03/2018
 * */
public class WorstFit {
    public static void main(String args[]){
        Integer [] memPart = new Integer[]{100, 500, 200, 300, 600};
        Integer [] procBlocks = new Integer[]{212,417,112,426};
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
}
/*
212 ----> 600( 600 - 212 = 388 NP )
417 ----> 500( 500 - 417 = 83 NP )
112 ----> 388( 388 - 112 = 276 NP )
426 ---->  WAIT

Process finished with exit code 0
*/