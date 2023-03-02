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

        for(String line : textStorage)
        {
            if(!line.isBlank())
                System.out.println(line);
            char[] temp = line.toCharArray();
            int poundTally = 0;
            boolean spaceAfterPound = false;
            char lastCha = ' ';
            boolean noteMarkerFound = false;

            for(char cha : temp)
            {
                if(lastCha == '#' && cha == ' ')
                {
                    spaceAfterPound = true;
                }
                switch (cha)
                {
                    case '#' :
                        poundTally++;
                        break;
                    case '*' :
                    case '-' :
                    case '_' :
                        noteMarkerFound = true;
                        break;
                }
                lastCha = cha;
            }

            if(poundTally >= 3)
            {
                System.out.println("Person");
            }
            else if (poundTally == 1 && spaceAfterPound)
            {
                System.out.println("Date");
            }
            else if (poundTally == 1 && !spaceAfterPound)
            {
                System.out.println("Tag");
            }
            else if (noteMarkerFound)
            {
                System.out.println("Note");
            }
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