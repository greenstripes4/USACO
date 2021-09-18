import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        ArrayList<TreeMap<Integer, ArrayList<Integer>>> mod = new ArrayList<>(3);
        for(int i = 0; i < 3; i++) {
            mod.add(new TreeMap<>());
        }
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            TreeMap<Integer, ArrayList<Integer>> temp = mod.get(a%3);
            if(!temp.containsKey(a)) {
                temp.put(a, new ArrayList<>());
                temp.get(a).add(1);
            }
            temp.get(a).add(i+1);
        }
        int used = 0;
        int[] res = new int[n];
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            TreeMap<Integer, ArrayList<Integer>> temp = mod.get(i%3);
            Integer max = temp.floorKey(i-used);
            if(max == null) {
                flag = true;
                break;
            }
            ArrayList<Integer> idx = temp.get(max);
            res[i] = idx.get(idx.get(0));
            idx.set(0, idx.get(0)+1);
            if(idx.get(0) == idx.size()) {
                temp.remove(max);
            }
            used = i-max;
        }
        if(flag) {
            out.println("Impossible");
        } else {
            out.println("Possible");
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