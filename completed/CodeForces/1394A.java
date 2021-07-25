import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int ai = Integer.parseInt(st.nextToken());
            if(ai > m) {
                greater.add(ai);
            } else {
                less.add(ai);
            }
        }
        Collections.sort(less);
        Collections.reverse(less);
        Collections.sort(greater);
        Collections.reverse(greater);
        long[] preLess = new long[less.size()+1];
        for(int i = 1; i <= less.size(); i++) {
            preLess[i] = preLess[i-1]+less.get(i-1);
        }
        long[] preGreater = new long[greater.size()+1];
        for(int i = 1; i <= greater.size(); i++) {
            preGreater[i] = preGreater[i-1]+greater.get(i-1);
        }
        long ans = preLess[less.size()];
        for(int i = 1; i <= greater.size(); i++) {
            int temp = (i-1)*(d+1)+1;
            if(temp > n) {
                break;
            }
            ans = Math.max(ans, preGreater[i]+preLess[Math.min(less.size(), n-temp)]);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}