import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0 0 0 0")) {
             StringTokenizer st = new StringTokenizer(input);
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             int c = Integer.parseInt(st.nextToken());
             int d = Integer.parseInt(st.nextToken());
             int L = Integer.parseInt(st.nextToken());
             int ans = 0;
             for(int i = 0; i <= L; i++) {
                 int res = a*i*i + b*i + c;
                 if(res%d == 0) {
                     ans++;
                 }
             }
             out.println(ans);
        }
        f.close();
        out.close();
    }
}
