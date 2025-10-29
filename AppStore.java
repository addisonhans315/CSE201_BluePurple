package appStore;

import java.util.*;
import java.io.*;
import java.sql.*;

public class AppStore {
	// attributes
	private ArrayList<App> apps;
	private User[] users;
	private String[] filters;
	
	public AppStore(ArrayList<App> apps, User[] users, String[] filters) {
		this.apps = apps;
		this.users = users;
		this.filters = filters;
	}
	
	// getters + setters
	public ArrayList<App> getApps() {
		return apps;
	}
	public void setApps(ArrayList<App> apps) {
		this.apps = apps;
	}
	public User[] getUsers() {
		return users;
	}
	public void setUsers(User[] users) {
		this.users = users;
	}
	public String[] getFilters() {
		return filters;
	}
	public void setFilters(String[] filters) {
		this.filters = filters;
	}
	
	public void loadApps() throws Exception {
		String line;
        String appsFile = "Apps.txt";
        String delimiter = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(appsFile))) {
            while ((line = br.readLine()) != null) {
            	ArrayList<String> d = new ArrayList<String>();
                String[] data = line.split(delimiter);
                for (String item : data) {
                    d.add(item);
                }
                Double p = Double.parseDouble(d.get(3));
                App a = new App(p, d.get(5), d.get(0), d.get(2), d.get(1), new ArrayList<Review>());
                apps.add(a);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
	}

}
