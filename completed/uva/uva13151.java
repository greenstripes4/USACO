import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int iValueDecimal;
            String i = st.nextToken();
            if(i.charAt(0) == '0') {
                if(i.charAt(1) == 'x') {
                    iValueDecimal = Integer.parseInt(i.substring(2), 16);
                } else {
                    iValueDecimal = Integer.parseInt(i.substring(1), 8);
                }
            } else {
                iValueDecimal = Integer.parseInt(i);
            }
            int t = Integer.parseInt(st.nextToken());
            int score = 0;
            for(int j = 0; j < t; j++) {
                st = new StringTokenizer(f.readLine());
                String expression = st.nextToken();
                int outputValue = Integer.parseInt(st.nextToken());
                if(expression.equals("++i")) {
                    iValueDecimal++;
                }
                if(expression.equals("--i")) {
                    iValueDecimal--;
                }
                if(iValueDecimal == outputValue) {
                    score++;
                }
                iValueDecimal = outputValue;
                if(expression.equals("i++")) {
                    iValueDecimal++;
                }
                if(expression.equals("i--")) {
                    iValueDecimal--;
                }
            }
            out.println(score);
        }
        f.close();
        out.close();
    }
}
