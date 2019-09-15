public class NQueens {
    static int N;
    static int[] rows;
    static int count;

    public static void printRow(int row){
        for (int i=0; i<N; i++) {
            if(i != row) {
                System.out.print("_");
            } else {
                System.out.print("Q");
            }
        }
        System.out.println();
    }
    public static void getSolutions(int x){
        if(x == N){
            for(int i = 0; i < N; i++){
                printRow(rows[i]);
            }
            System.out.println();
            count++;
            return;
        }
        for(int j = 0; j < N; j++){
            if(isValid(rows,j,x)){
                rows[x] = j;
                getSolutions(x+1);
                rows[x] = 0;
            }
        }
    }
    public static boolean isValid(int[] r, int i, int x){
        for(int j = 0; j < x; j++){
            if(r[j] == i || Math.abs(r[j] - i) == Math.abs(j - x)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        N = 8;
        rows = new int[N];
        getSolutions(0);
        System.out.println(count);
    }
}
