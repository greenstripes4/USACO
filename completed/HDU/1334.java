import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] cubes = new int[200];
        for(int i = 1; i <= 200; i++){
            cubes[i-1] = i*i*i;
        }
        ArrayList<int[]> ans = new ArrayList<>();
        for(int j = 2; j <= 200; j++) {
            for (int k = j + 1; k <= 200; k++) {
                for (int l = k + 1; l <= 200; l++) {
                    int index = Arrays.binarySearch(cubes, cubes[j - 1] + cubes[k - 1] + cubes[l - 1]);
                    if (index >= 0) {
                        ans.add(new int[]{(index + 1),j,k,l});
                    }
                }
            }
        }
        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1]){
                        if(o1[2] == o2[2]){
                            return o1[3] - o2[3];
                        } else{
                            return o1[2] - o2[2];
                        }
                    } else {
                        return o1[1] - o2[1];
                    }
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        for(int[] a: ans){
            out.println("Cube = " + a[0] + ", Triple = (" + a[1] + "," + a[2] + "," + a[3] + ")");
        }
        out.close();
    }
}

