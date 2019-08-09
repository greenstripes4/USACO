import java.io.*;
import java.util.*;
/*
O(n^2)
1 1
1 1
10 4
2 5
6 9
1 1
10 10
5 1
1 1
0 0
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String input = null;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(s==0 && b==0) {
                break;
            }
            int[] ls = new int[s+1];
            int[] rs = new int[s+1];
            for(int i = 1; i <= s; i++){
                ls[i] = i - 1;
                rs[i] = i + 1;
            }
            rs[s] = 0;
            /*
            ls[0] = -1;
            rs[0] = -1;
            for(int i = 0; i < s; i++){
                ls[i+1] = i;
            }
            for(int j = 2; j <= s; j++){
                rs[j-1] = j;
            }
            */
            for(int k = 0; k < b; k++){
                StringTokenizer lr = new StringTokenizer(f.readLine());
                int l = Integer.parseInt(lr.nextToken());
                int r = Integer.parseInt(lr.nextToken());
                int left = ls[l];
                int right = rs[r];
                if(left == 0){
                    out.print("* ");
                }
                else{
                    out.print(left + " ");
                }
                if(right == 0){
                    out.println("*");
                }
                else{
                    out.println(right);
                }
                ls[right] = left;
                rs[left] = right;
            }
            out.println("-");
        }
        out.close();
        f.close();
    }
}
