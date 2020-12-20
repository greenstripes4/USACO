import java.io.*;
import java.util.*;

public class Main{
    private static boolean bipartite(ArrayList<Integer>[] adjacencyList, int[] colors, int currentNode, int currentColor) {
        colors[currentNode] = currentColor;
        for(int i: adjacencyList[currentNode]) {
            if(colors[i] == currentColor) {
                return false;
            }
            if(colors[i] == 0) {
                bipartite(adjacencyList, colors, i, currentColor == 1 ? 2 : 1);
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
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            int L = Integer.parseInt(f.readLine());
            ArrayList<Integer>[] adjacencyList = new ArrayList[n];
            for(int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(int i = 0; i < L; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjacencyList[a].add(b);
                adjacencyList[b].add(a);
            }
            out.println(bipartite(adjacencyList, new int[n], 1, 1) ? "BICOLORABLE." : "NOT BICOLORABLE.");
        }
        f.close();
        out.close();
    }
}
