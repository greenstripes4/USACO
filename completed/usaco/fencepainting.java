import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        boolean[] painted = new boolean[100];
        for(int i = a; i < b; i++){
            painted[i] = true;
        }
        for(int j = c; j < d; j++){
            painted[j] = true;
        }
        int count = 0;
        for(boolean k: painted){
            if(k){
                count++;
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
