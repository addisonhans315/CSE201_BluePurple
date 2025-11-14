import java.nio.file.*;
import java.util.*;

public class AppDatabase {

    private static List<App> apps; // store all apps

    public AppDatabase(String fileName) throws Exception {
        String json = Files.readString(Path.of(fileName));
        json = json.trim().substring(1, json.length() - 1).trim();
        String[] blocks = json.split("},\\s*\\{");

        apps = new ArrayList<>();

        for (String block : blocks) {
            block = block.replace("{", "").replace("}", "").trim();
            Map<String, String> map = new HashMap<>();

            for (String line : block.split(",\n")) {
                String[] pair = line.split(":", 2);
                String key = pair[0].replace("\"", "").trim();
                String value = pair[1].replace("\"", "").trim();
                map.put(key, value);
            }

            App app = new App(
                map.get("Name"),
                map.get("image path"),
                map.get("type"),
                map.get("price"),
                map.get("details"),
                map.get("developer")
            );

            apps.add(app);
        }
    }

    // Return complete list of apps
    public List<App> getApps() {
        return apps;
    }
 // Save the current apps list back to JSON file
    private static void saveToFile() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[\n");

            for (int i = 0; i < apps.size(); i++) {
                App a = apps.get(i);

                sb.append("  {\n");
                sb.append("    \"Name\": \"" + a.getName() + "\",\n");
                sb.append("    \"image path\": \"" + a.getImagePath() + "\",\n");
                sb.append("    \"type\": \"" + a.getType() + "\",\n");
                sb.append("    \"price\": \"" + a.getPrice() + "\",\n");
                sb.append("    \"details\": \"" + a.getDetails() + "\",\n");
                sb.append("    \"developer\": \"" + a.getDeveloper() + "\"\n");
                sb.append("  }");

                if (i < apps.size() - 1) sb.append(",");
                sb.append("\n");
            }

            sb.append("]");

            Files.writeString(Path.of("Apps.json"), sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add new app + write to JSON file
    public static void addApp(App app) {
        if (app != null) {
            apps.add(app);
            saveToFile();  // update the JSON file
        }
    }
}

