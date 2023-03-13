import java.io.*;
import java.util.*;
/**
 * This is the main class for this program
 * Apart from containing main(), it also has file reading and writing capabilities.
 * @author Kai G
 */
 /*a note on the sample files:
 betterInput would be the file to input
 allInput would be the file, stored in the program, holding all input up to now
 ideally, both would be in .md instead of .txt format.*/
public class ParseMD{
    public static Info info = new Info(); //the info object, where everything is stored.
    public static String currentDate = null; //holds the date currently being proscessed in string form, for use in person notes.
    public static ArrayList<String> inputs = new ArrayList<String>();
    
    
    public static void main(String[] args){
        GuiAttempt gui = new GuiAttempt();
        gui.go();
    }
    /**
     * reads the new input, as well as allInput
     * writes the new input on to allInput
     * tagifies the whole document
     * creates visit objects
     */
    private void parse(){
        //reading files and adding new input to allInput
        String input = readTxt("betterInput.md");
        
        //info's taggable stuff
        info.rawNotes = input;
        info.tagify();
        
        //making Visit objects from input
        String[] events = input.split("\n# ");
        for(int i = 0; i < events.length; i++){
            ParseMD.info.visits.add(new Visit(events[i]));
            //System.out.println("got to visit "+i);
        }
        
        //test code
        System.out.println(info.visits.get(0).tags[0]);
        for(int i = 0; i < info.tags.length; i++){
            System.out.println(info.tags[i]);
        }
        /*guiAttempt g = new guiAttempt();
        g.go();*/
    }
    
    /**
     * reads files
     * @arguments name is the name of the file you want to read. 
     * @return the contents of the file, in string format
     * i'm not sure if it works with anything other than .txt files
     */
    public static String readTxt(String name){
        String input = "";
        try{
            //reading the file, and copying it onto the String input.
            File myFile = new File(name);
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
        return input;
    }
    
    /**
     * writes files
     * @arguments input is the content that you want to write to the file
     * @arguments name is the name of the file you want to write. 
     * i'm not sure if it works with anything other than .txt files
     */
    public static void writeTxt(String input, String name){
        try{
            FileWriter writer = new FileWriter(name);
            writer.write(input);
            writer.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}