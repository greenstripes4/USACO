/*
ID: strongh2
LANG: JAVA
PROG: milk
TASK: milk
 */
import java.util.*;
import java.io.*;

public class milk {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int needed = Integer.parseInt(st.nextToken());
        int numFarmers = Integer.parseInt(st.nextToken());
        int[][] farmers = new int[numFarmers][2];
        for(int i = 0; i < numFarmers; i++){
            StringTokenizer far = new StringTokenizer(f.readLine());
            int pricePerUnit = Integer.parseInt(far.nextToken());
            int unitsAvailable = Integer.parseInt(far.nextToken());
            farmers[i][0] = pricePerUnit;
            farmers[i][1] = unitsAvailable;
        }
        Arrays.sort(farmers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return 0;
                } else {
                    return o1[0] > o2[0] ? 1:-1;
                }
            }
        });
        int units = 0;
        int price = 0;
        for(int[] i: farmers){
            while(i[1] > 0 && units < needed){
                i[1]--;
                units++;
                price += i[0];
            }
        }
        out.println(price);
        out.close();
        f.close();
    }
}
