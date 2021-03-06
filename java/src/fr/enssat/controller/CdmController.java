package fr.enssat.controller;

import java.util.List;








import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.enssat.beans.Course;
import fr.enssat.beans.OrgUnit;
import fr.enssat.beans.Program;
import fr.enssat.services.CdmService;
import fr.enssat.services.CdmServiceImpl;


@Path("/cdm")
public class CdmController {

	private CdmService service = new CdmServiceImpl();
	public CdmController() {
		super();
	}
	@GET
	@Path("/getCourses")
	@Produces(MediaType.TEXT_XML)
	public List<Course> getCourses(){
		return service.getAllCourses();
	}
	
	@GET
	@Path("/getProgram")
	@Produces(MediaType.TEXT_XML)
	public Program getProgram(){
		return service.getProgram();
	}
	@GET
	@Path("/getOrg")
	@Produces(MediaType.TEXT_XML)
	public OrgUnit getOrgUnit(){
		return service.getOrgUnit();
	}
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "hello";
		
	}
	
	@POST
	@Path("/add")
	public void addCourse(@FormParam("ident") String ident,
						   @FormParam("level") String level,
						   @FormParam("teachingTerm") String teachingTerm){
	    Course c = new Course();
	    c.setId(ident);
	    c.setIdent(ident);
	    c.setLevel(level);
	    c.setTeachingTerm(teachingTerm);
		service.addCourse(c);
	}
	
	@DELETE
	@Path("/delete/{ident}")
	public void deleteCourseById(@PathParam("ident") String ident){
		service.deleteCourseById(ident);
	
	}
	
	@PUT
	@Path("/updateL/{ident}/{newValue}")
	public void updateLevelCourseById(@PathParam("ident") String ident,@PathParam("newValue") String newValue){
		
		service.updateLevelByCourseId(ident,newValue);
	
	}
	
	@PUT
	@Path("/updateT/{ident}/{newValue}")
	public void updateTeachingTermOfCourseById(@PathParam("ident") String ident,@PathParam("newValue") String newValue){
		
		service.updateTeachingTermOfCourseById(ident,newValue);
	
	}
	
	
	
	

}
