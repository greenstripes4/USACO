import java.io.*;
import java.util.*;

public class Main{
    private static int bs(ArrayList<Integer> x, int lowerbound) {
        int ans = -1, lo = 0, hi = x.size() - 1;
        while(lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if(x.get(mid) > lowerbound)
            {
                ans = x.get(mid);
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String line = f.readLine();
        int n = line.length();
        ArrayList<Integer>[] arr = new ArrayList[60];
        for(int i = 0; i < 60; ++i)
            arr[i] = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            arr[line.charAt(i) - 'A'].add(i);
        int q = Integer.parseInt(f.readLine());
        for(int i = 0; i < q; i++){
            line = f.readLine();
            boolean found = true;
            int x = -1, y = -1;
            for(int j = 0; j < line.length() && found; j++) {
                int idx = bs(arr[line.charAt(j) - 'A'], y);
                if(idx == -1) {
                    found = false;
                } else {
                    if(x == -1)
                        x = idx;
                    y = idx;
                }
            }
            if(found)
                out.format("Matched %d %d\n", x, y);
            else
                out.format("Not matched\n");
        }
        f.close();
        out.close();
    }
}
