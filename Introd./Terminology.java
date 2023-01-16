import java.io.*;

/**
 *  problem: the champion problem
 *    input: n distinct integers A[1], ..., A[n]
 *   output: the index i with 1 <= i <= n such that A[i] is the maximum value
 * 
 * instance: [7,4,2,9,8] -> 4 
 *    rules: comparison-based
 * 
 * hardness: how difficult to solve a problem
 *    solve: give an detailed step-by-step instruction that produces a correct output for any instance. 
 *           when upper bound is equal to lower bound, we will figure out the hardness of the problem.
 * 
 * [suffice/upper bound]: steps of a correct algorithm that can solve the problem
 * [necessary/lower bound of the hardness]: arguments that steps cannot be less than some value
 * 
 * [optimal]: upper and lower bounds match
 */

public class Terminology{
    public static void main(String[] args) throws IOException{
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); 
        int n = (int) in.nval;
        int[] A=new int[n+1];
        for(int i=1;i<=n;i++){
            in.nextToken();
            int a=(int) in.nval;
            A[i]=a;
        }

        // 非多此一举擂台法
        int index_boss=1;
        for(int i=2;i<=n;i++){
            if(A[i]>A[index_boss]){
                index_boss=i;
            }
        }
        System.out.println(index_boss);
    }
}