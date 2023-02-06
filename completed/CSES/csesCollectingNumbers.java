import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        HashSet<Integer> next = new HashSet<>();
        StringTokenizer st = new StringTokenizer(f.readLine());
        int rounds = 0;
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(!next.contains(x)) {
                rounds++;
            }
            next.remove(x);
            next.add(x+1);
        }
        out.println(rounds);
        f.close();
        out.close();
    }
}