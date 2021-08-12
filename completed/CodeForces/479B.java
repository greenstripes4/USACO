import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = i;
        }
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            Arrays.sort(b, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return a[integer]-a[t1];
                }
            });
            if(a[b[n-1]]-a[b[0]] < 2) {
                break;
            }
            a[b[n-1]]--;
            a[b[0]]++;
            res.add((b[n-1]+1) + " " + (b[0]+1));
        }
        Arrays.sort(a);
        out.println(a[n-1]-a[0] + " " + res.size());
        for(String i: res) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}
