import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;

public class BruteForceTester {
    private static int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void testGenerator() throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("uva.in"));
        int t = 1;
        int n = 10;
        printWriter.println(t);
        printWriter.println(n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(getRandomNumberInRange(0, 100));
            sb.append(" ");
        }
        printWriter.println(sb.substring(0, sb.length()-1));
        sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(getRandomNumberInRange(0, 100));
            sb.append(" ");
        }
        printWriter.println(sb.substring(0, sb.length()-1));
        printWriter.close();
    }

    public static void main(String[] args) throws Exception {
        // Store current System.out before assigning a new value
        PrintStream console = System.out;

        for (int i = 1; i <= 1000; i++) {
            File targetInput = new File("uva.in");
            File mainOutput = new File("main.out");
            File mainBFOutput = new File("mainbf.out");
            PrintStream om = new PrintStream(mainOutput);
            PrintStream obf = new PrintStream(mainBFOutput);
            // comment to false if you generate the uva.in manually
            if (true) {
                if (targetInput.exists()) {
                    targetInput.delete();
                }
                if (mainOutput.exists()) {
                    mainOutput.delete();
                }
                if (mainBFOutput.exists()) {
                    mainBFOutput.delete();
                }
                testGenerator();
            }

            System.setOut(om);
            Main.main(null);
            System.setOut(obf);
            MainBruteforce.main(null);
            System.setOut(console);

            BufferedReader reader1 = new BufferedReader(new FileReader(mainOutput));
            BufferedReader reader2 = new BufferedReader(new FileReader(mainBFOutput));
            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            boolean areEqual = true;
            int lineNum = 1;
            while (line1 != null || line2 != null) {
                if (line1 == null || line2 == null) {
                    areEqual = false;
                    break;
                } else if (!line1.equals(line2)) {
                    areEqual = false;
                    break;
                }
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineNum++;
            }

            if (areEqual) {
                System.out.println("Random test " + i + " passed");
            } else {
                System.out.println("Random test " + i + " failed");
                System.out.println("Expected " + line1 + " and got " + line2 + " at line " + lineNum);
                break;
            }
            reader1.close();
            reader2.close();
        }
    }
}
