package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Vetement;

public class VetementModele {
	private String motCle;
	List<Vetement> Vetements = new ArrayList<>();

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Vetement> getVetements() {
		return Vetements;
	}

	public void setVetements(List<Vetement> Vetements) {
		this.Vetements = Vetements;
	}
}