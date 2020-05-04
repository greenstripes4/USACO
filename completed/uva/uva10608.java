import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = f.nextInt();
        for(int i = 0; i < testCases; i++){
            int N = f.nextInt();
            int M = f.nextInt();
            int[] id = new int[N+1];
            int[] size = new int[N+1];
            for(int j = 1; j <= N; j++){
                id[j] = j;
                size[j] = 1;
            }
            for(int j = 0; j < M; j++){
                int p = f.nextInt();
                int q = f.nextInt();
                int rootP = p;
                while(rootP != id[rootP]){
                    id[rootP] = id[id[rootP]];
                    rootP = id[rootP];
                }
                int rootQ = q;
                while(rootQ != id[rootQ]){
                    id[rootQ] = id[id[rootQ]];
                    rootQ = id[rootQ];
                }
                if(size[rootP] < size[rootQ]){
                    id[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                } else {
                    id[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                }
            }
            HashMap<Integer,Integer> count = new HashMap<>();
            for(int j = 1; j <= N; j++){
                int root = j;
                while(root != id[root]){
                    id[root] = id[id[root]];
                    root = id[root];
                }
                count.put(root,count.getOrDefault(root,0)+1);
            }
            int max = 0;
            for(int j: count.values()){
                if(j > max){
                    max = j;
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
