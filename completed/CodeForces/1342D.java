import java.io.*;
import java.util.*;

public class Main {
    private static int lower(ArrayList<ArrayList<Integer>> arr, int tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid).size() < tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        ArrayList<Integer> m = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            m.add(Integer.parseInt(st.nextToken())-1);
        }
        Collections.sort(m, Comparator.reverseOrder());
        st = new StringTokenizer(f.readLine());
        int[] c = new int[k];
        for(int i = 0; i < k; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i: m) {
            int idx = lower(res, c[i]);
            if(idx < 0) {
                res.add(new ArrayList<>());
                res.get(res.size()-1).add(i);
            } else {
                res.get(idx).add(i);
            }
        }
        out.println(res.size());
        for(ArrayList<Integer> i: res) {
            out.print(i.size());
            for(int j: i) {
                out.print(" " + (j+1));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
