import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int num_cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < num_cases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int celsius = Integer.parseInt(st.nextToken());
            int fahrenheit = Integer.parseInt(st.nextToken());
            double converted = (celsius * 1.8) + 32;
            double sum = fahrenheit + converted;
            System.out.print("Case " + (i+1) + ": ");
            System.out.printf("%.2f" , (sum-32) * 5 / 9);
            System.out.println();
        }
        f.close();
    }
}
