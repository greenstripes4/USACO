import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        TreeMap<Integer, String> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            String temp = st.nextToken();
            if(!temp.equals("?")) {
                map.put(i, temp);
            }
        }
        int q = Integer.parseInt(f.readLine());
        for(int i = 0; i < q; i++) {
            int pos = Integer.parseInt(f.readLine())-1;
            if(map.containsKey(pos)) {
                out.println(map.get(pos));
            } else {
                Integer left = map.lowerKey(pos);
                Integer right = map.higherKey(pos);
                if(right == null) {
                    for(int j = 0; j < pos-left; j++) {
                        out.print("right of ");
                    }
                    out.println(map.get(left));
                } else if(left == null) {
                    for(int j = 0; j < right-pos; j++) {
                        out.print("left of ");
                    }
                    out.println(map.get(right));
                } else if(pos-left < right-pos) {
                    for(int j = 0; j < pos-left; j++) {
                        out.print("right of ");
                    }
                    out.println(map.get(left));
                } else if(right-pos < pos-left) {
                    for(int j = 0; j < right-pos; j++) {
                        out.print("left of ");
                    }
                    out.println(map.get(right));
                } else {
                    out.println("middle of " + map.get(left) + " and " + map.get(right));
                }
            }
        }
        f.close();
        out.close();
    }
}