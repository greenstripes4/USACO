import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCase = 1;
        while(true){
            int n = f.nextInt();
            int m = f.nextInt();
            if(n == 0 && m == 0){
                break;
            }
            int[] id = new int[n+1];
            int[] size = new int[n+1];
            for(int i = 1; i <= n; i++){
                id[i] = i;
                size[i] = 1;
            }
            for(int i = 0; i < m; i++){
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
            HashSet<Integer> set = new HashSet<>();
            for(int i = 1; i <= n; i++){
                int root = i;
                while(root != id[root]){
                    id[root] = id[id[root]];
                    root = id[root];
                }
                set.add(root);
            }
            out.println("Case "+ testCase + ": " + set.size());
            testCase++;
        }
        f.close();
        out.close();
    }
}
