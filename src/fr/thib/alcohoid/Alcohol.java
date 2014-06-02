package fr.thib.alcohoid;

public class Alcohol {
private long 	id;
private String 	title;
private String 	type;
private String country;
private String region;
private float	price;
private String 	date;
private String comments;
private float 	rate;
private int 	amount;


	public Alcohol(String title, String type, String country, String region, float price,
			String date, String comments, float rate, int amount){
		this.setTitle(title);
		this.setType(type);
		this.setCountry(country);
		this.setRegion(region);
		this.setPrice(price);
		this.setDate(date);
		this.setComments(comments);
		this.setRate(rate);
		this.setAmount(amount);
	}


	
	public Alcohol() {
		
	}


	/**Getter & Setter**/
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public float getRate() {
		return rate;
	}


	public void setRate(float rate) {
		this.rate = rate;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	


}
