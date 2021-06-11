import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long l = f.nextLong();
        long r = f.nextLong();
        long temp = 0;
        int length = 0;
        while(r > 0) {
            temp <<= 1;
            if(r-l > 1 || (l&1) != (r&1)) {
                temp |= 1;
            }
            l >>= 1;
            r >>= 1;
            length++;
        }
        long ans = 0;
        while(length-- > 0) {
            ans <<= 1;
            ans |= temp&1;
            temp >>= 1;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}