package com.vt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="vt_services")
public class VTServices implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	private String name;

	@Type(type="text")
	private String image;
	
	@Type(type="text")
	private String description;
	
	private String branding;
	
	private Float rating;
	
	@Column(name="setup_fee")
	private Float setupFee;

	@Type(type="text")
	@Column(name="transaction_fees")
	private String transactionFees;

	@Type(type="text")
	@Column(name="how_to_url")
	private String howToUrl;

	@Type(type="text")
	@Column(name="currencies")
	private String currencies;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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
	 * @return the branding
	 */
	public String getBranding() {
		return branding;
	}

	/**
	 * @param branding the branding to set
	 */
	public void setBranding(String branding) {
		this.branding = branding;
	}

	/**
	 * @return the rating
	 */
	public Float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Float rating) {
		this.rating = rating;
	}

	/**
	 * @return the setupFee
	 */
	public Float getSetupFee() {
		return setupFee;
	}

	/**
	 * @param setupFee the setupFee to set
	 */
	public void setSetupFee(Float setupFee) {
		this.setupFee = setupFee;
	}

	/**
	 * @return the transactionFees
	 */
	public String getTransactionFees() {
		return transactionFees;
	}

	/**
	 * @param transactionFees the transactionFees to set
	 */
	public void setTransactionFees(String transactionFees) {
		this.transactionFees = transactionFees;
	}

	/**
	 * @return the howToUrl
	 */
	public String getHowToUrl() {
		return howToUrl;
	}

	/**
	 * @param howToUrl the howToUrl to set
	 */
	public void setHowToUrl(String howToUrl) {
		this.howToUrl = howToUrl;
	}

	/**
	 * @return the currencies
	 */
	public String getCurrencies() {
		return currencies;
	}

	/**
	 * @param currencies the currencies to set
	 */
	public void setCurrencies(String currencies) {
		this.currencies = currencies;
	}
	
}
