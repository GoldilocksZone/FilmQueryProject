package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private final String user = "student", pass = "student";
	
	public DatabaseAccessorObject() {
		try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	  }

	@Override
	public Film findFilmById(int filmId) {
		String sql = "SELECT * FROM film WHERE id = ?";
		
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			stmt.setInt(1, filmId);
			if(rs.next()) {
				return new Film(rs.getInt("id"),
								rs.getString("title"),
								rs.getString("description"),
								rs.getDate("release_year").toLocalDate(),
								rs.getShort("language_id"),
								rs.getByte("rental_duration"),
								rs.getBigDecimal("rental_rate"),
								rs.getShort("length"),
								rs.getBigDecimal("replacementCost"),
								rs.getString("rating"),
								rs.getString("special_features").split(","));						
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

	public Actor findActorById(int actorId) {
		String sql = "SELECT * FROM actor WHERE id = ?";
		
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			stmt.setInt(1, actorId);
			if(rs.next()) {
				return new Actor(rs.getInt("id"),
								rs.getString("first_name"),
								rs.getString("last_name"));						
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

	public List<Actor> findActorsByFilmId(int filmId) {
		String sql = "SELECT actor.id, first_name, last_name " +
						"FROM film JOIN film_actor ON film.id = film_actor.film_id " +
									"JOIN actor ON actor.id = film_actor.actor_id " +
									"WHERE film.id = ?";
		List<Actor> actors = new ArrayList<Actor>();
		
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			stmt.setInt(1, filmId);
			while (rs.next()) {
				actors.add(new Actor(rs.getInt("actor.id"),
										rs.getString("first_name"),
										rs.getString("last_name")));
			}
			return actors;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

}
