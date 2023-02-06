import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        char[] s = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());
        while(s.length < N) {
            StringBuilder sb = new StringBuilder();
            for(char i: s) {
                sb.append(i);
            }
            sb.append(s[s.length-1]);
            for(int i = 0; i < s.length-1; i++) {
                sb.append(s[i]);
            }
            s = sb.toString().toCharArray();
        }
        out.println(s[N-1]);
        f.close();
        out.close();
    }
}
