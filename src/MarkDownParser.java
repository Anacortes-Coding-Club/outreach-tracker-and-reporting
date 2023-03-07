import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MarkDownParser {
    private static ArrayList<Date> dateStorage = new ArrayList<>();
    private static ArrayList<String> textStorage = new ArrayList<>();

    public static void main(String[] args)
    {
        parse();
        print();
    }
    private static void parse ()
    {
        try
        {
            File myObj = new File("input/sample.md");
            Scanner scnr = new Scanner(myObj);
            while (scnr.hasNextLine())
            {
                String temp = scnr.nextLine();
                textStorage.add(temp);
            }
            scnr.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Mm bad");
            e.printStackTrace();
        }




        for(String lineOrig : textStorage)
        {
            String line = lineOrig;
            if(!line.isBlank())
                System.out.println(line);
            char[] lineChar = line.toCharArray();
            int i = 0;
            boolean claimed = false;
            if(line.startsWith("#"))
            {
                if(line.contains("###"))
                {
                    System.out.println("Person");
                    claimed = true;
                }
                else if(line.contains("# "))
                {
                    System.out.println("Date");
                    claimed = true;
                }
            }
            //If we've made it this far, its not a date or a person
            //check for notes and tags
            //multiple tags can be in one line
            //a note and multiple tags can be in one line.

            //Tag ripper
            if(!claimed)
            {
                while (line.contains("#")) {
                    String temp = line.substring(line.indexOf("#"),line.indexOf(" ", line.indexOf("#")));
                    System.out.println(temp);
                    line.replace(temp," ");
                }
            }

            //Note taker

            //line = new String(lineChar);

            /*
            Three pounds in a row                                           = Person
            A pound and then the rest of the letters until a space or comma = Tag
            A pound followed by a space                                     = Date
            * - _ rest of the line until end or pound                       = Note

            Special case for notes and or multiple tags
             */

            /*
            Current Problems:
             - Needs to be able to account for multiple things in one line. i.e note and tag, or multiple tags
               Possible solution: Break things up into substrings based off of markers like # , * - _ etc.
             - Three tags in one line registers as a person.
               Possible solution: check that all three pounds are right next to each other.
             - Two tags, but with a note marker registers as a note
               Possible solution: switch up the tag and note detection to be less specific.
            Future Problems:
              - Current working data is messy. Convert non number and non alphabet characters to spaces, then trim.
              - Some people do not have last names, need to be able to detect this
              - Cannot account for more than one person in a visit. This will need to be fixed, if only to give visits an actual purpose.
            Ideas:
              - Search functions
              - Global statistics
              - Sort by people rather than by date.
             */

        }

    }
    private static void print()
    {
        for(Date date : dateStorage)
        {
            date.printDate();
            date.printVisits();
            line();
        }
    }
    private static void line()
    {
        System.out.println();
    }

}