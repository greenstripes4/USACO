import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();
        for(int i = 0; i < p; i++) {
            sequences.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sequences.get(i%p).add(i);
        }
        st = new StringTokenizer(f.readLine());
        HashMap<Integer, Integer> b = new HashMap<>();
        for(int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            b.put(temp, b.getOrDefault(temp, 0)+1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(ArrayList<Integer> i: sequences) {
            if(i.size() < m) {
                continue;
            }
            int left = b.size();
            for(int j = 0; j < m; j++) {
                if(b.containsKey(a[i.get(j)])) {
                    b.put(a[i.get(j)], b.get(a[i.get(j)])-1);
                    if(b.get(a[i.get(j)]) == 0) {
                        left--;
                    }
                }
            }
            if(left == 0) {
                res.add(i.get(0)+1);
            }
            for(int j = m; j < i.size(); j++) {
                if(b.containsKey(a[i.get(j)])) {
                    b.put(a[i.get(j)], b.get(a[i.get(j)])-1);
                    if(b.get(a[i.get(j)]) == 0) {
                        left--;
                    }
                }
                if(b.containsKey(a[i.get(j-m)])) {
                    if(b.get(a[i.get(j-m)]) == 0) {
                        left++;
                    }
                    b.put(a[i.get(j-m)], b.get(a[i.get(j-m)])+1);
                }
                if(left == 0) {
                    res.add(i.get(j-m+1)+1);
                }
            }
            for(int j = i.size()-m; j < i.size(); j++) {
                if(b.containsKey(a[i.get(j)])) {
                    b.put(a[i.get(j)], b.get(a[i.get(j)])+1);
                }
            }
        }
        out.println(res.size());
        Collections.sort(res);
        for(int i: res) {
            out.print(i + " ");
        }
        out.println();
        f.close();
        out.close();
    }
}