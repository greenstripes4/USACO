import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.ceil(Math.sqrt(n)); i++) {
            if (n % i == 0 && i != n) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")){
            int N = Integer.parseInt(input);
            if(isPrime(N)){
                out.println(N + " : " + 1);
            } else {
                int count = 0;
                int temp = N;
                int num = 2;
                while (temp != 1){
                    boolean in = false;
                    while(temp % num == 0){
                        temp /= num;
                        in = true;
                    }
                    if(in){
                        count++;
                    }
                    num++;
                }
                out.println(N + " : " + count);
            }
        }
        f.close();
        out.close();
    }
}
