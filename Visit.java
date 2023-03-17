import java.time.LocalDate;

public class Visit {
    private LocalDate tripDate;
    private String[] people;
    private String[] hashtags;
    private String notes;

    public Visit(LocalDate tripDate, String[] people, String[] hashtags, String notes) {
        this.tripDate = tripDate;
        this.people = people;
        this.hashtags = hashtags;
        this.notes = notes;
    }

}
