package fr.insa.rest.ProjetPartieREST.ressource;

import java.util.ArrayList;
import java.util.List;

import fr.insa.rest.ProjetPartieREST.Mission;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("mission")
public class MissionResource {
private List<Mission> missions = new ArrayList<>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Mission> getAllMission() {
		return missions;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Mission getMission(@PathParam("id") int id) {
		for (Mission mission : missions) {
            if (mission.getIdmission() == id) {
                return mission; // Mission trouvée
            }
        }
        return null; // Mission non trouvée
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addMission(Mission m) {
		missions.add(m);
	}
	
	@DELETE
	@Path("{id}")
	public void supMission(@PathParam("id") int id) {
		for (Mission mission : missions) {
            if (mission.getIdmission() == id) {
            	if (missions.remove(mission)) {
            		System.out.println("Mission supprimée!!");
            	}else {
            		System.out.println("Supprime avec erreur");
            	}
            }else {
            	System.out.println("Mission non trouvée");
            }
        }
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void valideMiss(Mission m) {
		m.StateValide();
		System.out.println("Mission validée!!");
	}
}
