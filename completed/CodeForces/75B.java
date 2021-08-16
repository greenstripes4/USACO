import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String root = f.readLine();
        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(f.readLine());
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String X = st.nextToken();
            char T = st.nextToken().charAt(0);
            int V = T == 'p' ? 15 : T == 'c' ? 10 : 5;
            String Y = st.nextToken();
            if(!Y.contains("'")) {
                Y = st.nextToken();
            }
            Y = Y.substring(0, Y.indexOf("'"));
            if(X.equals(root)) {
                map.put(Y, map.getOrDefault(Y, 0)+V);
            } else if(Y.equals(root)) {
                map.put(X, map.getOrDefault(X, 0)+V);
            } else {
                map.putIfAbsent(X, 0);
                map.putIfAbsent(Y, 0);
            }
        }
        String[] arr = new String[map.size()];
        int idx = 0;
        for(String i: map.keySet()) {
            arr[idx++] = i;
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                int a = map.get(s);
                int b = map.get(t1);
                if(a == b) {
                    return s.compareTo(t1);
                }
                return b-a;
            }
        });
        for(String i: arr) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}