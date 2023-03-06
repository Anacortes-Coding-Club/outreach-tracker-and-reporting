import java.io.*;
import java.util.*;

public class ParseMD{
    public static Info info = new Info();
    public static String currentDate = null;
    public static void main(String[] args){
        String input = "";
        try{
            //reading the file, and copying it onto the String input.
            File myFile = new File("betterInput.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line = null;
            while ((line = reader.readLine()) != null){
                input += line;
                input += "\n";
            }
            reader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //making Visit objects from input
        String[] events = input.split("\n# ");
        for(int i = 0; i < events.length; i++){
            ParseMD.info.visits.add(new Visit(events[i]));
        }
        System.out.println(ParseMD.info.people.get(0).notes);
    }
}