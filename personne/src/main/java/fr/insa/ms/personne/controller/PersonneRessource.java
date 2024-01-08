package fr.insa.ms.personne.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.ms.personne.model.Mission;
import fr.insa.ms.personne.model.Person;
import fr.insa.ms.personne.service.PersonneService;

@RestController
@RequestMapping("/personne")
public class PersonneRessource {
	private final PersonneService personneService;

    @Autowired
    private RestTemplate restTemplate;
    public PersonneRessource(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/all")
    public List<Map<String, Object>> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getPersonneById(@PathVariable("id") int id) {
        return personneService.getPersonneById(id);
    }

    @PostMapping("/add")
    public void addPersonne(@RequestParam String nom, @RequestParam String prenom,
                            @RequestParam int age, @RequestParam String sexe) {
        personneService.savePersonne(nom, prenom, age, sexe);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonne(@PathVariable("id") int id) {
        personneService.deletePersonne(id);
    }
    
    @GetMapping("/allmission")
    public List<Person> getallmission(){
    	List<Person> listPersons = new ArrayList<Person>();
    	List<Map<String, Object>> personnes = getAllPersonnes();

        for (Map<String, Object> personne : personnes) {
            int id = (int) personne.get("id");
            String nom = (String) personne.get("nom");
            String prenom = (String) personne.get("prenom");

            Mission mission = restTemplate.getForObject("http://localhost:3457/mission/person/"+id, Mission.class);

            // Create a new Person instance with the retrieved data
            Person person = new Person(id, nom, prenom, mission.getIdmission());
            listPersons.add(person);
        }
    	return listPersons;
    }
}
