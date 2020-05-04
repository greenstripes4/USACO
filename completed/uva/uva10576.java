import java.io.*;
import java.util.*;

public class Main{
    private static int[] values;
    private static int max;
    private static void dfs(int ind, int s, int d){
        if(ind == 12){
            for(int i = 0; i < 8; i++){
                int sum = 0;
                for(int j = 0; j < 5; j++){
                    sum += values[i+j];
                }
                if(sum > 0){
                    return;
                }
            }
            int earnings = 0;
            for(int i = 0; i < 12; i++){
                earnings += values[i];
            }
            max = Math.max(max,earnings);
            return;
        }
        values[ind] = s;
        dfs(ind+1,s,d);
        values[ind] = -d;
        dfs(ind+1,s,d);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()){
            int s = f.nextInt();
            int d = f.nextInt();
            values = new int[12];
            max = -1;
            dfs(0,s,d);
            out.println(max == -1 ? "Deficit":max);
        }
        f.close();
        out.close();
    }
}
