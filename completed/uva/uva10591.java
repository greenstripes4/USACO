import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            int n = Integer.parseInt(f.readLine());
            int originalN = n;
            boolean repeat = true;
            int previous = -1;
            while(true){
                previous = n;
                int temp = n;
                int sum = 0;
                while (temp != 0) {
                    sum += (temp % 10) * (temp % 10);
                    temp /= 10;
                }
                n = sum;
                if(n == 1){
                    break;
                }
                if(map.containsKey(n)){
                    repeat = false;
                    break;
                }
                map.put(previous,n);
            }
            out.println(repeat ? "Case #" + (i+1) + ": " + originalN + " is a Happy number.":"Case #" + (i+1) + ": " + originalN + " is an Unhappy number.");
        }
        f.close();
        out.close();
    }
}
