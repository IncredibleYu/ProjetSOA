package fr.insa.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "GestionMission")
public class GestionMiss {
	
	@WebMethod(operationName="addMiss")
	public Mission addMission(int id, Demandeur demandeur) {
		Mission m = new Mission(id, demandeur);
		m.StateInitiale();
		System.out.println("Ajout mission r¨¦ussie!!");
		return m;
	}
	
	@WebMethod(operationName="valideMiss")
	public void ValideMission(Mission m) {
		m.StateValide();
		System.out.println("Mission Valid¨¦e!!");
	}
	
	@WebMethod(operationName="refuseMiss")
	public void RefuseMission(Mission m) {
		m.StateRefuse();
		System.out.println("Mission Refus¨¦e!!");
	}

}
