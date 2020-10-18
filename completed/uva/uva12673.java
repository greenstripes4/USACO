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
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int[] scoreDifference = new int[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(f.readLine());
                int S = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                scoreDifference[i] = R-S;
            }
            Arrays.sort(scoreDifference);
            int totalPoints = 0;
            for(int i = 0; i < N; i++) {
                if(scoreDifference[i] < 0) {
                    totalPoints += 3;
                } else if(scoreDifference[i] == 0) {
                    if(G > 0) {
                        totalPoints += 3;
                        G--;
                    } else {
                        totalPoints++;
                    }
                } else {
                    if(G > scoreDifference[i]) {
                        totalPoints += 3;
                        G -= scoreDifference[i]+1;
                    } else if(G == scoreDifference[i]) {
                        totalPoints++;
                        G = 0;
                    }
                }
            }
            out.println(totalPoints);
        }
        f.close();
        out.close();
    }
}
