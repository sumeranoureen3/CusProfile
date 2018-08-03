package org.restApp.java.profile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restApp.java.profile.database.DatabaseClass;
import org.restApp.java.profile.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("sumeranoureen", new Profile(1L, "sumeranoureen", "sumera", "noureen","sumera@gmail.com","01-01-1984","Test Address1", "Test Address2"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		System.out.println(profiles.get(profileName));
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
