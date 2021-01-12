import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();
            char[] temp = f.readLine().toCharArray();
            for(char j: temp) {
                int k = Character.getNumericValue(j);
                if(k%2 == 0) {
                    even.add(k);
                } else {
                    odd.add(k);
                }
            }
            int j = 0;
            int k = 0;
            StringBuilder sb = new StringBuilder();
            while(j < even.size() || k < odd.size()) {
                if(j == even.size()) {
                    sb.append(odd.get(k++));
                } else if(k == odd.size()) {
                    sb.append(even.get(j++));
                } else {
                    if(even.get(j) < odd.get(k)) {
                        sb.append(even.get(j++));
                    } else {
                        sb.append(odd.get(k++));
                    }
                }
            }
            out.println(sb);
        }
        f.close();
        out.close();
    }
}