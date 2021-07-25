import java.io.*;
import java.util.*;

public class Main {
    private static int getInverse(int x) {
        int ans = 0;
        for(int i = 0; i < 18; i++) {
            ans = (ans << 1) | ((x&(1 << (17-i))) > 0 ? 0 : 1);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int k = Integer.parseInt(f.readLine());
        int invk = getInverse(k);
        out.println("3 2");
        out.println("262143 " + k);
        out.println(invk + " 262143");
        out.println("0 " + k);
        f.close();
        out.close();
    }
}