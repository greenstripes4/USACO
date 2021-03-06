import java.io.*;
import java.util.StringTokenizer;
//O(1)
//20 20 20
//1 2 21
//1 1 1
//50 50 50
//1 50 50
//3 2 6

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(h <= 20 && w <= 20 && l <= 20){
                System.out.println("Case " + (i+1) + ": " + "good");
            }
            else{
                System.out.println("Case " + (i+1) + ": " + "bad");
            }
        }
    }
}
