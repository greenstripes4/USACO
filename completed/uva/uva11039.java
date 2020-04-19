import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = f.nextInt();
        for(int i = 0; i < testCases; i++){
            int numFloors = f.nextInt();
            Integer[] floors = new Integer[numFloors];
            for(int j = 0; j < numFloors; j++){
                floors[j] = f.nextInt();
            }
            Arrays.sort(floors, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    int size1 = Math.abs(integer);
                    int size2 = Math.abs(t1);
                    if(size1 == size2){
                        return 0;
                    }
                    return size1-size2;
                }
            });
            int max = 0;
            int prev = 0;
            for(int j = 0; j < numFloors; j++){
                if(prev == 0 || (floors[j] > 0 && prev < 0) || (floors[j] < 0 && prev > 0)){
                    max++;
                    prev = floors[j];
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
