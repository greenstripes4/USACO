import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sum += Integer.parseInt(st.nextToken());
            }
            if(sum == n) {
                out.println(0);
            } else if(sum < n) {
                out.println(1);
            } else {
                out.println(sum-n);
            }
        }
        f.close();
        out.close();
    }
}