import java.io.*;
import java.util.*;

public class Main{
    private static int root(int[] sccs, int id){
        while(id != sccs[id]){
            sccs[id] = sccs[sccs[id]];
            id = sccs[id];
        }
        return id;
    }
    private static void union(int[] sccs, int[] sizes, int a, int b){
        int rootA = root(sccs,a);
        int rootB = root(sccs,b);
        if(sizes[rootA] < sizes[rootB]){
            sccs[rootA] = rootB;
            sizes[rootB] += sizes[rootA];
        } else {
            sccs[rootB] = rootA;
            sizes[rootA] += sizes[rootB];
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int i = 0; i < testCases; i++){
            if(i > 0){
                out.println();
            }
            char max = f.readLine().charAt(0);
            int[] sccs = new int[max-'A'+1];
            int[] sizes = new int[max-'A'+1];
            for(int j = 0; j < max-'A'+1; j++){
                sccs[j] = j;
                sizes[j] = 1;
            }
            String connection;
            while((connection = f.readLine()) != null && connection.length() == 2){
                char a = connection.charAt(0);
                char b = connection.charAt(1);
                union(sccs,sizes,a-'A',b-'A');
            }
            HashSet<Integer> set = new HashSet<>();
            for(int j: sccs){
                set.add(root(sccs,j));
            }
            out.println(set.size());
        }
        f.close();
        out.close();
    }
}
