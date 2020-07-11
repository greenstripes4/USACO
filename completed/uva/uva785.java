import java.io.*;
import java.util.*;

public class Main{
    private static void floodFill(ArrayList<char[]> grid, int r, int c, char target) {
        if(r < 0 || r >= grid.size() || c < 0 || c >= grid.get(r).length || grid.get(r)[c] != ' ') {
            return;
        }
        grid.get(r)[c] = target;
        floodFill(grid,r-1,c,target);
        floodFill(grid,r+1,c,target);
        floodFill(grid,r,c-1,target);
        floodFill(grid,r,c+1,target);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            ArrayList<char[]> grid = new ArrayList<>();
            grid.add(input.toCharArray());
            String row;
            while((row = f.readLine()).charAt(0) != '_') {
                grid.add(row.toCharArray());
            }
            for(int i = 0; i < grid.size(); i++) {
                for(int j = 0; j < grid.get(i).length; j++) {
                    if(grid.get(i)[j] != 'X' && grid.get(i)[j] != ' ') {
                        char temp = grid.get(i)[j];
                        grid.get(i)[j] = ' ';
                        floodFill(grid,i,j,temp);
                    }
                }
            }
            for(char[] i: grid) {
                out.println(i);
            }
            out.println(row);
        }
        f.close();
        out.close();
    }
}
