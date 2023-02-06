import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("missingPrices.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("missingPrices.out")));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            if(a.equals("X")){
                out.printf("%.2f",(100.0*Integer.parseInt(c))/(100.0+Integer.parseInt(b)));
                out.println();
            } else if(b.equals("X")) {
                out.printf("%.2f",(100.0*Integer.parseInt(c))/Integer.parseInt(a)-100);
                out.println();
            } else {
                out.printf("%.2f",(Integer.parseInt(a)*(100.0+Integer.parseInt(b)))/100.0);
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
