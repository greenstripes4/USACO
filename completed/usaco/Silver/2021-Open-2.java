import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] x = new int[N];
            for(int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(x);
            HashSet<Integer> candidates = new HashSet<>();
            for(int i = 0; i < N; i++) {
                candidates.add(x[i]);
                for(int j = i+1; j < N; j++) {
                    candidates.add(x[j]-x[i]);
                }
            }
            int ans = 0;
            for(int A: candidates) {
                for(int B: candidates) {
                    for(int C: candidates) {
                        if(A > B || B > C) {
                            continue;
                        }
                        HashMap<Integer, Integer> map = new HashMap<>();
                        map.put(A, map.getOrDefault(A, 0)+1);
                        map.put(B, map.getOrDefault(B, 0)+1);
                        map.put(C, map.getOrDefault(C, 0)+1);
                        map.put(A+B, map.getOrDefault(A+B, 0)+1);
                        map.put(A+C, map.getOrDefault(A+C, 0)+1);
                        map.put(B+C, map.getOrDefault(B+C, 0)+1);
                        map.put(A+B+C, map.getOrDefault(A+B+C, 0)+1);
                        boolean flag = false;
                        for(int i: x) {
                            if(!map.containsKey(i)) {
                                flag = true;
                                break;
                            }
                            map.put(i, map.get(i)-1);
                            if(map.get(i) == 0) {
                                map.remove(i);
                            }
                        }
                        if(!flag) {
                            ans++;
                        }
                    }
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
