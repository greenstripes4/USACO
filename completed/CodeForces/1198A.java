import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        TreeMap<Integer, Integer> a = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            int ai = Integer.parseInt(st.nextToken());
            a.put(ai, a.getOrDefault(ai, 0)+1);
        }
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i: a.keySet()) {
            arr.add(new int[]{i, a.get(i)});
        }
        int K = 1 << Math.min(20, 8*I/n);
        if(K > arr.size()) {
            out.println(0);
        } else {
            int in = 0;
            for(int i = 0; i < K; i++) {
                in += arr.get(i)[1];
            }
            int ans = in;
            for(int i = K; i < arr.size(); i++) {
                in += arr.get(i)[1];
                in -= arr.get(i-K)[1];
                ans = Math.max(ans, in);
            }
            out.println(n-ans);
        }
        f.close();
        out.close();
    }
}