import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("promote.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
        StringTokenizer bronze = new StringTokenizer(f.readLine());
        StringTokenizer silver = new StringTokenizer(f.readLine());
        StringTokenizer gold = new StringTokenizer(f.readLine());
        StringTokenizer platinum = new StringTokenizer(f.readLine());
        int bronzeBefore = Integer.parseInt(bronze.nextToken());
        int bronzeAfter = Integer.parseInt(bronze.nextToken());
        int silverBefore = Integer.parseInt(silver.nextToken());
        int silverAfter = Integer.parseInt(silver.nextToken());
        int goldBefore = Integer.parseInt(gold.nextToken());
        int goldAfter = Integer.parseInt(gold.nextToken());
        int platinumBefore = Integer.parseInt(platinum.nextToken());
        int platinumAfter = Integer.parseInt(platinum.nextToken());
        int silverDifference = silverAfter - silverBefore;
        int goldDifference = goldAfter - goldBefore;
        int platinumDifference = platinumAfter - platinumBefore;
        int bronzeToSilver = 0;
        int silverToGold = 0;
        int goldToPlatinum = 0;
        bronzeToSilver += silverDifference;
        silverToGold += goldDifference;
        bronzeToSilver += goldDifference;
        goldToPlatinum += platinumDifference;
        silverToGold += platinumDifference;
        bronzeToSilver += platinumDifference;
        out.println(bronzeToSilver);
        out.println(silverToGold);
        out.println(goldToPlatinum);
        f.close();
        out.close();
    }
}
