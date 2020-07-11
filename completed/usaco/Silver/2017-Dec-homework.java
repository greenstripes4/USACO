import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("homework.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[] homeworkQuestions = new int[N];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++) {
            homeworkQuestions[i] = Integer.parseInt(st.nextToken());
        }
        double max = 0;
        int min = homeworkQuestions[N-1];
        int total = homeworkQuestions[N-1];
        double[] scores = new double[N-2];
        for(int i = N-2; i >= 1; i--) {
            min = Math.min(min,homeworkQuestions[i]);
            total += homeworkQuestions[i];
            max = Math.max(max,((double)(total-min))/(N-i-1));
            scores[i-1] = ((double)(total-min))/(N-i-1);
        }
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == max) {
                out.println(i+1);
            }
        }
        f.close();
        out.close();
    }
}
