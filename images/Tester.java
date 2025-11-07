import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Tester {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            File jsonFile = findJsonFile("app.json");

            if (jsonFile == null) {
                System.out.println("app.json not found in project");
                return;
            }

            //System.out.println("Loading file from: " + jsonFile.getAbsolutePath());
            FileReader reader = new FileReader(jsonFile);

            List<App> apps = gson.fromJson(reader, new TypeToken<List<App>>() {}.getType());
            reader.close();

            // Create Search object
            Search search = new Search(apps);

            // Search examples
            System.out.println("\nSearch by Name 'Camera':");
            for (App app : search.searchByName("Camera")) {
                System.out.println(app.getName() + " - " + app.getType());
            }

            System.out.println("\nSearch by Type 'Photo & Video':");
            for (App app : search.searchByType("Photo & Video")) {
                System.out.println(app.getName() + " - " + app.displayPrice());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔍 Helper method to find the JSON file automatically
    private static File findJsonFile(String filename) {
        // Option 1: in project root
        File rootFile = new File(filename);
        if (rootFile.exists()) {
            return rootFile;
        }

        // Option 2: in src/appStore/
        File srcFile = new File("src/appStore/" + filename);
        if (srcFile.exists()) {
            return srcFile;
        }

        // Not found anywhere
        return null;
    }
}
