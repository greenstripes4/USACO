import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[N];
        ArrayList<TreeMap<Integer, Integer>> arr = new ArrayList<>();
        for(int i = 0; i < 200000; i++) {
            arr.add(new TreeMap<>());
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken())-1;
            arr.get(B[i]).put(A[i], arr.get(B[i]).getOrDefault(A[i], 0)+1);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(TreeMap<Integer, Integer> i: arr) {
            if(!i.isEmpty()) {
                map.put(i.lastKey(), map.getOrDefault(i.lastKey(), 0)+1);
            }
        }
        while(Q-- > 0) {
            st = new StringTokenizer(f.readLine());
            int C = Integer.parseInt(st.nextToken())-1;
            int D = Integer.parseInt(st.nextToken())-1;
            map.put(arr.get(B[C]).lastKey(), map.get(arr.get(B[C]).lastKey())-1);
            if(map.get(arr.get(B[C]).lastKey()) == 0) {
                map.remove(arr.get(B[C]).lastKey());
            }
            arr.get(B[C]).put(A[C], arr.get(B[C]).get(A[C])-1);
            if(arr.get(B[C]).get(A[C]) == 0) {
                arr.get(B[C]).remove(A[C]);
            }
            if(!arr.get(B[C]).isEmpty()) {
                map.put(arr.get(B[C]).lastKey(), map.getOrDefault(arr.get(B[C]).lastKey(), 0)+1);
            }
            if(!arr.get(D).isEmpty()) {
                map.put(arr.get(D).lastKey(), map.get(arr.get(D).lastKey())-1);
                if(map.get(arr.get(D).lastKey()) == 0) {
                    map.remove(arr.get(D).lastKey());
                }
            }
            arr.get(D).put(A[C], arr.get(D).getOrDefault(A[C], 0)+1);
            map.put(arr.get(D).lastKey(), map.getOrDefault(arr.get(D).lastKey(), 0)+1);
            B[C] = D;
            out.println(map.firstKey());
        }
        f.close();
        out.close();
    }
}
