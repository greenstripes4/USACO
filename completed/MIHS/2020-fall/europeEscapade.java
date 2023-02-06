import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class europeEscapade {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int[] numberOfCountries = new int[N+1];
        for(int i = 0; i <= N; i++) {
            numberOfCountries[i] = f.nextInt();
        }
        char[][] orderOfCountries = new char[N+1][];
        for(int i = 0; i <= N; i++) {
            orderOfCountries[i] = new char[numberOfCountries[i]];
            for(int j = 0; j < numberOfCountries[i]; j++) {
                orderOfCountries[i][j] = f.next().charAt(0);
            }
        }
        int sharedTrainRides = 0;
        for(int i = 1; i <= N; i++) {
            char[] longer = numberOfCountries[i] > numberOfCountries[0] ? orderOfCountries[i] : orderOfCountries[0];
            char[] shorter = numberOfCountries[i] > numberOfCountries[0] ? orderOfCountries[0] : orderOfCountries[i];
            int maxMatches = 0;
            for(int j = -shorter.length+1; j < longer.length; j++) {
                int matches = 0;
                for(int k = 0; k < shorter.length; k++) {
                    if(((j+k >= 0 && j+k < longer.length) ? longer[j+k] : ' ') == shorter[k]) {
                        matches++;
                    }
                }
                maxMatches = Math.max(maxMatches,matches);
            }
            sharedTrainRides += maxMatches;
        }
        out.println(sharedTrainRides);
        f.close();
        out.close();
    }
}
