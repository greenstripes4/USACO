import java.io.*;
import java.util.*;

public class Main {
    private static int root(int[] parentIds, int X) {
        while(X != parentIds[X]) {
            parentIds[X] = parentIds[parentIds[X]];
            X = parentIds[X];
        }
        return X;
    }
    private static void union(int[] parentIds, int[] groupSizes, int X, int Y) {
        int rootX = root(parentIds, X);
        int rootY = root(parentIds, Y);
        if(groupSizes[rootX] < groupSizes[rootY]) {
            parentIds[rootX] = rootY;
            groupSizes[rootY] += groupSizes[rootX];
        } else {
            parentIds[rootY] = rootX;
            groupSizes[rootX] += groupSizes[rootY];
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] cows = f.readLine().toCharArray();
        int[] parentIds = new int[N];
        int[] groupSizes = new int[N];
        for(int i = 0; i < N; i++) {
            parentIds[i] = i;
            groupSizes[i] = 1;
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(f.readLine());
            int X = Integer.parseInt(st.nextToken())-1;
            int Y = Integer.parseInt(st.nextToken())-1;
            if(cows[X] == cows[Y]) {
                union(parentIds, groupSizes, X, Y);
            }
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int Ai = Integer.parseInt(st.nextToken())-1;
            int Bi = Integer.parseInt(st.nextToken())-1;
            char Ci = st.nextToken().charAt(0);
            if(cows[Ai] == Ci || root(parentIds, Ai) != root(parentIds, Bi)) {
                out.print(1);
            } else {
                out.print(0);
            }
        }
        out.println();
        f.close();
        out.close();
    }
}
