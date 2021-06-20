import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] d = new int[n];
        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            d[a]++;
            d[b]++;
        }
        boolean flag = false;
        for(int i: d) {
            if(i == 2) {
                flag = true;
                break;
            }
        }
        out.println(flag ? "NO" : "YES");
        f.close();
        out.close();
    }
}