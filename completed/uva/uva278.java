import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int problems = Integer.parseInt(f.readLine());
        for(int p = 0; p < problems; p++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            char piece = st.nextToken().charAt(0);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(piece == 'r' || piece == 'Q') {
                out.println(Math.min(m,n));
            } else if(piece == 'k') {
                out.println(((m+1)/2) * ((n+1)/2) + (m/2) * (n/2));
            } else {
                out.println(((m+1)/2) * ((n+1)/2));
            }
        }
        f.close();
        out.close();
    }
}
