import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int firstX1 = Integer.parseInt(st.nextToken());
        int firstY1 = Integer.parseInt(st.nextToken());
        int firstX2 = Integer.parseInt(st.nextToken());
        int firstY2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int secondX1 = Integer.parseInt(st.nextToken());
        int secondY1 = Integer.parseInt(st.nextToken());
        int secondX2 = Integer.parseInt(st.nextToken());
        int secondY2 = Integer.parseInt(st.nextToken());
        int upperLeftX = Math.min(firstX1,secondX1);
        int upperLeftY = Math.min(firstY1,secondY1);
        int lowerRightX = Math.max(firstX2,secondX2);
        int lowerRightY = Math.max(firstY2,secondY2);
        out.println(Math.max(lowerRightX-upperLeftX,lowerRightY-upperLeftY)*Math.max(lowerRightX-upperLeftX,lowerRightY-upperLeftY));
        f.close();
        out.close();
    }
}
