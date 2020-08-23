import java.io.*;
import java.util.*;

public class Main {
    private static int[] leaderIds;
    private static int[] groupSizes;
    private static HashSet<Integer>[] enemies;
    private static int find(int z) {
        while(z != leaderIds[z]) {
            leaderIds[z] = leaderIds[leaderIds[z]];
            z = leaderIds[z];
        }
        return z;
    }
    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) {
            return;
        }
        if(groupSizes[rootX] > groupSizes[rootY]) {
            leaderIds[rootY] = rootX;
            groupSizes[rootX] += groupSizes[rootY];
            for(int i: enemies[rootY]) {
                enemies[rootX].add(i);
            }
        } else {
            leaderIds[rootX] = rootY;
            groupSizes[rootY] += groupSizes[rootX];
            for(int i: enemies[rootX]) {
                enemies[rootY].add(i);
            }
        }
    }
    private static boolean setFriends(int x, int y) {
        if(areEnemies(x,y)) {
            return false;
        }
        union(x,y);
        return true;
    }
    private static boolean areFriends(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }
    private static boolean setEnemies(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) {
            return false;
        }
        enemies[rootX].add(rootY);
        enemies[rootY].add(rootX);
        for(int i: enemies[rootX]) {
            union(i,rootY);
        }
        for(int i: enemies[rootY]) {
            union(rootX,i);
        }
        return true;
    }
    private static boolean areEnemies(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return enemies[rootX].contains(rootY);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        leaderIds = new int[n+1];
        groupSizes = new int[n+1];
        enemies = new HashSet[n+1];
        for(int i = 0; i <= n; i++) {
            leaderIds[i] = i;
            groupSizes[i] = 1;
            enemies[i] = new HashSet<>();
        }
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int c = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(c == 0 && x == 0 && y == 0) {
                break;
            }
            if(c == 1) {
                if(!setFriends(x,y)) {
                    out.println(-1);
                }
            } else if(c == 2) {
                if(!setEnemies(x,y)) {
                    out.println(-1);
                }
            } else if(c == 3) {
                out.println(areFriends(x,y) ? 1:0);
            } else {
                out.println(areEnemies(x,y) ? 1:0);
            }
        }
        f.close();
        out.close();
    }
}
