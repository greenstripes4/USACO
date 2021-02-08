import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            TreeMap<Integer, Integer> a = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 2*n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                a.put(temp, a.getOrDefault(temp, 0)+1);
            }
            StringBuilder ans = null;
            for(int j: a.keySet()) {
                int x = j+a.lastKey();
                TreeMap<Integer, Integer> aTemp = new TreeMap<>(a);
                StringBuilder sb = new StringBuilder();
                sb.append(x);
                sb.append("\n");
                boolean found = true;
                for(int k = 0; k < n; k++) {
                    int first = aTemp.lastKey();
                    int second = x-first;
                    aTemp.put(first, aTemp.get(first)-1);
                    if(aTemp.get(first) == 0) {
                        aTemp.remove(first);
                    }
                    if(!aTemp.containsKey(second)) {
                        found = false;
                        break;
                    }
                    aTemp.put(second, aTemp.get(second)-1);
                    if(aTemp.get(second) == 0) {
                        aTemp.remove(second);
                    }
                    sb.append(first);
                    sb.append(" ");
                    sb.append(second);
                    sb.append("\n");
                    x = first;
                }
                if(found) {
                    ans = sb;
                    break;
                }
            }
            if(ans == null) {
                out.println("NO");
            } else {
                out.println("YES");
                out.print(ans);
            }
        }
        f.close();
        out.close();
    }
}