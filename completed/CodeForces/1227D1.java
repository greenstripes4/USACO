import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        Integer[] idx = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            idx[i] = i;
        }
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                if(a[n1] == a[n2]) {
                    return n1-n2;
                }
                return a[n2]-a[n1];
            }
        });
        int m = Integer.parseInt(f.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int k = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            Integer[] res = Arrays.copyOfRange(idx, 0, k);
            Arrays.sort(res);
            out.println(a[res[pos-1]]);
        }
        f.close();
        out.close();
    }
}
