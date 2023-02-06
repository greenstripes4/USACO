import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BruteForceTester {
    static boolean isJava = true;

    public static boolean isMacOs(){
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.startsWith("mac os x");
    }

    public static void ABTest(int rounds) throws Exception{
        // Store current System.out before assigning a new value
        PrintStream console = System.out;

        for (int i = 1; i <= rounds; i++) {
            File targetInput = new File("uva.in");
            File mainOutput = new File("main.out");
            File mainBFOutput = new File("mainbf.out");
            PrintStream om = new PrintStream(mainOutput);
            PrintStream obf = new PrintStream(mainBFOutput);
            // comment to false if you generate the uva.in manually
            if (true) {
                if(!isMacOs()) {
                    if (targetInput.exists()) {
                        targetInput.delete();
                    }
                    if (mainOutput.exists()) {
                        mainOutput.delete();
                    }
                    if (mainBFOutput.exists()) {
                        mainBFOutput.delete();
                    }
                }
                TestGenerator.generate();
            }

            System.setOut(om);
            long start = System.nanoTime();
            Main.main(null);
            long end = System.nanoTime();
            long msMain = ((end - start) / 1000000);
            System.setOut(obf);
            start = System.nanoTime();
            if(isJava){
                MainBruteforce.main(null);
            } else {
                String filePath = "test.exe";
                try {
                    Process p = Runtime.getRuntime().exec(filePath);
                    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()) );
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                    in.close();
                    p.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            end = System.nanoTime();
            long msBF = ((end - start) / 1000000);
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
                System.out.println("Random test " + i + " passed within (" + msMain + "|" + msBF + "ms)");
            } else {
                System.out.println("Random test " + i + " failed");
                System.out.println("Expected " + line2 + " and got " + line1 + " at line " + lineNum);
                break;
            }
            reader1.close();
            reader2.close();
        }
    }

    public static void ValidtorTest(int rounds) throws Exception {
        // Store current System.out before assigning a new value
        PrintStream console = System.out;

        for (int i = 1; i <= rounds; i++) {
            File targetInput = new File("uva.in");
            File mainOutput = new File("main.out");
            PrintStream om = new PrintStream(mainOutput);

            // comment to false if you generate the uva.in manually
            if (true) {
                if(!isMacOs()) {
                    if (targetInput.exists()) {
                        targetInput.delete();
                    }
                    if (mainOutput.exists()) {
                        mainOutput.delete();
                    }
                    TestGenerator.generate();
                }
            }
            System.setOut(om);
            Main.main(null);
            System.setOut(console);

            if (TestValidator.validate(mainOutput)) {
                System.out.println("Random test " + i + " passed");
            } else {
                System.out.println("Random test " + i + " failed, please check main.out for the output");
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        //ABTest(1000);
        ValidtorTest(1000);
    }
}
