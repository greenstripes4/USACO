import java.io.*;
import java.util.*;

public class Main {
    private static int root(int[] parentIds, int a) {
        while(a != parentIds[a]) {
            parentIds[a] = parentIds[parentIds[a]];
            a = parentIds[a];
        }
        return a;
    }
    private static void union(int[] parentIds, int[] groupSizes, int a, int b) {
        int rootA = root(parentIds, a);
        int rootB = root(parentIds, b);
        if(groupSizes[rootA] < groupSizes[rootB]) {
            parentIds[rootA] = rootB;
            groupSizes[rootB] += groupSizes[rootA];
        } else {
            parentIds[rootB] = rootA;
            groupSizes[rootA] += groupSizes[rootB];
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] parentIds = new int[N+1];
        int[] groupSize = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parentIds[i] = i;
            groupSize[i] = 1;
        }
        for(int i = 0; i < M; i++) {
            StringTokenizer connection = new StringTokenizer(f.readLine());
            connection.nextToken();
            int a = Integer.parseInt(connection.nextToken());
            int b = Integer.parseInt(connection.nextToken());
            union(parentIds, groupSize, a, b);
        }
        out.print("1");
        for(int i = 1; i <= N; i++) {
            if(i == root(parentIds, i)) {
                out.print("0");
            }
        }
        out.println();
        f.close();
        out.close();
    }
}
