import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pails.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;
        for(int i = 0; i <= m/x; i++){
            int filled = (x*i) + ((m-x*i)/y)*y;
            if(filled > max){
                max = filled;
            }
        }
        out.println(max);
        out.close();
        f.close();
    }
}
