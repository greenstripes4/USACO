import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Integer[] idx = new Integer[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = x*a+y*b;
            idx[i] = i;
        }
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return arr[integer]-arr[t1];
            }
        });
        int i;
        for(i = 0; i < n && arr[idx[i]] <= d; i++) {
            d -= arr[idx[i]];
        }
        out.println(i);
        if(i > 0) {
            out.print(idx[0]+1);
            for(int j = 1; j < i; j++) {
                out.print(" " + (idx[j]+1));
            }
        }
        out.println();
        f.close();
        out.close();
    }
}
