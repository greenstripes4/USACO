import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int X = Integer.parseInt(f.readLine());
        for(int i = 0; i < X; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            char[][] image = new char[R][C];
            for(int j = 0; j < R; j++){
                image[j] = f.readLine().toCharArray();
            }
            HashMap<Character,Integer> pixels = new HashMap<>();
            for(int j = 0; j < R; j++){
                for(int k = 0; k < C; k++){
                    pixels.put(image[j][k],pixels.getOrDefault(image[j][k],0)+1);
                }
            }
            int maxPixels = 0;
            int maxCharacters = 0;
            for(char j: pixels.keySet()){
                if(pixels.get(j) > maxPixels) {
                    maxPixels = pixels.get(j);
                    maxCharacters = 1;
                } else if(pixels.get(j) == maxPixels) {
                    maxCharacters++;
                }
            }
            out.println("Case " + (i+1) + ": " + ((maxPixels*maxCharacters)*M + (R*C-maxPixels*maxCharacters)*N));
        }
        f.close();
        out.close();
    }
}
