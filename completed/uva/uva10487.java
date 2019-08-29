import java.io.*;
import java.util.*;
/*
O(n^2)
5
3
12
17
33
34
3
1
51
30
3
1
2
3
3
1
2
3
3
1
2
3
3
4
5
6
0
 */

public class Main{
    public static int pairSum(int[] pair){
        int sum = pair[0] + pair[1];
        return sum;
    }
    public static ArrayList<int[]> possiblePairs(int[] set){
        ArrayList<int[]> pairs = new ArrayList<>();
        for(int i = 0; i < set.length; i++){
            for(int j = i + 1; j < set.length; j++){
                int[] p = new int[]{set[i],set[j]};
                pairs.add(p);
            }
        }
        return pairs;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int count = 1;
        while(!((input = f.readLine()).equals("0"))){
            int numIntegers = Integer.parseInt(input);
            int[] sequence = new int[numIntegers];
            for(int i = 0; i < numIntegers; i++){
                sequence[i] = Integer.parseInt(f.readLine());
            }
            int numQueries = Integer.parseInt(f.readLine());
            ArrayList<int[]> pairs = possiblePairs(sequence);
            out.println("Case " + count + ":");
            for(int j = 0; j < numQueries; j++){
                Integer closest = null;
                Integer diff = null;
                int query = Integer.parseInt(f.readLine());
                for(int[] pair: pairs){
                    if(closest == null || Math.abs(pairSum(pair)-query) < diff){
                        closest = pairSum(pair);
                        diff = Math.abs(pairSum(pair)-query);
                    }
                }
                out.println("Closest sum to " + query + " is " + closest + ".");
            }
            count++;
        }
        f.close();
        out.close();
    }
}
