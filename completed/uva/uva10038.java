import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int n = f.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = f.nextInt();
            }
            boolean[] found = new boolean[n];
            for(int i = 1; i < n; i++) {
                int diff = Math.abs(a[i]-a[i-1]);
                if(diff > 0 && diff < n) {
                    found[diff] = true;
                }
            }
            boolean flag = false;
            for(int i = 1; i < n; i++) {
                if(!found[i]) {
                    flag = true;
                    break;
                }
            }
            out.println(flag ? "Not jolly" : "Jolly");
        }
        f.close();
        out.close();
    }
}
