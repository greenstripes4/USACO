import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int input_cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < input_cases; i++){
            int numstores = Integer.parseInt(f.readLine());
            StringTokenizer stores = new StringTokenizer(f.readLine());
            int[] s = new int[numstores];
            for(int j = 0; j < numstores; j++){
                s[j] = Integer.parseInt(stores.nextToken());
            }
            Arrays.sort(s);
            System.out.println(2*(s[s.length-1]-s[0]));
        }
    }
}
