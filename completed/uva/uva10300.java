import java.io.*;
import java.util.StringTokenizer;
//O(1)
//4
//5
//1 1 1
//2 2 2
//3 3 3
//2 3 4
//8 9 2
//3
//9 1 8
//6 12 1
//8 1 1
//3
//10 30 40
//9 8 5
//100 1000 70
//2
//100000 100000 100000
//0 0 0

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            int farmers = Integer.parseInt(f.readLine());
            long total = 0;
            for(int j = 0; j < farmers; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                long size = Integer.parseInt(st.nextToken());
                long num = Integer.parseInt(st.nextToken());
                long eco = Integer.parseInt(st.nextToken());
                double aver = (double) size/num;
                double premium = aver*eco;
                total += (long) Math.ceil(premium*num);
            }
            System.out.println(total);
        }
    }
}
