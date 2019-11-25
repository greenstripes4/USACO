import java.io.*;
import java.util.*;

public class Main {
    public static int f91(int n){
        if(n >= 101){
            return n - 10;
        }
        return f91(f91(n  +11));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")){
            int N = Integer.parseInt(input);
            out.println("f91(" + N + ") = " + f91(N));
        }
        f.close();
        out.close();
    }
}
