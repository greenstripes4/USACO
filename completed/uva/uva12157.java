import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
7
2
61 10
3
40 40 40
2
60 65
1
1
1
2000
20
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
20
2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            int sum1 = 0;
            int sum2 = 0;
            int num = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < num; j++){
                double duration = Double.parseDouble(st.nextToken());
                sum1 += Math.ceil((duration+1)/30)*10;
                sum2 += Math.ceil((duration+1)/60)*15;
            }
            if(sum1 < sum2){
                System.out.println("Case " + (i+1) + ": Mile" + " " + sum1);
            }
            else if(sum2 < sum1){
                System.out.println("Case " + (i+1) + ": Juice" + " " + sum2);
            }
            else{
                System.out.println("Case " + (i+1) + ": Mile Juice" + " " + sum1);
            }
        }
    }
}
