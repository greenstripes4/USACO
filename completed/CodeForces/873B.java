import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] s = f.readLine().toCharArray();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = s[i] == '1' ? 1 : -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int cur = 0;
        for(int i = 0; i < n; i++) {
            cur += arr[i];
            ans = Math.max(ans, i-map.getOrDefault(cur, i));
            map.putIfAbsent(cur, i);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}