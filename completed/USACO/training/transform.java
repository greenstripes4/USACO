/*
ID: strongh2
LANG: JAVA
PROG: transform
TASK: transform
 */

import java.io.*;
import java.util.Arrays;

public class transform {
    public static char[][] rotate90(char[][] mat){
        char[][] rotated = new char[mat.length][mat.length];
        for(int i = 0; i < mat.length; i++){
            rotated[i] = mat[i].clone();
        }
        for(int j = 0; j < mat.length; j++){
            for(int k = 0; k < mat.length; k++){
                rotated[k][mat.length-j-1] = mat[j][k];
            }
        }
        return rotated;
    }
    public static char[][] reflectHor(char[][] mat){
        char[][] reflected = new char[mat.length][mat.length];
        for(int i = 0; i < mat.length; i++){
            reflected[i] = mat[i].clone();
        }
        for(int j = 0; j < mat.length; j++){
            for(int k = 0; k < mat.length; k++){
                reflected[j][mat.length-k-1] = mat[j][k];
            }
        }
        return reflected;

    }
    public static boolean equals(char[][] mat1, char[][] mat2){
        for(int i = 0; i < mat1.length; i++){
            if(!Arrays.equals(mat1[i],mat2[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int N = Integer.parseInt(f.readLine());
        char[][] mat = new char[N][N];
        char[][] changedMat = new char[N][N];
        for(int i = 0; i < N; i++){
            mat[i] = f.readLine().toCharArray();
        }
        for(int j = 0; j < N; j++){
            changedMat[j] = f.readLine().toCharArray();
        }
        if(equals(rotate90(mat),changedMat)){
            out.println(1);
        } else if(equals(rotate90(rotate90(mat)),changedMat)){
            out.println(2);
        } else if(equals(rotate90(rotate90(rotate90(mat))),changedMat)){
            out.println(3);
        } else if(equals(reflectHor(mat),changedMat)){
            out.println(4);
        } else if(equals(rotate90(reflectHor(mat)),changedMat) ||
                equals(rotate90(rotate90(reflectHor(mat))),changedMat) ||
                equals(rotate90(rotate90(rotate90(reflectHor(mat)))),changedMat)){
            out.println(5);
        } else if(equals(mat,changedMat)){
            out.println(6);
        } else {
            out.println(7);
        }
        f.close();
        out.close();
    }
}
