package metier;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierCatalogue {

public List<Vetement> getVetementsParMotCle(String mc) {
List<Vetement> prods= new ArrayList<Vetement>();
Connection conn=SingletonConnection.getConnection();
try {
PreparedStatement ps= conn.prepareStatement("select * from vetements where nom LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
Vetement p = new Vetement();
p.setIdVetement(rs.getLong("ID"));
p.setNomVetement(rs.getString("NOM"));
p.setcouleurVetement(rs.getString("couleur"));
p.setPrix(rs.getDouble("PRIX"));
prods.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
}
return prods;
}
public void addVetement(Vetement p) {
// TODO Auto-generated method stub
}
}

