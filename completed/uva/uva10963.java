import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
4

5
2 1
0 -1
1 0
1 0
2 1

4
4 2
6 3
5 3
4 1

3
100 -100
100 100
-100 100

3
0 0
100 0
0 -100
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int numCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numCases; i++){
            f.readLine();
            int numCols = Integer.parseInt(f.readLine());
            int[] values = new int[numCols];
            for(int j = 0; j < numCols; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                values[j] = num1-num2;
            }
            int lookFor = values[0];
            boolean yes = true;
            for(int k: values){
                if(k != lookFor){
                    yes = false;
                }
            }
            if(yes){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
            if(i != numCases-1){
                System.out.println();
            }
        }
    }
}