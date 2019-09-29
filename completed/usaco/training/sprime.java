import java.io.*;
import java.util.ArrayList;

/*
ID: strongh2
LANG: JAVA
PROG: sprime
TASK: sprime
 */
public class sprime {
    public static boolean isPrime(int n){
        int root = (int) Math.ceil(Math.sqrt(n));
        for(int i = 2; i <= root; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Integer> recur(int n){
        if(n == 1){
            ArrayList<Integer> oneDigitSuperprimes = new ArrayList<>();
            oneDigitSuperprimes.add(2);
            oneDigitSuperprimes.add(3);
            oneDigitSuperprimes.add(5);
            oneDigitSuperprimes.add(7);
            return oneDigitSuperprimes;
        }
        ArrayList<Integer> oneLessDigitSuperPrimes = recur(n-1);
        ArrayList<Integer> nDigitSuperprimes = new ArrayList<>();
        int[] odd = {1,3,5,7,9};
        for(int i: oneLessDigitSuperPrimes){
            for(int j: odd){
                if(isPrime(i*10+j)) {
                    nDigitSuperprimes.add(i * 10 + j);
                }
            }
        }
        return nDigitSuperprimes;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        int N = Integer.parseInt(f.readLine());
        ArrayList<Integer> superPrimes = recur(N);
        for(int i: superPrimes){
            out.println(i);
        }
        f.close();
        out.close();
    }
}
