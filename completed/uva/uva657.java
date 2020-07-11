import java.io.*;
import java.util.*;

public class Main{
    private static int dots;
    private static void fillDot(char[][] picture, int r, int c) {
        if(r < 0 || c < 0 || r >= picture.length || c >= picture[0].length || picture[r][c] != 'X') {
            return;
        }
        picture[r][c] = '*';
        fillDot(picture,r+1,c);
        fillDot(picture,r-1,c);
        fillDot(picture,r,c+1);
        fillDot(picture,r,c-1);
    }
    private static void floodFill(char[][] picture, int r, int c) {
        if(r < 0 || c < 0 || r >= picture.length || c >= picture[0].length || picture[r][c] == '.') {
            return;
        }
        if(picture[r][c] == 'X') {
            dots++;
            fillDot(picture,r,c);
        }
        picture[r][c] = '.';
        floodFill(picture,r+1,c);
        floodFill(picture,r-1,c);
        floodFill(picture,r,c+1);
        floodFill(picture,r,c-1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcase = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) {
                break;
            }
            char[][] picture = new char[h][w];
            for(int i = 0; i < h; i++) {
                picture[i] = f.readLine().toCharArray();
            }
            ArrayList<Integer> dice = new ArrayList<>();
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(picture[i][j] != '.') {
                        dots = 0;
                        floodFill(picture,i,j);
                        dice.add(dots);
                    }
                }
            }
            Collections.sort(dice);
            out.println("Throw " + testcase);
            out.print(dice.get(0));
            for(int i = 1; i < dice.size(); i++) {
                out.print(" " + dice.get(i));
            }
            out.println("\n");
            testcase++;
        }
        f.close();
        out.close();
    }
}
