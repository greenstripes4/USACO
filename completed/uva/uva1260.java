import java.io.*;
import java.util.*;
/*
O(n^2)
2
5
38 111 102 111 177
8
276 284 103 439 452 276 452 398
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int numTestCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numTestCases; i++){
            int numDays = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] sales = new int[numDays];
            for(int j = 0; j < numDays; j++){
                sales[j] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            for(int k = 0; k < numDays; k++){
                int count = 0;
                for(int l = 0; l < k; l++){
                    if(sales[l] <= sales[k]){
                        count++;
                    }
                }
                sum += count;
            }
            out.println(sum);
        }
        f.close();
        out.close();
    }
}
