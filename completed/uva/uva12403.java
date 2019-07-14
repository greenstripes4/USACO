import java.io.*;
import java.util.StringTokenizer;
//O(1)
//7
//donate 1000
//report
//donate 500
//report
//donate 100000
//donate 100
//report

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        int total = 0;
        for(int i = 0; i<cases; i++){
            String input = f.readLine();
            if(input.equals("report")){
                System.out.println(total);
            }
            else{
                StringTokenizer st = new StringTokenizer(input);
                String useless = st.nextToken();
                total += Integer.parseInt(st.nextToken());
            }
        }
    }
}
