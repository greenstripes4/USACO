import java.io.*;
import java.util.StringTokenizer;
/*
O(1)
3
5181 2710 9900 0012
5181 2710 9900 0017
0000 0000 0000 0000
*/

public class Main {
    public static void main (String args[]) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numTestCases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 4; j++){
                sb.append(st.nextToken());
            }
            char[] temp = sb.toString().toCharArray();
            int[] digits = new int[16];
            for(int k = 0; k < 16; k++){
                digits[k] = Character.getNumericValue(temp[k]);
            }
            int[] doubled = new int[8];
            int[] non_doubled = new int[8];
            for(int l = 0; l < 16; l += 2){
                doubled[l/2] = 2*digits[l];
            }
            for(int m = 1; m < 16; m += 2){
                non_doubled[(m-1)/2] = digits[m];
            }
            int sum1 = 0;
            int sum2 = 0;
            for(int n: doubled){
                int t = n;
                while(t != 0){
                    sum1 += t%10;
                    t /= 10;
                }
            }
            for(int o: non_doubled){
                sum2 += o;
            }
            if((sum1 + sum2)%10 == 0){
                System.out.println("Valid");
            }
            else{
                System.out.println("Invalid");
            }
        }
    }
}
