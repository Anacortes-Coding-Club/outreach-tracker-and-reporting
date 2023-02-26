import java.io.*;
import java.util.*;

public class ParseMD{
    public static char[] chars;
    private static ArrayList<Visit> visits = new ArrayList<Visit>();
    public static void main(String[] args){
        String thing = "";
        try{
            //reading the file, and copying it onto the String thing.
            File myFile = new File("input.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line = null;
            while ((line = reader.readLine()) != null){
                thing += line;
                thing += "\n";
            }
            reader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        String[] events = thing.split("### ");
        /*for(int i=0; i<thing.length(); i++){
            
            ParseMD.chars.add(thing.charAt(i));
        }*/
        chars = thing.toCharArray();
        for(int i = 1; i < events.length; i++){
            if(events[i-1].contains("# ")){
                System.out.println("NEW EVENT");
                ParseMD.visits.add(new Visit("February 20, 2023"));
            }
                
            System.out.println(events[i]+"\n");
        }
    }
}