import java.io.*;
import java.util.*;

public class Main {
    private static void floodFill(char[][] image, int row, int column, char color) {
        if(row < 0 || row >= image.length || column < 0 || column >= image[0].length || image[row][column] != color) {
            return;
        }
        image[row][column] = ' ';
        floodFill(image,row-1,column,color);
        floodFill(image,row+1,column,color);
        floodFill(image,row,column-1,color);
        floodFill(image,row,column+1,color);
    }
    private static boolean isPCL(char[][] image, int top, int left, int bottom, int right) {
        char firstColor = image[top][left];
        boolean foundSecondColor = false;
        char secondColor = ' ';
        for(int i = top; i <= bottom; i++) {
            for(int j = left; j <= right; j++) {
                if(image[i][j] != firstColor) {
                    if(!foundSecondColor) {
                        foundSecondColor = true;
                        secondColor = image[i][j];
                    } else {
                        if(image[i][j] != secondColor) {
                            return false;
                        }
                    }
                }
            }
        }
        if(!foundSecondColor) {
            return false;
        }
        char[][] copyImage = new char[bottom-top+1][right-left+1];
        for(int i = top; i <= bottom; i++) {
            copyImage[i-top] = Arrays.copyOfRange(image[i],left,right+1);
        }
        int firstColorSectors = 0;
        int secondColorSectors = 0;
        for(int i = 0; i <= bottom-top; i++) {
            for(int j = 0; j <= right-left; j++) {
                if(copyImage[i][j] == firstColor) {
                    floodFill(copyImage,i,j,firstColor);
                    firstColorSectors++;
                } else if(copyImage[i][j] == secondColor) {
                    floodFill(copyImage,i,j,secondColor);
                    secondColorSectors++;
                }
            }
        }
        return (firstColorSectors == 1 && secondColorSectors > 1) || (firstColorSectors > 1 && secondColorSectors == 1);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("where.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        int N = Integer.parseInt(f.readLine());
        char[][] image = new char[N][N];
        for(int i = 0; i < N; i++) {
            image[i] = f.readLine().toCharArray();
        }
        int PCLs = 0;
        ArrayList<int[]> previousPCLS = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = i; k < N; k++) {
                    for(int l = j; l < N; l++) {
                        if(isPCL(image,i,j,k,l)) {
                            boolean isContained = false;
                            for(int[] m: previousPCLS) {
                                if(m[0] <= i && m[1] <= j && m[2] >= k && m[3] >= l) {
                                    isContained = true;
                                    break;
                                }
                            }
                            if(!isContained) {
                                previousPCLS.add(new int[]{i,j,k,l});
                                PCLs++;
                            }
                        }
                    }
                }
            }
        }
        out.println(PCLs);
        f.close();
        out.close();
    }
}
