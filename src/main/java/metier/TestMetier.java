package metier;

import java.util.List;
public class TestMetier {
public static void main(String[] args) {
MetierImpl metier= new MetierImpl();
List<Vetement> prods = metier.getVetementsParMotCle("HP");
for (Vetement p : prods)
System.out.println(p.getNomVetement());
}
}
