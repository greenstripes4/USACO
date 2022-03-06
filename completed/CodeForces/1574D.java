import java.io.*;
import java.util.*;

public class Main {
    private static class Build implements Comparable<Build> {
        private int strength;
        private int[] items;
        private Build(int strength, int[] items) {
            this.strength = strength;
            this.items = items;
        }
        @Override
        public int compareTo(Build o) {
            return o.strength-strength;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(items[0]+1);
            for(int i = 1; i < items.length; i++) {
                sb.append(" ");
                sb.append(items[i]+1);
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] a = new int[n][];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int c = Integer.parseInt(st.nextToken());
            a[i] = new int[c];
            for(int j = 0; j < c; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int m = Integer.parseInt(f.readLine());
        HashSet<String> banned = new HashSet<>();
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int strength = 0;
            int[] items = new int[n];
            for(int j = 0; j < n; j++) {
                items[j] = Integer.parseInt(st.nextToken())-1;
                strength += a[j][items[j]];
            }
            Build temp = new Build(strength, items);
            banned.add(temp.toString());
        }
        PriorityQueue<Build> queue = new PriorityQueue<>();
        HashSet<String> visited = new HashSet<>();
        int maxStrength = 0;
        int[] maxItems = new int[n];
        for(int i = 0; i < n; i++) {
            maxItems[i] = a[i].length-1;
            maxStrength += a[i][maxItems[i]];
        }
        Build maxBuild = new Build(maxStrength, maxItems);
        queue.offer(maxBuild);
        visited.add(maxBuild.toString());
        while(!queue.isEmpty()) {
            Build cur = queue.poll();
            String hash = cur.toString();
            if(!banned.contains(hash)) {
                out.println(hash);
                break;
            }
            for(int i = 0; i < n; i++) {
                if(cur.items[i] > 0) {
                    int[] temp = cur.items.clone();
                    temp[i]--;
                    int strength = cur.strength-a[i][cur.items[i]]+a[i][temp[i]];
                    Build next = new Build(strength, temp);
                    String nextHash = next.toString();
                    if(!visited.contains(nextHash)) {
                        queue.offer(next);
                        visited.add(nextHash);
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}
