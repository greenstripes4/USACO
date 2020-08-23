import java.io.*;
import java.util.*;

public class Main {
    private static int solve(int n, int borrowed) {
        int total = n+borrowed;
        int ans = n;
        while(total >= 3) {
            ans += total/3;
            total = total/3+total%3;
        }
        if(total < borrowed) {
            return 0;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            int n = Integer.parseInt(input);
            out.println(Math.max(solve(n,0),Math.max(solve(n,1),solve(n,2))));
        }
        f.close();
        out.close();
    }
}
