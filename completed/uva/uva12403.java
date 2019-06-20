import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(f.readLine());
        int amount = 0;
        for(int i = 0; i<cases; i++){
            String input = f.readLine();
            if(input.equals("report")){
                System.out.println(amount);
            }
            else{
                StringTokenizer st = new StringTokenizer(input);
                String useless = st.nextToken();
                amount += Integer.parseInt(st.nextToken());
            }
        }
    }
}
