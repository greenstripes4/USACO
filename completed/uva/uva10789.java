  import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPrime(int n) {
        if(n < 2){
            return false;
        }
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
        int n = Integer.parseInt(f.readLine());
        for(int i = 0; i < n; i++){
            TreeMap<Character,Integer> map = new TreeMap<>();
            char[] arr = f.readLine().toCharArray();
            for(char j: arr){
                if(map.containsKey(j)){
                    int count = map.get(j);
                    map.put(j,count+1);
                } else {
                    map.put(j,1);
                }
            }
            StringBuilder res = new StringBuilder();
            for(char k: map.keySet()) {
                int num = map.get(k);
                if(isPrime(num)){
                    res.append(k);
                }
            }
            out.println("Case " + (i+1) + ": " + ((res.length() == 0) ? "empty":res));
        }
        f.close();
        out.close();
    }
}
