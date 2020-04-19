import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int N = f.nextInt();
            if(N == 0){
                break;
            }
            int printed = 0;
            for(int i = 0; i < N; i++){
                int next = f.nextInt();
                if(next > 0){
                    if(printed > 0){
                        out.print(" ");
                    }
                    out.print(next);
                    printed++;
                }
            }
            if(printed == 0){
                out.print(0);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
