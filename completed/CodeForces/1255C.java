import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0; i < n-2; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] q = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            map.putIfAbsent(q[0], new ArrayList<>());
            map.putIfAbsent(q[1], new ArrayList<>());
            map.putIfAbsent(q[2], new ArrayList<>());
            map.get(q[0]).add(q);
            map.get(q[1]).add(q);
            map.get(q[2]).add(q);
        }
        int[] cur = new int[3];
        for(int i: map.keySet()) {
            ArrayList<int[]> temp = map.get(i);
            if(temp.size() == 1) {
                cur[0] = i;
                for(int j: temp.get(0)) {
                    if(map.get(j).size() == 2) {
                        cur[1] = j;
                    } else if(map.get(j).size() == 3) {
                        cur[2] = j;
                    }
                }
                break;
            }
        }
        int[] res = new int[n];
        res[0] = cur[0];
        res[1] = cur[1];
        res[2] = cur[2];
        for(int i = 3; i < n; i++) {
            ArrayList<int[]> temp = map.get(cur[2]);
            int next = 0;
            for(int[] j: temp) {
                boolean flag1 = false;
                boolean flag2 = false;
                boolean flag3 = false;
                int ans = 0;
                for(int k = 0; k < 3; k++) {
                    if(j[k] == cur[1]) {
                        flag1 = true;
                    } else if(j[k] == cur[2]) {
                        flag2 = true;
                    } else if(j[k] == cur[0]) {
                        flag3 = true;
                        break;
                    } else {
                        ans = j[k];
                    }
                }
                if(flag1 && flag2 && !flag3) {
                    next = ans;
                    break;
                }
            }
            cur[0] = cur[1];
            cur[1] = cur[2];
            cur[2] = next;
            res[i] = next;
        }
        out.print(res[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}