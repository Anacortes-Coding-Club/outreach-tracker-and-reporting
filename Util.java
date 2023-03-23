import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

// https://stackoverflow.com/questions/39192945/serialize-java-8-localdate-as-yyyy-mm-dd-with-gson
class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
    }

    // https://stackoverflow.com/questions/51183967/deserialize-date-attribute-of-json-into-localdate
    @Override
    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
    }
}

/**
 * A collection of utilities for parsing outreach markdown.
 */
public class Util {

    /**
     * Parses a string to a LocalDate. Handles format "January 3, 2023" as well as
     * format "01/03/2023"
     * 
     * @param dateString
     * @return
     */
    static LocalDate parseDate(String dateString) {
        // https://stackoverflow.com/questions/23488721/how-to-check-if-string-matches-date-pattern-using-time-api
        DateTimeFormatter foo = DateTimeFormatter.ofPattern("[MMMM d, yyyy][MM/dd/yyyy]");
        return LocalDate.parse(dateString, foo);
    }

    /**
     * Opens the provided filename as a file and returns the contents as a String.
     * 
     * @param filename
     * @return
     */
    static String readFileAsString(String filename) {
        Path path = Paths.get(filename);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Writes the String content to a file named filename.
     * 
     * @param content
     * @param filename
     */
    static void writeStringToFile(String content, String filename) {
        try {
            Files.write(Paths.get(filename), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts a list of hashtags found in the input String.
     * 
     * @param input text to scan for hashtags
     * @return a list of hashtags found in the scanned input
     */
    static String[] hashtags(String input) {
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher match = pattern.matcher(input);
        List<String> results = new ArrayList<String>();
        while (match.find()) {
            results.add(match.group());
        }
        return results.toArray(new String[0]);

    }

    /**
     * Serializes an object (for example, an ArrayList of Visit instances) to JSON.
     * 
     * @param obj Object to serialize
     * @return the serialized JSON
     */
    static String objectToJson(Object obj) {
        Gson gson = new GsonBuilder()
                // .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        String result = gson.toJson(obj);
        return result;
    }

    /**
     * Deserializes JSON visits to an ArrayList of Visit instances
     * 
     * @param json JSON to deserialize
     * @return a list of deserialized Visits
     */
    static ArrayList<Visit> jsonToVisits(String json) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        // Using Gson instructions:
        // https://github.com/google/gson/blob/master/UserGuide.md#collections-examples
        ArrayList<Visit> visits = gson.fromJson(
                json, new TypeToken<ArrayList<Visit>>() {
                });
        return visits;
    }

    public static void main(String[] args) {
        String testDate = "January 14, 2023";
        LocalDate foo = parseDate(testDate);
        System.out.println(foo);

        String hash = "I got some #cookies for my #bunny \n\n#tasty";
        for (String match : hashtags(hash)) {
            System.out.println(match);
        }

    }

}
