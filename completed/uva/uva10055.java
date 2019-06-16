import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            Long h = Long.parseLong(st.nextToken());
            Long o = Long.parseLong(st.nextToken());
            System.out.println(Math.abs(o-h));
        }
    }
}
