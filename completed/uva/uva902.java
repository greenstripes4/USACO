import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(f.hasNext()) {
            int N = f.nextInt();
            String message = f.next();
            HashMap<String,Integer> substringOccurances = new HashMap<>();
            for(int i = 0; i <= message.length()-N; i++) {
                String substring = message.substring(i,i+N);
                substringOccurances.put(substring,substringOccurances.getOrDefault(substring,0)+1);
            }
            int max = 0;
            String password = "";
            for(String i: substringOccurances.keySet()) {
                if(substringOccurances.get(i) >= max) {
                    max = substringOccurances.get(i);
                    password = i;
                }
            }
            out.println(password);
        }
        f.close();
        out.close();
    }
}
