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
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int r = Integer.parseInt(st.nextToken());
            int[] s = new int[r];
            for(int i = 0; i < r; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(s);
            int d = 0;
            for(int i = 0; i < r; i++) {
                d += Math.abs(s[r/2]-s[i]);
            }
            out.println(d);
        }
        f.close();
        out.close();
    }
}
