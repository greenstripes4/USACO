import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        char[] t = f.readLine().toCharArray();
        int low = 0;
        int high = s.length-t.length;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            int start = 0;
            while(start <= s.length-mid) {
                int idx = 0;
                for(int i = 0; i < s.length && idx < t.length; i++) {
                    if((i < start || i >= start+mid) && s[i] == t[idx]) {
                        idx++;
                    }
                }
                if(idx == t.length) {
                    break;
                }
                start++;
            }
            if(start <= s.length-mid) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}