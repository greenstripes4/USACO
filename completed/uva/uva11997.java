import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            int k = Integer.parseInt(input);
            int[][] kArrays = new int[k][k];
            for(int i = 0; i < k; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int j = 0; j < k; j++){
                    kArrays[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int[] i: kArrays){
                Arrays.sort(i);
            }
            int[] sums = new int[k+1];
            int sum1 = 0;
            for(int i = 0; i < k; i++){
                sum1 += kArrays[i][0];
            }
            sums[0] = sum1;
            for(int i = 1; i <= k; i++){
                int increment = i-1;
                int sum = 0;
                for(int j = 0; j < k; j++){
                    if(j == increment){
                        sum += kArrays[j][1];
                    } else {
                        sum += kArrays[j][0];
                    }
                }
                sums[i] = sum;
            }
            Arrays.sort(sums);
            out.print(sums[0]);
            for(int i = 1; i < k; i++){
                out.print(" " + sums[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
