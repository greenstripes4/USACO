import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        HashSet<Integer> possibleScores = new HashSet<>();
        possibleScores.add(0);
        for(int i = 1; i <= 20; i++) {
            possibleScores.add(i);
            possibleScores.add(i*2);
            possibleScores.add(i*3);
        }
        possibleScores.add(50);
        while(true) {
            int x = Integer.parseInt(f.readLine());
            if(x <= 0) {
                break;
            }
            HashSet<String> combinations = new HashSet<>();
            int permutations = 0;
            for(int i: possibleScores) {
                for(int j: possibleScores) {
                    for(int k: possibleScores) {
                        int totalScore = i+j+k;
                        if(totalScore == x) {
                            int[] combination = {i,j,k};
                            Arrays.sort(combination);
                            combinations.add(combination[0]+" "+combination[1]+" "+combination[2]);
                            permutations++;
                        }
                    }
                }
            }
            if(combinations.size() == 0 && permutations == 0) {
                out.println("THE SCORE OF " + x + " CANNOT BE MADE WITH THREE DARTS.");
            } else {
                out.println("NUMBER OF COMBINATIONS THAT SCORES " + x + " IS " + combinations.size() + ".");
                out.println("NUMBER OF PERMUTATIONS THAT SCORES " + x + " IS " + permutations + ".");
            }
            out.println("**********************************************************************");
        }
        out.println("END OF OUTPUT");
        f.close();
        out.close();
    }
}
