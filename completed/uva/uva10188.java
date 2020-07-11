import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int run = 1;
        while(true){
            int n = Integer.parseInt(f.readLine());
            if(n == 0){
                break;
            }
            StringBuilder correct = new StringBuilder();
            for(int i = 0; i < n; i++){
                correct.append(f.readLine());
                correct.append("\n");
            }
            int m = Integer.parseInt(f.readLine());
            StringBuilder submission = new StringBuilder();
            for(int i = 0; i < m; i++){
                submission.append(f.readLine());
                submission.append("\n");
            }
            String correctWithoutNumbers = correct.toString().replaceAll("[^0-9]+","");
            String submissionWithoutNumbers = submission.toString().replaceAll("[^0-9]+", "");
            if(correct.toString().equals(submission.toString())){
                out.println("Run #" + run + ": Accepted");
            } else if(correctWithoutNumbers.equals(submissionWithoutNumbers)) {
                out.println("Run #" + run + ": Presentation Error");
            } else {
                out.println("Run #" + run + ": Wrong Answer");
            }
            run++;
        }
        f.close();
        out.close();
    }
}
