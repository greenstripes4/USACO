import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            Integer l = map.higherKey(k);
            if(l != null){
                if(map.get(l) == 1) {
                    map.remove(l);
                } else {
                    map.put(l, map.get(l)-1);
                }
            }
            map.put(k, map.getOrDefault(k, 0)+1);
        }
        int stacks = 0;
        for(int i: map.values()) {
            stacks += i;
        }
        out.println(stacks);
        f.close();
        out.close();
    }
}