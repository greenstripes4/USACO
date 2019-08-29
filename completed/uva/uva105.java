import java.io.*;
import java.util.*;
/*
O(n^2)
1 11 5
2 6 7
3 13 9
12 7 16
14 3 25
19 18 22
23 13 29
24 4 28
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int[] street = new int[10001];
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int start = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int i = start; i < end; i++){
                if(street[i] < height){
                    street[i] = height;
                }
            }
        }
        int current = 0;
        for(int j = 0; j < 10000; j++){
            if(street[j] != current){
                current = street[j];
                if(j != 9999) {
                    out.print(j + " " + street[j] + " ");
                } else {
                    out.print(j + " " + street[j]);
                }
            }
        }
        out.println();
        f.close();
        out.close();
    }
}
