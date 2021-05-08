import java.io.*;
import java.util.*;

public class Main {
    private static long[] arr;
    private static TreeMap<Long, TreeSet<Integer>> map;
    private static void dfs(int idx, int end, long sum, int nums) {
        if(idx == end) {
            map.putIfAbsent(sum, new TreeSet<>());
            map.get(sum).add(nums);
            return;
        }
        dfs(idx+1, end, sum, nums);
        dfs(idx+1, end, sum+arr[idx], nums+1);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int N = Integer.parseInt(input);
            StringTokenizer st = new StringTokenizer(f.readLine());
            arr = new long[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            map = new TreeMap<>();
            dfs(0, N/2, 0, 0);
            TreeMap<Long, TreeSet<Integer>> first = new TreeMap<>(map);
            map = new TreeMap<>();
            dfs(N/2, N, 0, 0);
            long min = Long.MAX_VALUE;
            int nums = N+1;
            for(long i: first.keySet()) {
                Long lower = map.floorKey(-i);
                Long higher = map.ceilingKey(-i);
                if(lower != null && (Math.abs(i+lower) < min || (Math.abs(i+lower) == min && map.get(lower).first() < nums))) {
                    min = Math.abs(i+lower);
                    nums = first.get(i).first()+map.get(lower).first();
                }
                if(higher != null && (Math.abs(i+higher) < min || (Math.abs(i+higher) == min && map.get(higher).first() < nums))) {
                    min = Math.abs(i+higher);
                    nums = first.get(i).first()+map.get(higher).first();
                }
            }
            out.println(min + " " + nums);
        }
        f.close();
        out.close();
    }
}