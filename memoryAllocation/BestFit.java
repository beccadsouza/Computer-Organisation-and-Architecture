package COA.memoryAllocation;

import java.util.Arrays;
/*
* Created by Rebecca D'souza on 05/03/2018
* */
public class BestFit {
    public static void main(String args[]){
        int[] memPart = new int[]{100, 500, 200, 300, 600};
        int [] procBlocks = new int[]{212,417,112,426};
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
}
/*
212 ----> 300( 300 - 212 = 88 NP )
417 ----> 500( 500 - 417 = 83 NP )
112 ----> 200( 200 - 112 = 88 NP )
426 ----> 600( 600 - 426 = 174 NP )

Process finished with exit code 0
*/