package COA.memoryAllocation;

/*
 * Created by Rebecca D'souza on 05/03/2018
 * */
public class FirstFit {
    public static void main(String args[]){
        int[] memPart = new int[]{100, 500, 200, 300, 600};
        int [] procBlocks = new int[]{212,417,112,426};
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
}
/*
212 ----> 500( 500 - 212 = 288 NP )
417 ----> 600( 600 - 417 = 183 NP )
112 ----> 288( 288 - 112 = 176 NP )
426 ---->  WAIT

Process finished with exit code 0
*/