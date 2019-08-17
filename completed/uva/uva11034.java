import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
O(n)
4
20 4
380 left
720 left
1340 right
1040 left
15 4
380 left
720 left
1340 right
1040 left
15 4
380 left
720 left
1340 left
1040 left
15 4
380 right
720 right
1340 right
1040 right
*/
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        int numCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numCases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken())*100;
            int m = Integer.parseInt(st.nextToken());
            LinkedList<Integer> leftBank = new LinkedList<>();
            LinkedList<Integer> rightBank = new LinkedList<>();
            for(int j = 0; j < m; j++){
                StringTokenizer car = new StringTokenizer(f.readLine());
                int length = Integer.parseInt(car.nextToken());
                String bank = car.nextToken();
                if(bank.equals("left")){
                    leftBank.add(length);
                } else {
                    rightBank.add(length);
                }
            }
            int crosses = 0;
            while(!leftBank.isEmpty() || !rightBank.isEmpty()){
                crosses++;
                int availableSpace = l;
                while(!leftBank.isEmpty() && leftBank.peek() <= availableSpace){
                    availableSpace -= leftBank.poll();
                }
                if(!leftBank.isEmpty() || !rightBank.isEmpty()){
                    crosses++;
                }
                availableSpace = l;
                while(!rightBank.isEmpty() && rightBank.peek() <= availableSpace){
                    availableSpace -= rightBank.poll();
                }
            }
            out.println(crosses);
        }
        out.close();
        f.close();
    }
}
