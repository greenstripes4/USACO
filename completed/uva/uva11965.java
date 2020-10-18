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
            if(t > 1) {
                out.println();
            }
            int N = Integer.parseInt(f.readLine());
            out.println("Case " + t + ":");
            for(int i = 0; i < N; i++) {
                out.println(f.readLine().replaceAll(" +"," "));
            }
        }
        f.close();
        out.close();
    }
}
