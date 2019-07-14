import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
//O(n log n)
//4
//24 13 89 37
//6
//7 30 41 14 39 42
//1
//0
//20
//0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//20
//99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99
//5
//0 99 99 0 99
public class Main{
    public static void main(String[] args)throws IOException{
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            int stores = Integer.parseInt(f.readLine());
            int[] store_pos = new int[stores];
            StringTokenizer pos = new StringTokenizer(f.readLine());
            for(int j = 0; j < stores; j++){
                store_pos[j] = Integer.parseInt(pos.nextToken());
            }
            Arrays.sort(store_pos);
            System.out.println(2*(store_pos[store_pos.length-1]-store_pos[0]));
        }
    }
}
