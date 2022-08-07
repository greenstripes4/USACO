import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] ones = new int[n+1];
        int[] twos = new int[n+1];
        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            ones[i] = ones[i-1];
            twos[i] = twos[i-1];
            if(a[i] == 1) {
                ones[i]++;
            } else {
                twos[i]++;
            }
        }
        ArrayList<int[]> res = new ArrayList<>();
        for(int t = 1; t <= n; t++) {
            int s1 = 0;
            int s2 = 0;
            boolean last = false;
            int idx = 1;
            while(idx <= n) {
                int low = idx;
                int high = n;
                int ans = -1;
                while(low <= high) {
                    int mid = (low+high)/2;
                    if(Math.max(ones[mid]-ones[idx-1], twos[mid]-twos[idx-1]) >= t) {
                        high = mid-1;
                        ans = mid;
                    } else {
                        low = mid+1;
                    }
                }
                if(ans == -1) {
                    s1 = -1;
                    break;
                }
                if(ones[ans]-ones[idx-1] == t) {
                    s1++;
                    last = false;
                } else {
                    s2++;
                    last = true;
                }
                idx = ans+1;
            }
            if(s1 == -1 || s1 == s2 || (s1 > s2 && last) || (s2 > s1 && !last)) {
                continue;
            }
            res.add(new int[]{Math.max(s1, s2), t});
        }
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });
        out.println(res.size());
        for(int[] i: res) {
            out.println(i[0] + " " + i[1]);
        }
        f.close();
        out.close();
    }
}