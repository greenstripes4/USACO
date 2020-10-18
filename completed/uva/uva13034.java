import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int S = Integer.parseInt(f.readLine());
        for(int t = 1; t <= S; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            boolean solvable = true;
            for(int i = 0; i < 13; i++) {
                if(Integer.parseInt(st.nextToken()) == 0) {
                    solvable = false;
                    break;
                }
            }
            out.print("Set #" + t + ": ");
            out.println(solvable ? "Yes" : "No");
        }
        f.close();
        out.close();
    }
}
