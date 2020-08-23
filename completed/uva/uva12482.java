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
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            StringTokenizer shortStory = new StringTokenizer(f.readLine());
            int lineCount = 0;
            int remainingCharacters = 0;
            for(int i = 0; i < N; i++) {
                int wordLength = shortStory.nextToken().length();
                if(wordLength > remainingCharacters) {
                    remainingCharacters = C;
                    lineCount++;
                }
                remainingCharacters -= wordLength+1;
            }
            out.println((lineCount+L-1)/L);
        }
        f.close();
        out.close();
    }
}