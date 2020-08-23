import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 1; t <= N; t++) {
            int n = Integer.parseInt(f.readLine());
            char[] vowels = {'A','U','E','O','I'};
            char[] consonants = {'J','S','B','K','T','C','L','D','M','V','N','W','F','X','G','P','Y','H','Q','Z','R'};
            int vowelInd = 0;
            int consonantInd = 0;
            int vowelUses = 0;
            int consonantUses = 0;
            boolean vowel = true;
            StringBuilder vowelComponent = new StringBuilder();
            StringBuilder consonantComponent = new StringBuilder();
            for(int i = 0; i < n; i++) {
                if(vowel) {
                    if(vowelUses >= 21) {
                        vowelInd++;
                        vowelUses = 0;
                    }
                    vowelComponent.append(vowels[vowelInd]);
                    vowelUses++;
                } else {
                    if(consonantUses == 5) {
                        consonantInd++;
                        consonantUses = 0;
                    }
                    consonantComponent.append(consonants[consonantInd]);
                    consonantUses++;

                }
                vowel = !vowel;
            }
            char[] vowelsSorted = vowelComponent.toString().toCharArray();
            char[] consonantsSorted = consonantComponent.toString().toCharArray();
            Arrays.sort(vowelsSorted);
            Arrays.sort(consonantsSorted);
            StringBuilder name = new StringBuilder();
            for(int i = 0; i < n/2; i++) {
                name.append(vowelsSorted[i]);
                name.append(consonantsSorted[i]);
            }
            if(n%2 == 1) {
                name.append(vowelsSorted[vowelsSorted.length-1]);
            }
            out.println("Case " + t + ": " + name);
        }
        f.close();
        out.close();
    }
}
