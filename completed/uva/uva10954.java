import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            int numInts = Integer.parseInt(input);
            PriorityQueue<Integer> nums = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int i = 0; i < numInts; i++){
                nums.add(Integer.parseInt(st.nextToken()));
            }
            int cost = 0;
            Integer addend;
            while((addend = nums.poll()) != null){
                addend += nums.poll();
                cost += addend;
                if(!(nums.isEmpty())) {
                    nums.add(addend);
                }
            }
            System.out.println(cost);
        }
    }
}
