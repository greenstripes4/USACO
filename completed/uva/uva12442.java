import java.io.*;
import java.util.*;

public class Main{
    private static int dfs(int start, int[] passOns, HashSet<Integer> seen){
        int next = passOns[start];
        if(!seen.contains(next)){
            seen.add(start);
            return 1+dfs(next,passOns,seen);
        }
        return 0;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(f.readLine());
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken())-1;
                int v = Integer.parseInt(st.nextToken())-1;
                arr[u] = v;
            }
            int[] targets = new int[N];
            int max = -1;
            for(int i = 0; i < N; i++){
                targets[i] = dfs(i,arr,new HashSet<>());
                if(max == -1 || targets[i] > targets[max]){
                    max = i;
                }
            }
            out.println("Case " + (t+1) + ": " + (max+1));
        }
        f.close();
        out.close();
    }
}