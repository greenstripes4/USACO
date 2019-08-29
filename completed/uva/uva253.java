import java.io.*;
/*
O(n^6)
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0
 */
class Cube{
    String face1 ,face2 ,face3 ,face4 , face5 ,face6;
    public Cube(String face1, String face2, String face3, String face4, String face5, String face6){
        this.face1 = face1;
        this.face2 = face2;
        this.face3 = face3;
        this.face4 = face4;
        this.face5 = face5;
        this.face6 = face6;
    }
    public void rotateHor(){
        String tmp2 = face2;
        String tmp3 = face3;
        String tmp4 = face4;
        String tmp5 = face5;
        this.face2 = tmp3;
        this.face3 = tmp5;
        this.face4 = tmp2;
        this.face5 = tmp4;
    }
    public void rotateVer(){
        String tmp1 = face1;
        String tmp2 = face2;
        String tmp5 = face5;
        String tmp6 = face6;
        this.face1 = tmp5;
        this.face2 = tmp1;
        this.face5 = tmp6;
        this.face6 = tmp2;
    }
    public boolean equals(Cube o){
        if(this.face1.equals(o.face1) && this.face2.equals(o.face2) && this.face3.equals(o.face3) && this.face4.equals(o.face4) && this.face5.equals(o.face5) && this.face6.equals(o.face6)) {
            return true;
        }
        return false;
    }
}
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            String[] faces = input.split("");
            Cube c1 = new Cube(faces[0],faces[1],faces[2],faces[3],faces[4],faces[5]);
            Cube c2 = new Cube(faces[6],faces[7],faces[8],faces[9],faces[10],faces[11]);
            boolean same = false;
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 4; k++){
                        if(c1.equals(c2)){
                            same = true;
                            break;
                        }
                        c1.rotateHor();
                    }
                    c1.rotateVer();
                }
                c1.rotateHor();
            }
            out.println(same ? "TRUE":"FALSE");
        }
        f.close();
        out.close();
    }
}
