import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int i = 0;
        int j = 0;
        ArrayList<TreeMap<Integer, Integer>> maps = new ArrayList<>(m);
        for(int l = 0; l < m; l++) {
            maps.add(new TreeMap<>());
            maps.get(l).put(0, 1);
        }
        int max = 0;
        int[] res = new int[m];
        while(j <= n) {
            int[] cur = new int[m];
            int sum = 0;
            for(int l = 0; l < m; l++) {
                cur[l] = maps.get(l).lastKey();
                sum += cur[l];
            }
            if(sum <= k) {
                if(j-i > max) {
                    max = j-i;
                    res = cur;
                }
                if(j == n) {
                    break;
                }
                for(int l = 0; l < m; l++) {
                    TreeMap<Integer, Integer> temp = maps.get(l);
                    temp.put(a[j][l], temp.getOrDefault(a[j][l], 0)+1);
                }
                j++;
            } else {
                for(int l = 0; l < m; l++) {
                    TreeMap<Integer, Integer> temp = maps.get(l);
                    temp.put(a[i][l], temp.get(a[i][l])-1);
                    if(temp.get(a[i][l]) == 0) {
                        temp.remove(a[i][l]);
                    }
                }
                i++;
            }
        }
        out.print(res[0]);
        for(int l = 1; l < m; l++) {
            out.print(" " + res[l]);
        }
        out.println();
        f.close();
        out.close();
    }
}