import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static int cycleLength(int x){
        if(x == 1){
            return 1;
        }
        else if(x%2 == 0){
            return 1+cycleLength(x/2);
        }
        else{
            return 1+cycleLength(3*x+1);
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int max = 0;
            for(int i = Math.min(start,end); i<=Math.max(start,end); i++){
                int result = cycleLength(i);
                if(result > max){
                    max = result;
                }
            }
            System.out.println(Integer.toString(start) + " " + Integer.toString(end) + " " + max);
        }
    }
}
