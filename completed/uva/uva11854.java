import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        String input;
        while(!((input = f.readLine()).equals("0 0 0"))){
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] sides = {a,b,c};
            Arrays.sort(sides);
            a = sides[0];
            b = sides[1];
            c = sides[2];
            if(a*a + b*b == c*c){
                out.println("right");
            } else {
                out.println("wrong");
            }
        }
        f.close();
        out.close();
    }
}
