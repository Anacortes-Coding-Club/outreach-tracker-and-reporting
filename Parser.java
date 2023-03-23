import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Arrays;

public class Parser {

    /**
     * Parses a visit string to a Visit instance. Assigns the provided date.
     * 
     * @param visit
     * @param date
     * @return
     */
    static Visit parseVisit(String visit, LocalDate date) {
        String[] parts = visit.split("\n", 2);
        String[] name = parts[0].split(",");
        String notes = parts[1];
        String[] hashtags = Util.hashtags(notes);
        Visit visitObj = new Visit(date, name, hashtags, notes);
        // System.out.println(Arrays.toString(name));
        // System.out.println(Arrays.toString(hashtags));
        return visitObj;
    }

    /**
     * Parses a trip, representing a date followed by a number of visits, to a list
     * of visits.
     * 
     * @param trip
     * @return
     */
    static ArrayList<Visit> parseTrip(String trip) {
        // split first line as date
        // https://stackoverflow.com/questions/23756456/java-separate-string-on-first-line-break
        String[] parts = trip.split("\n", 2);
        LocalDate date = Util.parseDate(parts[0].replace("# ", ""));
        String[] visits = parts[1].split("\n### ");
        // System.out.println(date);
        ArrayList<Visit> tripVisits = new ArrayList<Visit>();
        for (String visit : visits) {
            // https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
            visit = visit.trim();
            if (visit.length() > 0) {
                Visit visitObj = parseVisit(visit, date);
                tripVisits.add(visitObj);
            }
        }
        return tripVisits;
    }

    /**
     * Parses Markdown input file to an ArrayList of Visit instances.
     * 
     * @return
     */
    static ArrayList<Visit> parseFile() {
        String markdown = Util.readFileAsString("input/sample.md");
        String[] trips = markdown.split("\n# ");
        ArrayList<Visit> allVisits = new ArrayList<Visit>();
        for (String trip : trips) {
            // parseTrip(trip);
            allVisits.addAll(parseTrip(trip));
        }
        return allVisits;

    }

    public static void main(String[] args) {
        ArrayList<Visit> visits = parseFile();
        System.out.println("Loaded visits: " + visits.size());

        // serialize
        String result = Util.objectToJson(visits);
        String filename = "visits.json";
        Util.writeStringToFile(result, filename);
        System.out.println("Wrote " + filename);

        // deserialize
        String json = Util.readFileAsString(filename);
        ArrayList<Visit> visitsDeserialized = Util.jsonToVisits(json);
        System.out.println("And read back visits: " + visitsDeserialized.size());

    }
}
