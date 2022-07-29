package com.skilldistillery.filmquery.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Film {
	private byte rentalDuration;
	private short languageId, length;
	private int id;
	private BigDecimal rentalRate, replacementCost;
	private String title, description, rating;
	private String[] specialFeatures;
	private LocalDate releaseYear;
	private List<Actor> cast;

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
	public Film(int id, String title, String description, LocalDate releaseYear, short languageId, byte rentalDuration, BigDecimal rentalRate, short length, 
			BigDecimal replacementCost, String rating, String[] specialFeatures) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
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
		return title;
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
		return description;
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
	public String[] getSpecialFeatures() {
		return specialFeatures;
	}

	/**
	 * @param specialFeatures the specialFeatures to set
	 */
	public void setSpecialFeatures(String[] specialFeatures) {
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
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(specialFeatures);
		result = prime * result + Objects.hash(description, id, languageId, length, rating, releaseYear, rentalDuration,
				rentalRate, replacementCost, title);
		return result;
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
		return Objects.equals(description, other.description) && id == other.id && languageId == other.languageId
				&& length == other.length && rating == other.rating && Objects.equals(releaseYear, other.releaseYear)
				&& rentalDuration == other.rentalDuration && Objects.equals(rentalRate, other.rentalRate)
				&& Objects.equals(replacementCost, other.replacementCost)
				&& Arrays.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

}