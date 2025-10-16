package appStore;

import java.util.*;
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

}
