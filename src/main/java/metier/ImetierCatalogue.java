package metier;

import java.util.List;

public interface ImetierCatalogue {
public List<Vetement> getVetementsParMotCle(String mc);
public void addVetement(Vetement p);
}
