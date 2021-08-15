import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class UVATester {
    private static Runtime rt = Runtime.getRuntime();

    public static boolean isMacOs(){
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.startsWith("mac os x");
    }

    public static void initRuntime(){
    }

    public static long getMemoryUsage(){
        return (rt.totalMemory() - rt.freeMemory())/1024/1024;
    }
    public static void main(String[] args) throws IOException {
        initRuntime();
        // Store current System.out before assigning a new value
        PrintStream console = System.out;

        final String problem = "UVa100";
        File targetInput = new File("uva.in");
        File targetOutput = new File("main.out");
        File dir = new File("test\\" + problem);
        File[] inputs = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".in");
            }
        });

        for (File input : inputs) {
            String input_fullpath = input.getAbsolutePath();
            int index = input_fullpath.lastIndexOf(".");
            String output_file = input_fullpath.substring(0, index) + ".out";
            File output = new File(output_file);
            if(!isMacOs()) {
                if (targetInput.exists()) {
                    targetInput.delete();
                }
                if (targetOutput.exists()) {
                    targetOutput.delete();
                }
            }

            Files.copy(input.toPath(), targetInput.toPath());
            System.out.print("Test " + input.getName() + ":");
            long start = System.nanoTime();
            long mem = 0;
            try {
                rt.gc();// Enforce GC before every case
                PrintStream om = new PrintStream(targetOutput);
                System.setOut(om);
                Main.main(null);
                mem = getMemoryUsage();
            } catch (Exception e) {
                System.out.println(input.getName() + " Runtime Error");
                continue;
            }
            System.setOut(console);
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
                    System.out.println(" Limit Exceed with " + ms + "ms time and " + mem + "MB memory");
                } else {
                    System.out.println(" passed in " + ms + "ms time and " + mem + "MB memory");
                }
            } else {
                System.out.println(" failed in " + ms + "ms");
                //System.out.println("Expected " + line2 + " and got " + line1 + " at line " + lineNum);
            }
        }
    }
}
