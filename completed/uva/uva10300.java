import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i<cases; i++){
            int amount = 0;
            int numFarmers = Integer.parseInt(f.readLine());
            for(int j = 0; j < numFarmers; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int size = Integer.parseInt(st.nextToken());
                int animals = Integer.parseInt(st.nextToken());
                int ecoFriendlyLevel = Integer.parseInt(st.nextToken());
                double aver = (double)size/animals;
                double premium = aver*ecoFriendlyLevel;
                int finalPrem = (int)(Math.ceil(premium*animals));
                amount += finalPrem;
            }
            System.out.println(amount);
        }
    }
}
