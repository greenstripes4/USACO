import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] temp = f.readLine().toCharArray();
        if(temp.length == 1) {
            out.println(0);
        } else {
            int sum = 0;
            for(char i: temp) {
                sum += i-'0';
            }
            int ans = 1;
            while(sum >= 10) {
                int next = 0;
                while(sum > 0) {
                    next += sum%10;
                    sum /= 10;
                }
                sum = next;
                ans++;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}