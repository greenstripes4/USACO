import java.io.*;
import java.util.*;
/*
O(n log n)
4
123 124 56 90
5
123 124 56 90 9
5
9 9 9 9 9
0
 */

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String input;
        while(!((input = f.readLine()).equals("0"))) {
            int numNumbers = Integer.parseInt(input);
            StringTokenizer st = new StringTokenizer(f.readLine());
            String[] nums = new String[numNumbers];
            for(int i = 0; i < numNumbers; i++){
                nums[i] = st.nextToken();
            }
            Arrays.sort(nums, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String combined = o1 + o2;
                    String combined2 = o2 + o1;
                    return combined.compareTo(combined2) > 0 ? -1:1;
                }
            });
            for(String i: nums){
                out.print(i);
            }
            out.println();
        }
        out.close();
    }
}
