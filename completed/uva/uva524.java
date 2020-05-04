import java.io.*;
import java.util.*;

public class Main{
    private static boolean isPrime(int n){
        int[] primeNumbers = {2,3,5,7,11,13,17,19,23,29,31};
        for(int prime: primeNumbers){
            if(prime == n){
                return true;
            }
        }
        return false;
    }
    private static void printSolutions(int n, boolean[] seen, int cur, int prev, int[] ans, PrintWriter out){
        if(cur == n){
            if(isPrime(prev+1)){
                for(int i = 0; i < n; i++){
                    if(i > 0){
                        out.print(" ");
                    }
                    out.print(ans[i]);
                }
                out.println();
            }
            return;
        }
        seen[prev] = true;
        for(int i = 2; i <= n; i++){
            if(!seen[i] && isPrime(prev+i)){
                ans[cur] = i;
                printSolutions(n,seen,cur+1,i,ans,out);
                ans[cur] = 0;
            }
        }
        seen[prev] = false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCase = 1;
        while(f.hasNext()){
            if(testCase > 1){
                out.println();
            }
            int n = f.nextInt();
            boolean[] seen = new boolean[n+1];
            seen[1] = true;
            out.println("Case " + testCase + ":");
            int[] ans = new int[n];
            ans[0] = 1;
            printSolutions(n,seen,1,1,ans,out);
            testCase++;
        }
        f.close();
        out.close();
    }
}
