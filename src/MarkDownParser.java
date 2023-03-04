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
            while(line.contains("#"))
            {
                if (line.contains("# "))
                {
                    Date dCur = new Date();
                    dCur.setDate("March", 3, 2023);
                    Visit vCur = new Visit();
                    dCur.addVisit(vCur);
                    dateStorage.add(dCur);


                }
                if (line.contains("###"))
                {
                    Person pCur = new Person();
                    pCur.setFirstName("Bob");
                    pCur.setLastName("Bobson");
                    dateStorage.get(dateStorage.size() - 1).getVisits().get(0).addPerson(pCur);


                }
                if (line.contains("#") && !line.contains("# "))
                {
                    Tag tCur = new Tag();
                    tCur.setTag(line.substring(line.indexOf("#")));
                    dateStorage.get(dateStorage.size() - 1).getVisits().get(0).getPersons().get(0).addTag(tCur);

                    lineChar.
                }
                line = new String(lineChar);
            }
            if(line.contains("*") || line.contains("-") || line.contains("_"))
            {
                if(line.contains("*"))
                {
                    System.out.println("Note: " + line.substring(line.indexOf("*")));
                    Note nCur = new Note();
                    nCur.setNote(line.substring(line.indexOf("*")));
                    dateStorage.get(dateStorage.size() - 1).getVisits().get(0).getPersons().get(0).addNote(nCur);
                }
                else if(line.contains("-"))
                {
                    System.out.println("Note: " + line.substring(line.indexOf("-")));
                    Note nCur = new Note();
                    nCur.setNote(line.substring(line.indexOf("-")));
                    dateStorage.get(dateStorage.size() - 1).getVisits().get(0).getPersons().get(0).addNote(nCur);
                }
                else if(line.contains("_"))
                {
                    System.out.println("Note: " + line.substring(line.indexOf("_")));
                    Note nCur = new Note();
                    nCur.setNote(line.substring(line.indexOf("_")));
                    dateStorage.get(dateStorage.size() - 1).getVisits().get(0).getPersons().get(0).addNote(nCur);
                }
            }

            /*
            Three pounds in a row                                           = Person
            A pound and then the rest of the letters until a space or comma = Tag
            A pound followed by a space                                     = Date
            * - _ rest of the line until end or pound                       = Note
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