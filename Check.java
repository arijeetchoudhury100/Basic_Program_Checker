package assignment3.basic;
import java.util.*;
import java.io.*;

public class Check{
    HashMap<Integer,String> h;
    HashMap<Integer,String> h2;
    Check(){
        h = new HashMap<Integer,String>();
        h2 = new HashMap<Integer,String>();
    }
    public void rearrange(String filename,int f,int d){
        readFile(filename);
        int k = 1;
        while(h.get(f) != null){
            h2.put(k,h.get(f));
            f = f+d;
            k = k+1;
        }
        System.out.println("original:");
        print(h);
        System.out.println("rearranged:");
        print(h2);
    }
    private void readFile(String filename){
        File file = new File("/home/laxus/dsad/assignment3/basic/"+filename);
        try{
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                String lineNumber = s.next();
                int num = Integer.parseInt(lineNumber);
                h.put(num,s.nextLine());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found..");
        }
    }
    private void print(HashMap<Integer,String> h){
        for(int key : h.keySet() ){
            System.out.println(key+" "+h.get(key));
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter F");
        int f = s.nextInt();
        System.out.println("Enter D");
        int d = s.nextInt();
        
        Check c = new Check();
        c.rearrange("program.txt", f, d);
    }
}
