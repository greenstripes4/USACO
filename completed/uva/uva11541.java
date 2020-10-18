import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            char[] str = f.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            char cur = str[0];
            int freq = 0;
            for(int i = 1; i < str.length; i++) {
                if(str[i] >= '0' && str[i] <= '9') {
                    freq = freq*10+str[i]-'0';
                } else {
                    for(int j = 0; j < freq; j++) {
                        sb.append(cur);
                    }
                    freq = 0;
                    cur = str[i];
                }
            }
            for(int j = 0; j < freq; j++) {
                sb.append(cur);
            }
            out.println("Case " + t + ": " + sb);
        }
        f.close();
        out.close();
    }
}
