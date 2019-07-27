import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
2 2 10
5
7
1
2
3 6 10
2
5
7
2
1
2
3
1
3
20 3 10
5
5
5
5
5
5
5
5
5
5
5
5
5
5
5
5
5
5
5
5
2
1
2
0 0 0
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int sequence = 1;
        while(!((input = f.readLine()).equals("0 0 0"))){
            StringTokenizer st = new StringTokenizer(input);
            int numDevices = Integer.parseInt(st.nextToken());
            int numOperations = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());
            boolean[] on = new boolean[numDevices];
            int[] deviceConsumption = new int[numDevices];
            int[] operations = new int[numOperations];
            for(int i = 0; i < numDevices; i++){
                deviceConsumption[i] = Integer.parseInt(f.readLine());
                on[i] = false;
            }
            for(int j = 0; j < numOperations; j++){
                operations[j] = Integer.parseInt(f.readLine());
            }
            int current = 0;
            int max = 0;
            for(int k: operations){
                if(on[k-1] == false){
                    on[k-1] = true;
                    current += deviceConsumption[k-1];
                } else {
                    on[k-1] = false;
                    current -= deviceConsumption[k-1];
                }
                if(current > max){
                    max = current;
                }
            }
            System.out.println("Sequence " + sequence);
            if(max > capacity){
                System.out.println("Fuse was blown.");
            } else {
                System.out.println("Fuse was not blown.");
                System.out.println("Maximal power consumption was " + max + " amperes.");
            }
            System.out.println();
            sequence++;
        }
    }
}
