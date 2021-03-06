package com.eviac.blog.restws;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Details;

import com.google.gson.Gson;


//@Path here defines class level path. Identifies the URI path that 
//a resource class will serve requests for.
@Path("UserInfoService")
public class UserInfo {
	// @GET here defines, this method will method will process HTTP GET
	// requests.
	@GET
	// @Path here defines method level path. Identifies the URI path that a
	// resource class method will serve requests for.
	@Path("/name/{i}")
	// @Produces here defines the media type(s) that the methods
	// of a resource class can produce.
	@Produces(MediaType.TEXT_XML)
	// @PathParam injects the value of URI parameter that defined in @Path
	// expression, into the method.
	public String userName(@PathParam("i") String i) {




		String name = i;
		return "<User>" + "<Name>" + name + "</Name>" + "</User>";
	}
	
	@GET
//	@Path("/nme/{i}")
	@Path("/nme/{i}/{j}/{k}")
	@Produces(MediaType.APPLICATION_JSON)
//	public String getName(@PathParam("i")String i){
	public String getName(@PathParam("i")String i,@PathParam("j")String j,@PathParam("k")String k){
		Gson gson = new Gson();
		Details d= new Details();
		d.setName(i);
		d.setAge(Integer.parseInt(j));
		d.setContactNo(k);
		return gson.toJson(d);		
	}




	@GET 
	@Path("/age/{j}") 
	@Produces(MediaType.TEXT_XML)
	public String userAge(@PathParam("j") int j) {




		int age = j;
		return "<User>" + "<Age>" + age + "</Age>" + "</User>";
	}
	
	
	@POST
	@Path("/namePost")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getNamePost(@FormParam("name")String name){
		
		return name;
		
	}

}
