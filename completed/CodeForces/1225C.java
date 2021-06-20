 import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = f.nextInt();
        int p = f.nextInt();
        int ans = -1;
        for(int i = 1; i <= 30; i++) {
            if(Integer.bitCount(n-i*p) <= i && n-i*p >= i) {
                ans = i;
                break;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}