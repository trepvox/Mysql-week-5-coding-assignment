package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.IceCream;

public class IceCreamDao {

	private static final String CREATE_NEW_ICECREAM_QUERY = "INSERT INTO iceCream(flavor) VALUES(?)";
	private static final String DELETE_ICECREAM_BY_ID_QUERY = "DELETE FROM iceCream WHERE id = ?";
	private static final String UPDATE_ICECREAM_BY_ID_QUERY = "UPDATE iceCream SET (flavor = ?) WHERE id = ?";
	private Connection connection;
//	private FlavorsDao flavorsDao;
	private final String GET_ICECREAM_QUERY = "SELECT * FROM iceCream";
	private final String GET_ICECREAM_BY_ID_QUERY = "SELECT * FROM iceCream WHERE id = ?";
//	private final String CREATE_NEW_FLAVORS_QUERY = "INSERT INTO flavors(name) VALUES(?)";
//	private final String DELETE_FLAVORS_BY_ID_QUERY = "DELETE FROM flavors WHERE id = ?";
	
	public IceCreamDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<IceCream> getIceCreams() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_ICECREAM_QUERY).executeQuery();
		List<IceCream> IceCream = new ArrayList<IceCream>();
		
		while (rs.next()) {
			IceCream.add(populateIceCream(rs.getInt(1), rs.getString(2)));
		}
		
		return IceCream;
	} 
	
	public IceCream getIceCreamById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_ICECREAM_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateIceCream(rs.getInt(1), rs.getString(2));
		
	}
	
	public void createNewIceCream(String flavor) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_ICECREAM_QUERY);
		ps.setString(1,  flavor);
		ps.executeUpdate();
	}
	
	public void deleteIceCreamById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ICECREAM_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateIceCreamById(int id) throws SQLException  {
		PreparedStatement ps = connection.prepareStatement(UPDATE_ICECREAM_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate(UPDATE_ICECREAM_BY_ID_QUERY);
	}
	
	private  IceCream populateIceCream(int id, String name) throws SQLException {
		return new IceCream(id, name);
	}

	public List<IceCream> getFlavors() {
		// TODO Auto-generated method stub
		return null;
	}
} 

