import java.io.*;
import java.util.*;

public class Main {
    private static char charAtCodePositionN(String s, long N) {
        if(N <= s.length()) {
            return s.charAt((int)(N-1));
        }
        long previousCodeLength = s.length();
        while(previousCodeLength < N) {
            previousCodeLength *= 2;
        }
        previousCodeLength /= 2;
        long translatedPreviousCodePosition = N-previousCodeLength-1;
        if(translatedPreviousCodePosition == 0) {
            return charAtCodePositionN(s,N-1);
        }
        return charAtCodePositionN(s,translatedPreviousCodePosition);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        String s = st.nextToken();
        long N = Long.parseLong(st.nextToken());
        out.println(charAtCodePositionN(s,N));
        f.close();
        out.close();
    }
}
