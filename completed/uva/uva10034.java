import java.io.*;
import java.util.*;

public class Main{
    private static class Edge implements Comparable<Edge>{
        private int p1, p2;
        private double distance;
        private Edge(int p1, int p2, double distance) {
            this.p1 = p1;
            this.p2 = p2;
            this.distance = distance;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(distance, o.distance);
        }
    }
    private static int root(int[] parentIds, int p) {
        while(p != parentIds[p]) {
            parentIds[p] = parentIds[parentIds[p]];
            p = parentIds[p];
        }
        return p;
    }
    private static void union(int[] parentIds, int[] groupSizes, int p1, int p2) {
        int rootP1 = root(parentIds, p1);
        int rootP2 = root(parentIds, p2);
        if(groupSizes[rootP1] < groupSizes[rootP2]) {
            parentIds[rootP1] = rootP2;
            groupSizes[rootP2] += groupSizes[rootP1];
        } else {
            parentIds[rootP2] = rootP1;
            groupSizes[rootP1] += groupSizes[rootP2];
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("beads.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            f.readLine();
            if(t > 0) {
                out.println();
            }
            int n = Integer.parseInt(f.readLine());
            double[][] points = new double[n][2];
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                points[i][0] = Double.parseDouble(st.nextToken());
                points[i][1] = Double.parseDouble(st.nextToken());
                for(int j = 0; j < i; j++) {
                    queue.offer(new Edge(i, j, Math.sqrt((points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]))));
                }
            }
            int[] parentIds = new int[n];
            int[] groupSizes = new int[n];
            for(int i = 0; i < n; i++) {
                parentIds[i] = i;
                groupSizes[i] = 1;
            }
            double totalDistance = 0;
            while(!queue.isEmpty()) {
                Edge next = queue.poll();
                if(root(parentIds, next.p1) != root(parentIds, next.p2)) {
                    totalDistance += next.distance;
                    union(parentIds, groupSizes, next.p1, next.p2);
                }
            }
            out.printf("%.2f\n", totalDistance);
        }
        f.close();
        out.close();
    }
}
