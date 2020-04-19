import java.io.*;
import java.util.*;

class Tape{
    private List<Integer> trackLengths;
    private int totalLength;
    public Tape(List<Integer> trackLengths, int totalLength){
        this.trackLengths = trackLengths;
        this.totalLength = totalLength;
    }
    public List<Integer> getTrackLengths() {
        return trackLengths;
    }
    public int getTotalLength() {
        return totalLength;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i: trackLengths){
            sb.append(i);
            sb.append(" ");
        }
        sb.append("sum:");
        sb.append(totalLength);
        return sb.toString();
    }
}

public class Main{
    private static void getAllPossibleTapes(List<Tape> allPossibleTapes, List<Integer> trackLengths, int totalLength, int N, int ind, int[] tracks){
        if(ind == tracks.length){
            allPossibleTapes.add(new Tape(trackLengths,totalLength));
            return;
        }
        List<Integer> temp = new ArrayList<>();
        temp.addAll(trackLengths);
        getAllPossibleTapes(allPossibleTapes,temp,totalLength,N,ind+1,tracks);
        if(totalLength + tracks[ind] <= N) {
            temp = new ArrayList<>();
            temp.addAll(trackLengths);
            temp.add(tracks[ind]);
            getAllPossibleTapes(allPossibleTapes, temp, totalLength+tracks[ind], N, ind+1, tracks);
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()){
            int N = f.nextInt();
            int numTracks = f.nextInt();
            int[] tracks = new int[numTracks];
            for(int i = 0; i < numTracks; i++){
                tracks[i] = f.nextInt();
            }
            List<Tape> allPossibleTapes = new ArrayList<>();
            getAllPossibleTapes(allPossibleTapes,new ArrayList<>(),0,N,0,tracks);
            Tape maxLength = null;
            for(Tape i: allPossibleTapes){
                if(maxLength == null || i.getTotalLength() > maxLength.getTotalLength() || (i.getTotalLength() == maxLength.getTotalLength() && i.getTrackLengths().size() > maxLength.getTrackLengths().size())){
                    maxLength = i;
                }
            }
            out.println(maxLength);
        }
        f.close();
        out.close();
    }
}
