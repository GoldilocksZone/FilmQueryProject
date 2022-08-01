package com.skilldistillery.filmquery.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Film {
	private byte rentalDuration;
	private short languageId, length;
	private int id;
	private BigDecimal rentalRate, replacementCost;
	private String title, description, language, category, rating, specialFeatures;
	private LocalDate releaseYear;
	private List<Actor> cast;
	Map<String, Set<Integer>> inventory;

	public Film() {

	}

	/**
	 * @param rentalDuration
	 * @param languageId
	 * @param length
	 * @param id
	 * @param rentalRate
	 * @param replacementCost
	 * @param title
	 * @param description
	 * @param specialFeatures
	 * @param releaseYear
	 * @param rating
	 */
	public Film(int id, String title, String description, LocalDate releaseYear, short languageId, String language,
			String category, byte rentalDuration, BigDecimal rentalRate, short length, BigDecimal replacementCost,
			String rating, String specialFeatures, List<Actor> cast, Map<String, Set<Integer>> inventory) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.language = language;
		this.category = category;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.cast = cast;
		this.inventory = inventory;
	}

	/**
	 * @return the rentalDuration
	 */
	public byte getRentalDuration() {
		return rentalDuration;
	}

	/**
	 * @param rentalDuration the rentalDuration to set
	 */
	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	/**
	 * @return the languageId
	 */
	public short getLanguageId() {
		return languageId;
	}

	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(short languageId) {
		this.languageId = languageId;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return new String(language);
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return new String(this.category);
	}
	
	/*
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return the length
	 */
	public short getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(short length) {
		this.length = length;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the rentalRate
	 */
	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	/**
	 * @param rentalRate the rentalRate to set
	 */
	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	/**
	 * @return the replacementCost
	 */
	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	/**
	 * @param replacementCost the replacementCost to set
	 */
	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return new String(title);
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return new String(description);
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the specialFeatures
	 */
	public String getSpecialFeatures() {
		return new String(specialFeatures);
	}

	/**
	 * @param specialFeatures the specialFeatures to set
	 */
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	/**
	 * @return the releaseYear
	 */
	public LocalDate getReleaseYear() {
		return releaseYear;
	}

	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(LocalDate releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return new String(rating);
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the cast
	 */
	public List<Actor> getCast() {
		return cast;
	}

	/**
	 * @param cast the cast to set
	 */
	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}
	
	/**
	 * @return the inventory
	 */
	public Map<String, Set<Integer>> getInventory() {
		return this.inventory;
	}
	
	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Map<String, Set<Integer>> inventory) {
		this.inventory = inventory;
	}

	// regular display:	title, year, rating, description, language, cast
	// details:			all film categories, all copies of film in inventory with their condition
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("|| " + this.getTitle() + " (" + this.getReleaseYear().getYear() + ") ||").append("\n\n")
				.append(this.getDescription()).append("\n\n")
				.append("Rating: " + this.getRating() + "\t" + "Language: " + this.getLanguage()).append("\n")
				.append("Cast: ");

		ListIterator<Actor> listIt = this.cast.listIterator();
		while (listIt.hasNext()) {
			Actor actor = listIt.next();
			sb.append(actor.getFirstName() + " " + actor.getLastName());
			if (listIt.hasNext()) {
				sb.append(", ");
			} else {
				sb.append("\n");
			}
		}
		
		sb.append("\n").append("--------------------").append("\n");
		return sb.toString();
	}
	
	public String toStringDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append("|| " + this.getTitle() + " (" + this.getReleaseYear().getYear() + ") ||").append("\n\n")
		.append(this.getDescription()).append("\n\n")
		.append("Rating: " + this.getRating() + "\t" + "Language: " + this.getLanguage()).append("\n")
		.append("Run Time: " + this.getLength() + " min" + "\t" + "Category: " + this.getCategory()).append("\n")
		.append("\n").append("Special Features: " + this.getSpecialFeatures()).append("\n\n")
		.append("Rental Rate: $" + this.getRentalRate() + "\t" + "Replacement Cost: $"
				+ this.getReplacementCost()).append("\n")
		.append("Cast: ");
		
		ListIterator<Actor> listIt = this.cast.listIterator();
		while (listIt.hasNext()) {
			Actor actor = listIt.next();
			sb.append(actor.getFirstName() + " " + actor.getLastName());
			if (listIt.hasNext()) {
				sb.append(", ");
			} else {
				sb.append("\n");
			}
		}
		
		sb.append("Inventory: ");
		Iterator<Map.Entry<String, Set<Integer>>> it = this.inventory.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Set<Integer>> condition = it.next();
			sb.append(condition.getKey() + "(" + condition.getValue().size() +")");
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		
		sb.append("\n").append("--------------------").append("\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cast, category, description, id, language, languageId, length, rating, releaseYear,
				rentalDuration, rentalRate, replacementCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(cast, other.cast) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(language, other.language) && languageId == other.languageId && length == other.length
				&& Objects.equals(rating, other.rating) && Objects.equals(releaseYear, other.releaseYear)
				&& rentalDuration == other.rentalDuration && Objects.equals(rentalRate, other.rentalRate)
				&& Objects.equals(replacementCost, other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

}