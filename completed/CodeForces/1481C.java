import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> replace = new HashMap<>();
            for(int i = 0; i < n; i++) {
                int b = Integer.parseInt(st.nextToken());
                map.put(b, i+1);
                if(b != a[i]) {
                    replace.putIfAbsent(b, new ArrayList<>());
                    replace.get(b).add(i+1);
                }
            }
            st = new StringTokenizer(f.readLine());
            int[] c = new int[m];
            for(int i = 0; i < m; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }
            int[] res = new int[m];
            int dummy = 0;
            boolean flag = false;
            for(int i = m-1; i >= 0; i--) {
                if(replace.containsKey(c[i])) {
                    res[i] = replace.get(c[i]).remove(0);
                    if(replace.get(c[i]).size() == 0) {
                        replace.remove(c[i]);
                    }
                    dummy = res[i];
                } else if(dummy > 0) {
                    res[i] = dummy;
                } else if(map.containsKey(c[i])) {
                    res[i] = map.get(c[i]);
                    dummy = res[i];
                } else {
                    flag = true;
                    break;
                }
            }
            if(flag || replace.size() > 0) {
                out.println("NO");
            } else {
                out.println("YES");
                out.print(res[0]);
                for(int i = 1; i < m; i++) {
                    out.print(" " + res[i]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}