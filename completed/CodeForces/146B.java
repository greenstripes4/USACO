import java.io.*;
import java.util.*;

public class Main {
    private static int mask(int x) {
        int reverse = 0;
        while(x > 0) {
            if(x%10 == 4 || x%10 == 7) {
                reverse = reverse*10+x%10;
            }
            x /= 10;
        }
        int ans = 0;
        while(reverse > 0) {
            ans = ans*10+reverse%10;
            reverse /= 10;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken())+1;
        int b = Integer.parseInt(st.nextToken());
        while(mask(a) != b) {
            a++;
        }
        out.println(a);
        f.close();
        out.close();
    }
}