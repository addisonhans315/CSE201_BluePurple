
import java.util.ArrayList;
import java.util.List;

public class Search {
    private List<App> apps;

    public Search(List<App> apps) {
        this.apps = apps;
    }

    // Search by name 
    public List<App> searchByName(String name) {
        List<App> result = new ArrayList<>();
        for (App app : apps) {
            if (app.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(app);
            }
        }
        return result;
    }

    // Search by type
    public List<App> searchByType(String type) {
        List<App> result = new ArrayList<>();
        for (App app : apps) {
            if (app.getType().toLowerCase().contains(type.toLowerCase())) {
                result.add(app);
            }
        }
        return result;
    }
}