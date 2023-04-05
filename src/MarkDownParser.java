import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MarkDownParser {
    private static ArrayList<Date> dateStorage = new ArrayList<>();
    private static ArrayList<String> textStorage = new ArrayList<>();
    private static Date toolDate = new Date();

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
            String line = lineOrig + " ";
            boolean claimed = false;
            if(line.startsWith("#"))
            {
                if(line.contains("###"))
                {
                    String firstName = "";
                    String lastName = "";
                    line = line.replace("#", "");
                    line = line.trim();
                    line = " " + line + " ";
                    String temp = line.substring(1,line.indexOf(" ",1));
                    firstName = temp;
                    line = line.replace(temp, "");
                    if(!line.isBlank())
                    {
                        line = line.trim();
                        line = " " + line;
                        temp = line.substring(1);
                        lastName = temp;
                    }
                    //System.out.println("Person: " + firstName + " " + lastName);
                    claimed = true;

                    Person pCur = new Person();
                    pCur.setFirstName(firstName);
                    pCur.setLastName(lastName);

                    Visit vCur = new Visit();
                    vCur.addPerson(pCur);

                    dateStorage.get(dateStorage.size() - 1).addVisit(vCur);
                }
                else if(line.contains("# "))
                {
                    //System.out.println("Date " + line);
                    int month;
                    int day;
                    int year;
                    //remove #
                    line = line.replace("#", "");
                    //remove ,
                    line = line.replace(",", "");
                    //replace / with spaces
                    line = line.replace("/"," ");
                    //trim
                    line = line.trim();
                    //add spaces
                    line = " " + line + " ";
                    //snatch first bit
                    String temp = line.substring(1, line.indexOf(" ", 1));
                    //if number, feed to numToMonth
                    if(temp.contains("0") || temp.contains("1") || temp.contains("2") || temp.contains("3") || temp.contains("4") ||
                            temp.contains("5") || temp.contains("6") || temp.contains("7") || temp.contains("8") || temp.contains("9"))
                    {
                        int i = Integer.parseInt(temp);
                        line = line.replaceFirst(temp, toolDate.numToMonth(i));
                        temp = toolDate.numToMonth(i);
                    }
                    //feed to month to num and save
                    month = toolDate.monthToNum(temp);
                    //snatch second bit
                    line = line.replaceFirst(temp, "");
                    line = line.trim();
                    line = " " + line + " ";
                    temp = line.substring(1, line.indexOf(" ", 1));
                    day = Integer.parseInt(temp);
                    //snatch third bit
                    line = line.replaceFirst(temp, "");
                    line = line.trim();
                    line = " " + line + " ";
                    temp = line.substring(1, line.indexOf(" ", 1));
                    year = Integer.parseInt(temp);
                    //System.out.println(month + " " + day + " " + year);
                    claimed = true;

                    Date dCur = new Date();
                    dCur.setDate(month, day, year);
                    dateStorage.add(dCur);
                }
            }

            if(!claimed)
            {
                while (line.contains("#"))
                {
                    String temp = line.substring(line.indexOf("#"),line.indexOf(" ", line.indexOf("#")));
                    line = line.replace(temp, "");
                    temp = temp.replace("#","");
                    temp = temp.trim();
                    //System.out.println("Tag: " + temp);

                    Tag tCur = new Tag();
                    tCur.setTag(temp);

                    ArrayList<Visit> vTemp = dateStorage.get(dateStorage.size() - 1).getVisits();
                    ArrayList<Person> pTemp = vTemp.get(vTemp.size() - 1).getPersons();
                    pTemp.get(pTemp.size() - 1).addTag(tCur);
                    vTemp.get(vTemp.size() - 1).setPerson(pTemp);
                    dateStorage.get(dateStorage.size() - 1).setVisits(vTemp);

                }
                line = line.replace("-","*");
                line = line.replace("_","*");
                if(line.contains("*"))
                {
                    char[] lineChar = line.toCharArray();
                    boolean empty = true;
                    line = line.replace("*"," ");
                    line = line.trim();
                    for (char cCur : lineChar)
                    {
                        if(Character.isAlphabetic(cCur))
                        {
                            empty = false;
                        }
                    }
                    if(!empty)
                    {
                        //System.out.println("Note: " + line);
                        Note nCur = new Note();
                        nCur.setNote(line);

                        ArrayList<Visit> vTemp = dateStorage.get(dateStorage.size() - 1).getVisits();
                        ArrayList<Person> pTemp = vTemp.get(vTemp.size() - 1).getPersons();
                        pTemp.get(pTemp.size() - 1).addNote(nCur);
                        vTemp.get(vTemp.size() - 1).setPerson(pTemp);
                        dateStorage.get(dateStorage.size() - 1).setVisits(vTemp);
                    }
                }
            }
        }
            /*
            Future Problems:
              - Cannot account for more than one person in a visit. This will need to be fixed, if only to give visits an actual purpose.
            Ideas:
              - Search functions
              - Global statistics
              - Sort by people rather than by date.
             */

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