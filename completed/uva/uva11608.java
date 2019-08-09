import java.io.*;
import java.util.*;
/*
O(n)
5
3 0 3 5 8 2 1 0 3 5 6 9
0 0 10 2 6 4 1 0 1 1 2 2
0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
100
20 20 20 20 20 20 20 20 20 20 20 20
20 20 20 20 20 20 20 20 20 20 20 20
-1
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int count = 1;
        while(!((input = f.readLine()).charAt(0) == '-')){
            int problems_available = Integer.parseInt(input);
            int[] production = new int[12];
            int[] needed = new int[12];
            StringTokenizer p = new StringTokenizer(f.readLine());
            for(int i = 0; i < 12; i++){
                production[i] = Integer.parseInt(p.nextToken());
            }
            StringTokenizer n = new StringTokenizer(f.readLine());
            for(int j = 0; j < 12; j++){
                needed[j] = Integer.parseInt(n.nextToken());
            }
            System.out.println("Case " + count + ":");
            for(int k = 0; k < 12; k++){
                if(problems_available >= needed[k]){
                    System.out.println( "No problem! :D");
                    problems_available -= needed[k];
                }
                else{
                    System.out.println("No problem. :(");
                }
                problems_available += production[k];
            }
            count++;
        }
    }
}
