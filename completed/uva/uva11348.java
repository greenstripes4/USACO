import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int K = Integer.parseInt(f.readLine());
        for(int t = 1; t <= K; t++) {
            int N = Integer.parseInt(f.readLine());
            HashSet<Integer>[] friends = new HashSet[N];
            HashSet<Integer> uniqueStamps = new HashSet<>();
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int M = Integer.parseInt(st.nextToken());
                friends[i] = new HashSet<>();
                HashSet<Integer> temp = new HashSet<>();
                for(int j = 0; j < M; j++) {
                    int A = Integer.parseInt(st.nextToken());
                    friends[i].add(A);
                    if(uniqueStamps.contains(A)) {
                        uniqueStamps.remove(A);
                    } else {
                        temp.add(A);
                    }
                }
                uniqueStamps.addAll(temp);
            }
            if(uniqueStamps.size() == 0) {
                out.println("Case " + t + ":");
                continue;
            }
            out.print("Case " + t + ":");
            for(int i = 0; i < N; i++) {
                int uniqueStampsOwned = 0;
                for(int j: friends[i]) {
                    if(uniqueStamps.contains(j)) {
                        uniqueStampsOwned++;
                    }
                }
                out.printf(" %.6f%%",uniqueStampsOwned*100.0/uniqueStamps.size());
            }
            out.println();
        }
        f.close();
        out.close();
    }
}