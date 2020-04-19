import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        for(int i = 0; i < T; i++){
            int N = f.nextInt();
            f.nextLine();
            char[] field = f.nextLine().toCharArray();
            int scarecrows = 0;
            for(int j = 0; j < N; j++){
                if(field[j] == '.'){
                    scarecrows++;
                    j += 2;
                }
            }
            out.println("Case " + (i+1) + ": " + scarecrows);
        }
        f.close();
        out.close();
    }
}
