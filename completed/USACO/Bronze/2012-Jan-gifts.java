import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gifts.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gifts.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] gifts = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer g = new StringTokenizer(f.readLine());
            gifts[i][0] = Integer.parseInt(g.nextToken());
            gifts[i][1] = Integer.parseInt(g.nextToken());
        }
        Arrays.sort(gifts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] + o1[1] == o2[0] + o2[1]){
                    return 0;
                }
                return o1[0] + o1[1] > o2[0] + o2[1] ? 1:-1;
            }
        });
        int max = 0;
        for(int j = 0; j < gifts.length; j++){
            int temp = B - gifts[j][0]/2 - gifts[j][1];
            int count = 0;
            for(int k = 0; k < gifts.length; k++){
                if(k != j && temp >= 0){
                    if(temp >= 0) {
                        count++;
                        temp -= gifts[k][0] + gifts[k][1];
                    }
                }
            }
            if(count > max){
                max = count;
            }
        }
        out.println(max);
        out.close();
        f.close();
    }
}
