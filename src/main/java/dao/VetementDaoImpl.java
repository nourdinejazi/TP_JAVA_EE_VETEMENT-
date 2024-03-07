package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.SingletonConnection;
import metier.entities.Vetement;

public class VetementDaoImpl implements IVetementDao {
	@Override
	public Vetement save(Vetement p) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO VetementS(NOM_Vetement,PRIX) VALUES(?,?)");
			ps.setString(1, p.getNomVetement());
			ps.setDouble(2, p.getPrix());
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_Vetement) as MAX_ID FROM VetementS");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setIdVetement(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Vetement> VetementsParMC(String mc) {
		List<Vetement> prods = new ArrayList<Vetement>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from VetementS where NOM_Vetement LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vetement p = new Vetement();
				p.setIdVetement(rs.getLong("ID_Vetement"));
				p.setNomVetement(rs.getString("NOM_Vetement"));
				p.setPrix(rs.getDouble("PRIX"));
				prods.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public Vetement getVetement(Long id) {

	 Connection conn=SingletonConnection.getConnection();
	 Vetement p = new Vetement();
	 try {
	PreparedStatement ps= conn.prepareStatement("select * from VetementS where ID_Vetement = ?");
	ps.setLong(1, id);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	p.setIdVetement(rs.getLong("ID_Vetement"));
	p.setNomVetement(rs.getString("NOM_Vetement"));
	p.setPrix(rs.getDouble("PRIX"));
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
	}

	@Override
	public Vetement updateVetement(Vetement p) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("UPDATE VetementS SET NOM_Vetement=?,PRIX=? WHERE ID_Vetement=?");
	ps.setString(1, p.getNomVetement());
	ps.setDouble(2, p.getPrix());
	ps.setLong(3, p.getIdVetement());
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
	}

	@Override
	public void deleteVetement(Long id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM VetementS WHERE ID_Vetement = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}