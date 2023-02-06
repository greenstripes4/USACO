import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(f.readLine());
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if(!map.containsKey(a[i])) {
                map.put(a[i], new ArrayList<>());
            }
            map.get(a[i]).add(i);
        }
        boolean found = false;
        for(int i = 0; i < n; i++) {
            if(map.containsKey(x-a[i])) {
                if(a[i]*2 == x) {
                    if(map.get(a[i]).size() > 1) {
                        for(int j: map.get(a[i])) {
                            if(j != i) {
                                found = true;
                                out.println((i+1) + " " + (j+1));
                                break;
                            }
                        }
                        if(found) {
                            break;
                        }
                    }
                } else {
                    found = true;
                    out.println((i+1) + " " + (map.get(x-a[i]).get(0)+1));
                    break;
                }
            }
        }
        if(!found) {
            out.println("IMPOSSIBLE");
        }
        f.close();
        out.close();
    }
}