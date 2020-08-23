import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        ArrayList<Long> arr = new ArrayList<>();
        long max = (long) Math.pow(2,31);
        for(int i = 0; i < 32; i++) {
            long val = (long) Math.pow(2,i);
            for(int j = 0; val*((long) Math.pow(3,j)) <= max; j++) {
                arr.add(val*((long) Math.pow(3,j)));
            }
        }
        Collections.sort(arr);
        while(!(input = f.readLine()).equals("0")) {
            long m = Long.parseLong(input);
            int low = 0;
            int high = arr.size()-1;
            long n = -1;
            while(low <= high) {
                int mid = (low+high)/2;
                if(arr.get(mid) >= m) {
                    n = arr.get(mid);
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            out.println(n);
        }
        f.close();
        out.close();
    }
}
