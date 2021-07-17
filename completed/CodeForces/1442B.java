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
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            TreeMap<Integer, Integer> idx = new TreeMap<>();
            int[] val = new int[n+1];
            for(int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                idx.put(i, a);
                val[a] = i;
            }
            st = new StringTokenizer(f.readLine());
            int[] b = new int[k];
            HashSet<Integer> left = new HashSet<>();
            for(int i = 0; i < k; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                left.add(b[i]);
            }
            int ans = 1;
            for(int i: b) {
                Integer l = idx.lowerKey(val[i]);
                Integer h = idx.higherKey(val[i]);
                if(l == null) {
                    if(left.contains(idx.get(h))) {
                        ans = 0;
                        break;
                    }
                    idx.remove(h);
                } else if(h == null) {
                    if(left.contains(idx.get(l))) {
                        ans = 0;
                        break;
                    }
                    idx.remove(l);
                } else {
                    int vl = idx.get(l);
                    int vh = idx.get(h);
                    if(left.contains(vl) && left.contains(vh)) {
                        ans = 0;
                        break;
                    }
                    if(left.contains(vl)) {
                        idx.remove(h);
                    } else if(left.contains(vh)) {
                        idx.remove(l);
                    } else {
                        idx.remove(l);
                        ans = (ans*2)%998244353;
                    }
                }
                left.remove(i);
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}