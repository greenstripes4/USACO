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
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int last = Integer.parseInt(st.nextToken());
            boolean escala = true;
            for(int i = 0; i < 4; i++) {
                int current = Integer.parseInt(st.nextToken());
                if(last+1 != current) {
                    escala = false;
                    break;
                }
                last = current;
            }
            out.println(escala ? "Y" : "N");
        }
        f.close();
        out.close();
    }
}
