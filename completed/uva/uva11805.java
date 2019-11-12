import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        int n = Integer.parseInt(f.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int players = Integer.parseInt(st.nextToken());
            int passedTo = Integer.parseInt(st.nextToken());
            int passes = Integer.parseInt(st.nextToken());
            out.println("Case " + (i+1) + ": " + ((passedTo+passes)%players == 0 ? players:(passedTo+passes)%players));
        }
        f.close();
        out.close();
    }
}