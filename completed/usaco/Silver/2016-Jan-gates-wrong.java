import java.io.*;
import java.util.*;
public class gates {
    public static void main(String[] args) throws Exception{
        Scanner in=new Scanner(new File("gates.in"));
        PrintStream out=new PrintStream(new File("gates.out"));

        int a=in.nextInt();
        String b=in.next();

        int x=0;
        int y=0;
        int xpre;
        int ypre;

        Set edges=new HashSet();
        Set vertices=new HashSet();

        vertices.add(x+" "+y);

        for(int c=0;c<a;c++)
        {
            xpre=x;
            ypre=y;

            if(b.charAt(c)=='N')
            {
                x=xpre;
                y=ypre+1;
            }
            else if(b.charAt(c)=='S')
            {
                x=xpre;
                y=ypre-1;
            }
            else if(b.charAt(c)=='E')
            {
                x=xpre+1;
                y=ypre;
            }
            else
            {
                x=xpre-1;
                y=ypre;
            }

            vertices.add(x+" "+y);

            if(b.charAt(c)=='N' || b.charAt(c)=='E')
            {
                edges.add(xpre+" "+ypre+" "+x+" "+y);
            }
            else
            {
                edges.add(x+" "+y+" "+xpre+" "+ypre);
            }
        }
        out.println(edges.size()-vertices.size()+1);
    }
}