import java.io.*;
import java.util.*;

public class Main {
    private static int count;
    private static StringBuilder sb;
    private static void getAllDistinctFactorizations(ArrayList<Integer> divisors, ArrayList<Integer> factors, int index, int N) {
        if(index == divisors.size()) {
            if(N == 1) {
                count++;
                sb.append(factors.get(0));
                for(int i = 1; i < factors.size(); i++) {
                    sb.append(" ");
                    sb.append(factors.get(i));
                }
                sb.append("\n");
            }
            return;
        }
        if(N%divisors.get(index) == 0) {
            factors.add(divisors.get(index));
            getAllDistinctFactorizations(divisors,factors,index,N/divisors.get(index));
            factors.remove(factors.size()-1);
        }
        getAllDistinctFactorizations(divisors,factors,index+1,N);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int N = Integer.parseInt(input);
            if(N == 1) {
                out.println(0);
                continue;
            }
            ArrayList<Integer> divisors = new ArrayList<>();
            for(int i = 2; i*i <= N; i++) {
                if(N%i == 0) {
                    divisors.add(i);
                    if(N/i != i) {
                        divisors.add(N/i);
                    }
                }
            }
            Collections.sort(divisors);
            count = 0;
            sb = new StringBuilder();
            getAllDistinctFactorizations(divisors,new ArrayList<>(),0,N);
            out.println(count);
            out.print(sb);
        }
        f.close();
        out.close();
    }
}
