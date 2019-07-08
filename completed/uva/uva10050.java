import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int num = Integer.parseInt(f.readLine());
        for(int i = 0; i < num; i++){
            int days = Integer.parseInt(f.readLine());
            int[] calander = new int[days];
            int parties = Integer.parseInt(f.readLine());
            int[] party_hartal_rate = new int[parties];
            for(int j = 0; j < parties; j++){
                party_hartal_rate[j] = Integer.parseInt(f.readLine());
            }
            for(int k: party_hartal_rate){
                for(int l = k-1; l < calander.length; l += k){
                    calander[l]++;
                }
            }
            int count = 0;
            for(int m = 0; m < calander.length; m++){
                if(m%5 != 0 && m%6 != 0 && calander[m] != 0){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
