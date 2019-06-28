import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int num_cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < num_cases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int sum = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            double num2 = (sum-diff)/2.0;
            double num1 = num2 + diff;
            if((int) num2 != num2 || (int) num1 != num1 || sum < diff){
                System.out.println("impossible");
            }
            else{
                System.out.println((int) num1 + " " + (int) num2);
            }
        }
        f.close();
    }
}
