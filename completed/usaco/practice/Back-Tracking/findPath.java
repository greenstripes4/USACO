import java.util.ArrayList;

public class findPath {
    public static ArrayList<String> path = new ArrayList<>();
    public static boolean recur(int x, int y, int dx, int dy, boolean[][] arr){
        path.add(x + " " + y);
        if(x == dx && y == dy){
            for(String i: path){
                System.out.println(i);
            }
            return true;
        }
        if(x >= arr.length || y >= arr.length || x < 0 || y < 0 || !arr[x][y]){
            path.remove(path.size() - 1);
            return false;
        }
        arr[x][y] = false;
        if(recur(x+1,y,dx,dy,arr)){
            return true;
        } else if(recur(x,y+1,dx,dy,arr)){
            return true;
        } else if(recur(x-1,y,dx,dy,arr)){
            return true;
        } else if(recur(x,y-1,dx,dy,arr)){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
    public static void main(String[] args){
        boolean[][] arr = {{true,false,false,false},{true,true,true,false},{false,false,true,false},{false,false,false,true}};
        recur(0,0,3,3,arr);
    }
}
