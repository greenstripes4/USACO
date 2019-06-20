import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i<cases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(l <= 20 && w <= 20 && h <= 20){
                System.out.println("Case " + (i+1) + ": good");
            }
            else{
                System.out.println("Case " + (i+1) + ": bad");
            }
        }
    }
}
