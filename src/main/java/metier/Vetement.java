package metier;

import java.io.Serializable;
public class Vetement implements Serializable{
private Long idVetement;
private String nomVetement;
private String couleurVetement;
private double prix;
public Vetement() {
super();
}
public Vetement(String nomVetement, double prix) {
super();
this.nomVetement = nomVetement;
this.prix = prix;
}
public Long getIdVetement() {
return idVetement;
}
public void setIdVetement(Long idVetement) {
this.idVetement = idVetement;
}
public String getNomVetement() {
return nomVetement;
}

public String getCouleurVetement() {
return couleurVetement;
}
public void setNomVetement(String nomVetement) {
this.nomVetement = nomVetement;
}
public void setcouleurVetement(String couleurVetement) {
this.couleurVetement = couleurVetement;
}
public double getPrix() {
return prix;
}

public void setPrix(double prix) {
this.prix = prix;
}
}
