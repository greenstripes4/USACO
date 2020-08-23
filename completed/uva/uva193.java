import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static int maximumBlackNodeCount;
    private static int[] colors;
    private static void colorGraph(int node, int currentBlackNodeCount, int[] currentColors) {
        if(node == currentColors.length) {
            if(currentBlackNodeCount > maximumBlackNodeCount) {
                maximumBlackNodeCount = currentBlackNodeCount;
                colors = currentColors.clone();
            }
            return;
        }
        currentColors[node] = 1;
        colorGraph(node+1,currentBlackNodeCount,currentColors);
        currentColors[node] = 0;
        boolean hasBlackNeighbor = false;
        for(int j: adjacencyList[node]) {
            if(currentColors[j] == 2) {
                hasBlackNeighbor = true;
                break;
            }
        }
        if(!hasBlackNeighbor) {
            currentColors[node] = 2;
            colorGraph(node+1,currentBlackNodeCount+1,currentColors);
            currentColors[node] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int m = f.nextInt();
        for(int t = 0; t < m; t++) {
            int n = f.nextInt();
            int k = f.nextInt();
            adjacencyList = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(int i = 0; i < k; i++) {
                int n1 = f.nextInt();
                int n2 = f.nextInt();
                adjacencyList[n1].add(n2);
                adjacencyList[n2].add(n1);
            }
            maximumBlackNodeCount = 0;
            colorGraph(1,0,new int[n+1]);
            out.println(maximumBlackNodeCount);
            boolean first = true;
            for(int i = 1; i <= n; i++) {
                if(colors[i] == 2) {
                    if(first) {
                        out.print(i);
                        first = false;
                    } else {
                        out.print(" " + i);
                    }
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
