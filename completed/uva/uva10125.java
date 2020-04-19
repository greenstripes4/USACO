import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")){
            int N = Integer.parseInt(input);
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(f.readLine());
            }
            Arrays.sort(arr);
            HashMap<Integer,int[]> aPlusB = new HashMap<>();
            for(int i = 0; i < arr.length; i++){
                for(int j = i+1; j < arr.length; j++){
                    aPlusB.put(arr[i]+arr[j],new int[]{i,j});
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++){
                for(int j = i+1; j < arr.length; j++){
                    if(aPlusB.containsKey(arr[j]-arr[i])){
                        int[] indicies = aPlusB.get(arr[j]-arr[i]);
                        if(indicies[0] != i && indicies[0] != j && indicies[1] != i && indicies[1] != j){
                            max = Math.max(arr[j],max);
                        }
                    }
                }
            }
            out.println(max == Integer.MIN_VALUE ? "no solution" : max);
        }
        f.close();
        out.close();
    }
}
