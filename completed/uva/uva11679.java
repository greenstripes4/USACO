import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
3 3
1 1 1
1 2 1
2 3 2
3 1 3
3 3
1 1 1
1 2 1
2 3 2
3 1 4
3 3
1 1 1
1 2 2
2 3 2
3 1 2
20 20
10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
20 1 10000
2 1
10 10
1 2 10
0 0
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("0 0"))){
            StringTokenizer st = new StringTokenizer(input);
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            StringTokenizer banks = new StringTokenizer(f.readLine());
            int[] reserves = new int[b];
            for(int i = 0; i < b; i++){
                reserves[i] = Integer.parseInt(banks.nextToken());
            }
            for(int j = 0; j < n; j++){
                StringTokenizer transfer = new StringTokenizer(f.readLine());
                int debtor = Integer.parseInt(transfer.nextToken()) - 1;
                int creditor = Integer.parseInt(transfer.nextToken()) - 1;
                int amount = Integer.parseInt(transfer.nextToken());
                reserves[debtor] = reserves[debtor] - amount;
                reserves[creditor] = reserves[creditor] + amount;
            }
            boolean success = true;
            for(int k: reserves){
                if(k < 0){
                    success = false;
                    break;
                }
            }
            if(success){
                System.out.println("S");
            }
            else{
                System.out.println("N");
            }
        }
    }
}
