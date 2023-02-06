import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("logo.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("logo.out")));
        out.println("   /|");
        out.println(" _| |  _____");
        out.println("\\_  | |  __/");
        out.println("  | | | |__");
        out.println("  |_| |____\\");
        out.println(" 'TeamsCode'");
        f.close();
        out.close();
    }
}
