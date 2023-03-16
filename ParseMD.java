import java.io.*;
import java.util.*;
/**
 * This is the main class for this program
 * Apart from containing main(), it also has file reading and writing capabilities.
 * @author Kai G
 */
 
public class ParseMD{
    public static Info info = new Info(); //the info object, where everything is stored.
    public static String currentDate = null; //holds the date currently being proscessed in string form, for use in person notes.
    public static ArrayList<String> inputs = new ArrayList<String>();
    
    
    public static void main(String[] args){
        GuiAttempt gui = new GuiAttempt();
        inputs = (ArrayList<String>) readObj("inputs.ser");
        gui.go();
        writeObj(inputs, "inputs.ser");
    }
    /**
     * reads the new input, as well as allInput
     * writes the new input on to allInput
     * tagifies the whole document
     * creates visit objects
     */
    private static void parse(){
        //reading files and adding new input to allInput
        String input = readTxt("betterInput.md");
        
        //info's taggable stuff
        info.rawNotes = input;
        info.tagify();
        
        //making Visit objects from input
        String[] events = input.split("\n# ");
        for(int i = 0; i < events.length; i++){
            ParseMD.info.visits.add(new Visit(events[i]));
        }
    }
    
    /**
     * reads files, .txt and .md
     * @arguments name is the name of the file you want to read. 
     * @return the contents of the file, in string format
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
     * @deprecated
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

    public static void writeObj(Object input, String name){
        try{
            FileOutputStream fs = new FileOutputStream(name);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(input);
            os.close();
        }catch(Exception ex){ex.printStackTrace();}
    }

    public static Object readObj(String name){
        Object o = null;
        try{
            FileInputStream fs = new FileInputStream(name);
            ObjectInputStream os = new ObjectInputStream(fs);
            o = os.readObject();
            os.close();
        }catch(Exception ex){ex.printStackTrace();}
        return o;
    }
    
}