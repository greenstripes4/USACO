import java.util.HashSet;

public class sudoku {
    public static int[][] grid;
    public static boolean isValid(int r, int c){
        HashSet<Integer> set = new HashSet<>();
        for(int i: grid[r]){
            if(set.contains(i) && i != 0){
                return false;
            }
            set.add(i);
        }
        set = new HashSet<>();
        for(int[] j: grid){
            if(set.contains(j[c]) && j[c] != 0){
                return false;
            }
            set.add(j[c]);
        }
        set = new HashSet<>();
        int boxR = (int) Math.ceil(r/3);
        int boxC = (int) Math.ceil(c/3);
        int rStart = 3*boxR;
        int rEnd = 3*(boxR+1);
        int cStart = 3*boxC;
        int cEnd = 3*(boxC+1);
        for(int k = rStart; k < rEnd; k++){
            for(int l = cStart; l < cEnd; l++){
                if(set.contains(grid[k][l]) && grid[k][l] != 0){
                    return false;
                }
                set.add(grid[k][l]);
            }
        }
        return true;
    }
    public static boolean solveSudoku(){
        int row = -1;
        int col = -1;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid[i][j] == 0){
                    row = i;
                    col = j;
                    break;
                }
            }
            if(row != -1 && col != -1){
                break;
            }
        }
        if(row == -1 || col == -1){
            for(int[] k: grid){
                for(int l: k){
                    System.out.print(l);
                }
                System.out.println();
            }
            return true;
        }
        for(int m = 1; m <= 9; m++){
            grid[row][col] = m;
            if(isValid(row,col)){
                if(solveSudoku()){
                    return true;
                }
            }
            grid[row][col] = 0;
        }
        return false;
    }
    public static void main(String[] args){
        grid = new int[][]{{9,0,0,1,0,0,0,0,5},
                {0,0,5,0,9,0,2,0,1},
                {8,0,0,0,4,0,0,0,0},
                {0,0,0,0,8,0,0,0,0},
                {0,0,0,7,0,0,0,0,0},
                {0,0,0,0,2,6,0,0,9},
                {2,0,0,3,0,0,0,0,6},
                {0,0,0,2,0,0,9,0,0},
                {0,0,1,9,0,4,5,7,0}};
        solveSudoku();
    }
}
