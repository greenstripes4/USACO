import java.io.*;
import java.math.BigInteger;
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
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int total = 0;
            int max = -1;
            for(int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                total += temp;
                max = Math.max(max, temp);
            }
            if(max > total/2) {
                out.println("T");
            } else if(total%2 == 0) {
                out.println("HL");
            } else {
                out.println("T");
            }
        }
        f.close();
        out.close();
    }
}
