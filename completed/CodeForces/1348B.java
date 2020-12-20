import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            ArrayList<Integer> a = new ArrayList<>();
            TreeSet<Integer> order = new TreeSet<>();
            for(int j = 0; j < n; j++) {
                int ai = Integer.parseInt(st.nextToken());
                a.add(ai);
                order.add(ai);
            }
            if(order.size() > k) {
                out.println(-1);
                continue;
            }
            for(int j = 1; j <= n; j++) {
                if(order.size() == k) {
                    break;
                }
                order.add(j);
            }
            int[] asArray = new int[order.size()];
            int index = 0;
            for(int j: order) {
                asArray[index++] = j;
            }
            index = 0;
            int arrayIndex = 0;
            while(arrayIndex < a.size()) {
                if(a.get(arrayIndex) != asArray[index]) {
                    a.add(arrayIndex, asArray[index]);
                }
                arrayIndex++;
                index = (index+1)%asArray.length;
            }
            out.println(a.size());
            out.print(a.get(0));
            for(int j = 1; j < a.size(); j++) {
                out.print(" " + a.get(j));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
