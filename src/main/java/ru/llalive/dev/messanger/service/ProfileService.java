package ru.llalive.dev.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.llalive.dev.messanger.database.DatabaseClass;
import ru.llalive.dev.messanger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("LLAlive", new Profile(1L, "LLAlive", "P.", "Babikov"));
	}
	
	public List<Profile> getProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfileByName(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public void removeProfile(String profileName){
		System.out.println(profiles.keySet());
		System.out.println(profiles.values());
		profiles.remove(profileName);
	}

}
