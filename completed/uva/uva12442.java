import java.io.*;
import java.util.*;

public class Main{
    private static int dfs(int start, int[] passOns, boolean[] seen, int[] targets, boolean[] currentSeen){
        int next = passOns[start];
        if(!currentSeen[next]) {
            seen[start] = true;
            currentSeen[start] = true;
            return 1+dfs(next,passOns,seen,targets,currentSeen);
        }
        return targets[next];
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(f.readLine());
            int[] arr = new int[N+1];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u] = v;
            }
            int[] targets = new int[N+1];
            boolean[] seen = new boolean[N+1];
            int max = -1;
            for(int i = 1; i <= N; i++){
                if(!seen[i]) {
                    targets[i] = dfs(i,arr,seen,targets,new boolean[N+1]);
                    if (max == -1 || targets[i] > targets[max]) {
                        max = i;
                    }
                }
            }
            out.println("Case " + t + ": " + max);
        }
        f.close();
        out.close();
    }
}