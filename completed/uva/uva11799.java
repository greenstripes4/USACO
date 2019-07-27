import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
6
5 9 3 5 2 6
1 2
10000 10000 10000
0
0 10000
*/

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int num = Integer.parseInt(f.readLine());
        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int max = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int current = Integer.parseInt(st.nextToken());
                if(current > max){
                    max = current;
                }
            }
            System.out.println("Case " + (i+1) + ": " + max);
        }
    }
}
