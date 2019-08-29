import java.io.*;
import java.util.*;
/*
O(n^6)
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        boolean first = true;
        while(true){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int numInts = Integer.parseInt(st.nextToken());
            if(numInts == 0){
                break;
            }
            if(!first){
                out.println();
            } else {
                first = false;
            }
            int[] set = new int[numInts];
            for(int i = 0; i < numInts; i++){
                set[i] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < set.length; j++){
                for(int k = j+1; k < set.length; k++){
                    for(int l = k+1; l < set.length; l++){
                        for(int m = l+1; m < set.length; m++){
                            for(int n = m+1; n < set.length; n++){
                                for(int o = n+1; o < set.length; o++){
                                    out.println(set[j] + " " + set[k] + " " + set[l] + " " + set[m] + " " + set[n] + " " + set[o]);
                                }
                            }
                        }
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}
