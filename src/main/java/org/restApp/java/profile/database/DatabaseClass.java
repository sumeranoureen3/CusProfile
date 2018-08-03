package org.restApp.java.profile.database;

import java.util.HashMap;
import java.util.Map;

import org.restApp.java.profile.model.Profile;

public class DatabaseClass {

	private static Map<String, Profile> profiles = new HashMap<String, Profile>();

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

	
	
	
}
