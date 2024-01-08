package fr.insa.rest.ProjetPartieREST.ressource;

import java.util.ArrayList;
import java.util.List;

import fr.insa.rest.ProjetPartieREST.Personne;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("personne")
public class PersonneResource {
	private List<Personne> personnes = new ArrayList<>();
	
	@GET
	/*@Produces(MediaType.APPLICATION_JSON)
	public List<Personne> getAllPersonne() {
		return personnes;
	}*/
	public void test(){
		System.out.println("Personne supprimé!!");
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Personne getPersonne(@PathParam("id") int id) {
		for (Personne personne : personnes) {
            if (personne.getId() == id) {
                return personne; // Personne trouvée
            }
        }
        return null; // Personne non trouvée
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPersonne(Personne p) {
		personnes.add(p);
	}
	
	@DELETE
	@Path("{id}")
	public void supPersonne(@PathParam("id") int id) {
		for (Personne personne : personnes) {
            if (personne.getId() == id) {
            	if (personnes.remove(personne)) {
            		System.out.println("Personne supprimé!!");
            	}else {
            		System.out.println("Supprime avec erreur");
            	}
            }else {
            	System.out.println("Personne non trouvée");
            }
        }
	}
}
