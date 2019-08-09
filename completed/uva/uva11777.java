import java.io.*;
import java.util.*;
/*
O(1)
6
15 18 25 8 15 17 12
20 20 30 10 20 20 20
20 20 30 10 18 0 0
15 18 25 8 6 6 6
15 18 25 8 0 0 0
0 0 0 0 0 0 0
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numTests = Integer.parseInt(f.readLine());
        for(int i = 0; i < numTests; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int term1 = Integer.parseInt(st.nextToken());
            int term2 = Integer.parseInt(st.nextToken());
            int finalTerm = Integer.parseInt(st.nextToken());
            int attendance = Integer.parseInt(st.nextToken());
            int[] tests = new int[3];
            tests[0] = Integer.parseInt(st.nextToken());
            tests[1] = Integer.parseInt(st.nextToken());
            tests[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(tests);
            int average = (tests[2] + tests[1])/2;
            int total = term1 + term2 + finalTerm + attendance + average;
            if(total >= 90){
                System.out.println("Case " + (i+1) + ": A");
            }
            else if(total >= 80){
                System.out.println("Case " + (i+1) + ": B");
            }
            else if(total >= 70){
                System.out.println("Case " + (i+1) + ": C");
            }
            else if(total >= 60){
                System.out.println("Case " + (i+1) + ": D");
            }
            else{
                System.out.println("Case " + (i+1) + ": F");
            }
        }
    }
}
