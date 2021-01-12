import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] n = f.readLine().toCharArray();
        int position = 0;
        for(char i: n) {
            if(i == '4') {
                position = position*2+1;
            } else {
                position = position*2+2;
            }
        }
        out.println(position);
        f.close();
        out.close();
    }
}