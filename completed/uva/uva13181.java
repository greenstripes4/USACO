import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            char[] arr = input.toCharArray();
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 'X') {
                    set.add(i);
                }
            }
            int max = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '.') {
                    Integer right = set.higher(i);
                    Integer left = set.lower(i);
                    int min = arr.length;
                    if(right != null) {
                        min = Math.min(min, right-i-1);
                    }
                    if(left != null) {
                        min = Math.min(min, i-left-1);
                    }
                    max = Math.max(max, min);
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}