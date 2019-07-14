import java.io.*;
import java.util.StringTokenizer;
//O(1)
//9 9
//6 6
//7 7
//9 13
//6 6
//6 10000
//10000 6
//10000 10000


public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int num1 = (int) Math.ceil((l-2)/3.0);
            int num2 = (int) Math.ceil((w-2)/3.0);
            System.out.println(num1 * num2);
        }
    }
}