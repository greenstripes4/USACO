import java.io.*;
import java.util.*;

public class Main {
        private static class Edge implements Comparable<Edge> {
                private int a;
                private int b;
                private int idx;
                private Edge(int a, int b, int idx) {
                        this.a = a;
                        this.b = b;
                        this.idx = idx;
                }
                @Override
                public int compareTo(Edge o) {
                        if(a == o.a) {
                                return o.b-b;
                        }
                        return a-o.a;
                }
        }
        public static void main(String[] args) throws IOException{
                //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                StringTokenizer st = new StringTokenizer(f.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int[][] res = new int[m][2];
                Edge[] edges = new Edge[m];
                for(int i = 0; i < m; i++) {
                        st = new StringTokenizer(f.readLine());
                        edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
                }
                Arrays.sort(edges);
                int[] cur = new int[n];
                for(int i = 0; i < n; i++) {
                        cur[i] = i;
                }
                int end = 0;
                boolean flag = false;
                int ext = 1;
                for(Edge e: edges) {
                        if(e.b == 1) {
                                res[e.idx][1] = ++end;
                        } else {
                                if(cur[ext] >= end) {
                                        flag = true;
                                        out.println(-1);
                                        break;
                                }
                                res[e.idx][0] = ext;
                                res[e.idx][1] = ++cur[ext];
                                if(cur[ext] >= end) {
                                        ext++;
                                        if(ext >= end) {
                                                ext = 1;
                                        }
                                }
                        }
                }
                if(!flag) {
                        for(int[] i: res) {
                                out.println((i[0]+1) + " " + (i[1]+1));
                        }
                }
                f.close();
                out.close();
    }
}
