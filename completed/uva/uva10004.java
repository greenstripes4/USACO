import java.io.*;
import java.util.*;

public class Main{
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] colors;
    private static boolean bipartite(int currentNode, int currentColor) {
        colors[currentNode] = currentColor;
        for(int i: adjacencyList.get(currentNode)) {
            if(colors[i] == currentColor) {
                return false;
            }
            if(colors[i] == 0) {
                bipartite(i, currentColor == 1 ? 2 : 1);
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            int L = Integer.parseInt(f.readLine());
            adjacencyList = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int i = 0; i < L; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjacencyList.get(a).add(b);
                adjacencyList.get(b).add(a);
            }
            colors = new int[n];
            out.println(bipartite(1, 1) ? "BICOLORABLE." : "NOT BICOLORABLE.");
        }
        f.close();
        out.close();
    }
}
