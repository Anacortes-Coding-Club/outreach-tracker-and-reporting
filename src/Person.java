import java.util.ArrayList;
public class Person
{
    private String firstName = "";
    private String lastName = "";
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<Tag> tags = new ArrayList<>();

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String input)
    {
        firstName = input;
    }
    public void printFirstName()
    {
        System.out.print(firstName);
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String input)
    {
        lastName = input;
    }
    public void printLastName()
    {
        System.out.print(lastName);
    }
    public ArrayList<Note> getNotes()
    {
        return notes;
    }
    public void setNotes(ArrayList<Note> input){
        notes = input;
    }
    public void addNote(Note input)
    {
        notes.add(input);
    }
    public void printNotes()
    {
        for (Note note : notes) {
            note.printNote();
        }
    }
    public ArrayList<Tag> getTags()
    {
        return tags;
    }
    public void setTags(ArrayList<Tag> input){
        tags = input;
    }
    public void addTag(Tag input)
    {
        tags.add(input);
    }
    public void printTags()
    {
        for (Tag tag : tags) {
            tag.printTag();
        }
    }
}