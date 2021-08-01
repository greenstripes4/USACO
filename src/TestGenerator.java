import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestGenerator {
    static Random random = new Random();

    // [min, max],default nextInt(n) is [0,n)
    public static int getRandomIntInRange(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    // Generate a "size" array with val [min, max]
    public static int[] getRandomIntArrayInRange(int min, int max, int size) {
        int[] result = new int[size];
        for(int i=0;i<size;i++){
            result[i] = getRandomIntInRange(min, max);
        }
        return result;
    }

    public static char[] DIGITS = {'0','1','2','3','4','5','6','7','8','9'};
    public static char[] LOWER = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static char[] UPPER = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    // Generate a random string with predefined char set
    public static String getRandomString(int length, char[] chset) {
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIdx = random.nextInt(chset.length);
            buffer.append(chset[randomIdx]);
        }
        return buffer.toString();
    }

    // Random permutation from 1 to n
    public static int[] getPermutation(int n){
        int[] array = new int[n];
        for(int i=0;i<n;i++) {
            array[i] = i+1;
        }
        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = random.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
        return array;
    }

    // Generate a random interval between min and max
    public static int[] getRandomInterval(int min, int max){
        int[] result = new int[2];
        int l=getRandomIntInRange(min, max);
        int r=getRandomIntInRange(min, max);
        if(l>r) {
            result[0] = r;
            result[1] = l;
        } else {
            result[0] = l;
            result[1] = r;
        }
        return result;
    }

    //Generate a weighted tree with n nodes, and max weight is "max"
    public static int[][] getWeightTree(int n, int max){
        int[][] result = new int[n-1][3]; //n-1 edges, with the format of "parent, child, weight"
        for(int i=2;i<=n;i++) {
            int fa=getRandomIntInRange(1, i-1);
            int val=getRandomIntInRange(1, max);
            result[i-2][0] = fa;
            result[i-2][1] = i;
            result[i-2][2] = val;
        }
        return result;
    }

    //Generate an un-weighted tree with n nodes
    public static int[][] getUnweightTree(int n){
        int[][] result = new int[n-1][2]; //n-1 edges, with the format of "parent, child"
        for(int i=2;i<=n;i++) {
            int fa=getRandomIntInRange(1, i-1);
            result[i-2][0] = fa;
            result[i-2][1] = i;
        }
        return result;
    }

    //Generate a weighted graph with n nodes, m edges, and max weight is "max"
    public static int[][] getWeightGraph(int n, int m, int max){
        int[][] result = new int[m][3]; //m edges, with the format of "parent, child, weight"
        //Generate a tree first to connect all nodes
        for(int i=2;i<=n;i++) {
            int fa=getRandomIntInRange(1, i-1);
            int val=getRandomIntInRange(1, max);
            result[i-2][0] = fa;
            result[i-2][1] = i;
            result[i-2][2] = val;
        }
        //Generate the other m-n+1 edges
        for(int i=n-1; i<m; i++){
            int n1 = getRandomIntInRange(1, n);
            int n2 = n1;
            while(n2==n1){
                n2=getRandomIntInRange(1, n);
            }
            int val=getRandomIntInRange(1, max);
            result[i][0]= n1;
            result[i][1]= n2;
            result[i][2]= val;
        }
        return result;
    }

    //Generate an unweighted graph with n nodes, m edges
    public static int[][] getUnweightGraph(int n, int m){
        int[][] result = new int[m][2]; //m edges, with the format of "parent, child"
        //Generate a tree first to connect all nodes
        for(int i=2;i<=n;i++) {
            int fa=getRandomIntInRange(1, i-1);
            result[i-2][0] = fa;
            result[i-2][1] = i;
        }
        //Generate the other m-n+1 edges
        for(int i=n-1; i<m; i++){
            int n1 = getRandomIntInRange(1, n);
            int n2 = n1;
            while(n2==n1){
                n2=getRandomIntInRange(1, n);
            }
            result[i][0]= n1;
            result[i][1]= n2;
        }
        return result;
    }

    //Shuffle a matrix by row
    public static int[][] shuffle(int[][] source){
        int n=source.length, m=source[0].length;
        int[][] result = new int[n][m];
        int[] newIdx = getPermutation(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                result[i][j] = source[newIdx[i]-1][j];
            }
        }
        return result;
    }

    // Print an array with separated space
    public static void outputArray(PrintWriter writer, int[] array){
        writer.print(array[0]);
        for(int i=1;i<array.length;i++){
            writer.print(" " + array[i]);
        }
        writer.println();
    }

    // Print a 2D array with separated space
    public static void output2DArray(PrintWriter writer, int[][] array){
        for(int i=0;i<array.length;i++){
            writer.print(array[i][0]);
            for(int j=1;j<array[i].length;j++) {
                writer.print(" " + array[i][j]);
            }
            writer.println();
        }
    }

    // Sample test generator for https://codeforces.com/contest/1551/problem/B2
    public static void generate() throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("uva.in"));
        printWriter.println("1000 1000 2");
        for(int i=0;i<1000;i++) {
            //printWriter.println(getRandomString(10, UPPER));
            //outputArray(printWriter, getRandomIntArrayInRange(1, 10, 10));
            //outputArray(printWriter, getPermutation(7));
            //outputArray(printWriter, getRandomInterval(1,10));
            //output2DArray(printWriter, shuffle(getUnweightTree(10)));
            //output2DArray(printWriter, shuffle(getWeightTree(10, 100)));
            //output2DArray(printWriter, shuffle(getUnweightGraph(10,20)));
            //output2DArray(printWriter, shuffle(getWeightGraph(10,20, 10)));
            printWriter.println(getRandomString(1000, new char[] {'.', '#'}));
        }
        printWriter.println("2 2 3 3");
        printWriter.println("3 3 4 4");
        printWriter.close();
    }
}
