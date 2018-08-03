package org.restApp.java.profile.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

//import org.springframework.web.bind.annotation.RestController;
import org.restApp.java.profile.model.Profile;
import org.restApp.java.profile.service.ProfileService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/profiles/")
@Api(value = "ProfileResourceAPI", produces = MediaType.APPLICATION_JSON_VALUE)

public class ProfileResource {

	private ProfileService profileService = new ProfileService();
	
	
	
	@GET
	
	@ApiOperation("Get all the profiles")
    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Profile.class)})
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@POST

	@ApiOperation("Add new profile")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Profile.class)})
	public Profile addProfile(@RequestBody Profile profile) {
		return profileService.addProfile(profile);
	}
	
	
	

	
	@GET
	@GetMapping(value="{profileName}")
	@ApiOperation("Gets the specific profilc with profilename")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Profile.class)})
	public Profile getProfile(@PathVariable("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}
	
	
    @RequestMapping(path = "{profileName}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Update Profile with profile name")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Profile.class)})
	public Profile updateProfile(@PathVariable("profileName") String profileName,@RequestBody Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	
    @RequestMapping(path = "{profileName}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Delete specific profile with profile name")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Profile.class)})
	public void deleteProfile(@PathVariable("profileName") String profileName) {
		profileService.removeProfile(profileName);
	}
	
	
	
}
