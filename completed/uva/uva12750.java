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
            int n = Integer.parseInt(f.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                sb.append(f.readLine());
            }
            int index = 3;
            for(int i = 0; i < n-2; i++) {
                if(!sb.substring(i,i+3).contains("W")) {
                    break;
                }
                index++;
            }
            out.print("Case " + t + ": ");
            out.println(index == n+1 ? "Yay! Mighty Rafa persists!" : index);
        }
        f.close();
        out.close();
    }
}
