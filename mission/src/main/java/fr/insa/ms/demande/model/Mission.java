package fr.insa.ms.demande.model;

public class Mission {
	private String [] States = {"En Attente", "Validée", "Refusée", "Terminée"};
	private int idmission;
	private int iddemandeur;
	private String state;
	private int score;
	private String comment;
	public Mission(int id, int iddemandeur) {
		this.idmission = id;
		this.iddemandeur = iddemandeur;
		StateInitiale();
	}
	
	public int getIdmission() {
		return idmission;
	}
	public void setIdmission(int idmission) {
		this.idmission = idmission;
	}
	public int getDemandeur() {
		return iddemandeur;
	}
	public void setDemandeur(int iddemandeur) {
		this.iddemandeur = iddemandeur;
	}
	public String getState() {
		return state;
	}
	public void StateInitiale() {
		this.state = States[0];
	}
	public void StateValide() {
		this.state = States[1];
	}
	public void StateRefuse() {
		this.state = States[2];
	}
	public void StateTermine() {
		this.state = States[3];
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
