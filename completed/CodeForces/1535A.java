import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            int s4 = Integer.parseInt(st.nextToken());
            int[] temp = {s1, s2, s3, s4};
            Arrays.sort(temp);
            if((temp[2] == s1 && temp[3] == s2) || (temp[2] == s2 && temp[3] == s1) ||
                    (temp[2] == s3 && temp[3] == s4) || (temp[2] == s4 && temp[3] == s3)) {
                out.println("NO");
            } else {
                out.println("YES");
            }
        }
        f.close();
        out.close();
    }
}