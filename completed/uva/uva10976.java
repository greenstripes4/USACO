import java.io.*;
import java.util.ArrayList;
//O(n^2)
//1
//2
//12
//10000

public class Main{
    public static long subtract(long k, long y){
        long d = k*y;
        long n = y-k;
        if(d%n == 0){
            return d/n;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while((input = f.readLine()) != null){
            long k = Long.parseLong(input);
            ArrayList<String> pos = new ArrayList<>();
            long count = 0;
            for(long i = k+1; i <= k*2; i++){
                if(subtract(k,i) != -1){
                    pos.add("1/" + k + " = " + "1/" + subtract(k,i) + " + 1/" + i);
                    count++;
                }
            }
            System.out.println(count);
            for(String xy: pos){
                System.out.println(xy);
            }
        }
    }
}
