import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adjacencyList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        st = new StringTokenizer(f.readLine());
        int[] t = new int[n];
        Integer[] res = new Integer[n];
        for(int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
            res[i] = i+1;
        }
        Arrays.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t[integer-1]-t[t1-1];
            }
        });
        int[] topic = new int[n+1];
        boolean flag = false;
        for(int i: res) {
            boolean[] less = new boolean[t[i-1]];
            for(int j: adjacencyList[i]) {
                if(topic[j] == t[i-1]) {
                    flag = true;
                    break;
                }
                less[topic[j]] = true;
            }
            if(flag) {
                break;
            }
            for(int j = 1; j < t[i-1]; j++) {
                if(!less[j]) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
            topic[i] = t[i-1];
        }
        if(flag) {
            out.println(-1);
        } else {
            out.print(res[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}