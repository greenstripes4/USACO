import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] t = f.readLine().toCharArray();
        char[] p = f.readLine().toCharArray();
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[t.length];
        int[] timeRemoved = new int[t.length];
        for(int i = 0; i < t.length; i++) {
            a[i] = Integer.parseInt(st.nextToken())-1;
            timeRemoved[a[i]] = i;
        }
        int low = 0;
        int high = t.length;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            int index = 0;
            for(int i = 0; i < t.length && index < p.length; i++) {
                if(timeRemoved[i] >= mid && t[i] == p[index]) {
                    index++;
                }
            }
            if(index == p.length) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}