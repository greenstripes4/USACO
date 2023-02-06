import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class USCAOTester {
    private static Runtime rt = Runtime.getRuntime();
    public static void initRuntime(){
    }

    public static long getMemoryUsage(){
        return (rt.totalMemory() - rt.freeMemory())/1024/1024;
    }
    public static void main(String[] args) throws IOException {
        initRuntime();
        final String problem = "berries_silver_jan20";
        File targetInput = new File(problem + ".in");
        File targetOutput = new File(problem + ".out");
        String[] tests = {"ray-test\\", "test\\"};

        for(String test : tests) {
            for (int i = 1; i <= 20; i++) {
            //for (int i = 20; i >= 0; i--) {
                File input = new File(test + problem + "\\I." + i);
                if (!input.exists()) {
                    input = new File(test + problem + "\\" + i + ".in");
                }
                File output = new File(test + problem + "\\O." + i);
                if (!output.exists()) {
                    output = new File(test + problem + "\\" + i + ".out");
                }
                if (!input.exists()) {
                    continue;
                }

                if (targetInput.exists()) {
                    targetInput.delete();
                }
                if (targetOutput.exists()) {
                    targetOutput.delete();
                }
                Files.copy(input.toPath(), targetInput.toPath());
                long start = System.nanoTime();
                long mem = 0;
                try {
                    rt.gc();// Enforce GC before every case
                    Main.main(null);
                    mem = getMemoryUsage();
                } catch (Exception e) {
                    System.out.println(test + ":" + i + " Runtime Error");
                    continue;
                }
                long end = System.nanoTime();

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

                reader1.close();
                reader2.close();
                if (targetInput.exists()) {
                    targetInput.delete();
                }
                if (targetOutput.exists()) {
                    targetOutput.delete();
                }
                long ms = ((end - start) / 1000000);
                if (areEqual) {
                    //for most contests, 2 seconds per input case for C, C++, and Pascal,
                    // and 4 seconds per input case for Java and Python,
                    // although the each contest or problem may use slightly different limits
                    // USACO machine is about 10x slower than local, use 350 as TLE
                    if(ms > 350 || mem > 256){
                        System.out.println(test + ":" + i + " test Limit Exceed with " + ms + "ms time and " + mem + "MB memory");
                    } else {
                        System.out.println(test + ":" + i + " test passed in " + ms + "ms time and " + mem + "MB memory");
                    }
                } else {
                    System.out.println(test + ":" + i + " test failed in " + ms + "ms");
                    //System.out.println("Expected " + line2 + " and got " + line1 + " at line " + lineNum);
                }
            }
        }
    }
}
