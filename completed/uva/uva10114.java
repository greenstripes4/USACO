import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
30 500.0 15000.0 3
0 .10
1 .03
3 .002
12 500.0 9999.99 2
0 .05
2 .1
60 2400.0 30000.0 3
0 .2
1 .05
12 .025
-99 0 17000 1
100 10000 65000 1
0 0.5
100 10000 65000 2
0.11
0.99
0.3
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while((input = f.readLine()).charAt(0) != '-'){
            StringTokenizer st = new StringTokenizer(input);
            int duration = Integer.parseInt(st.nextToken());
            double downPayment = Double.parseDouble(st.nextToken());
            double loan = Double.parseDouble(st.nextToken());
            int numDepreciations = Integer.parseInt(st.nextToken());
            if(numDepreciations == 0){
                System.out.println();
                continue;
            }
            double carValue = downPayment + loan;
            double monthlyPayment = loan / duration;
            int[] m = new int[numDepreciations];
            double[] d = new double[numDepreciations];
            for (int i = 0; i < numDepreciations; i++) {
                StringTokenizer s = new StringTokenizer(f.readLine());
                m[i] = Integer.parseInt(s.nextToken());
                d[i] = Double.parseDouble(s.nextToken());
            }
            int ind = 1;
            double percentage = d[0];
            if(loan < carValue * (1- percentage)){
                System.out.println("0 months");
                continue;
            }
            carValue *= (1 - percentage);
            for (int j = 1; j <= duration; j++) {
                if (!((ind >= m.length) || j < m[ind])) {
                    percentage = d[ind];
                    ind++;
                }
                //System.out.println(j + ":" + carValue + ":" + loan + ":" + percentage);
                carValue *= (1 - percentage);
                loan -= monthlyPayment;
                if (loan < carValue) {
                    System.out.println((j) + " " + ((j == 1) ? "month" : "months"));
                    break;
                }
            }
        }
    }
}