import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class USCAOTester {
    public static void main(String[] args) throws IOException {
        final String problem = "pageant";
        File targetInput = new File(problem + ".in");
        File targetOutput = new File(problem + ".out");
        for (int i = 1; i <= 20; i++) {
            File input = new File("test\\" + problem + "\\" + i+".in");
            if(!input.exists()) {
                input = new File("test\\" + problem + "\\I." + i);
            }
            File output = new File("test\\" + problem + "\\" + i+".out");
            if(!output.exists()) {
                output = new File("test\\" + problem + "\\O." + i);
            }
            if(!input.exists()) {
                continue;
            }

            if (targetInput.exists()) {
                targetInput.delete();
            }
            if (targetOutput.exists()) {
                targetOutput.delete();
            }
            Files.copy(input.toPath(), targetInput.toPath());
            Main.main(null);

            BufferedReader reader1 = new BufferedReader(new FileReader(targetOutput));
            BufferedReader reader2 = new BufferedReader(new FileReader(output));
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
                System.out.println("I." + i + " test passed");
            } else {
                System.out.println("I." + i + " test failed");
                //System.out.println("Expected " + line1 + " and got " + line2 + " at line " + lineNum);
                break;
            }
            reader1.close();
            reader2.close();
            if (targetInput.exists()) {
                targetInput.delete();
            }
            if (targetOutput.exists()) {
                targetOutput.delete();
            }
        }
    }
}
