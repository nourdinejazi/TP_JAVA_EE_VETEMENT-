package test;

import java.util.List;

import dao.VetementDaoImpl;
import metier.entities.Vetement;

public class TestDao {
	public static void main(String[] args) {
		VetementDaoImpl pdao = new VetementDaoImpl();
		Vetement prod = pdao.save(new Vetement("iphone 8 plus", 2800));
		System.out.println(prod);
		List<Vetement> prods = pdao.VetementsParMC("iphone");
		for (Vetement p : prods)
			System.out.println(p);
	}
}
