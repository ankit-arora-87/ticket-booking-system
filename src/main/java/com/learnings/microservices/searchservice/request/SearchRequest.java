/**
 * 
 */
package com.learnings.microservices.searchservice.request;

/**
 * @author ankitarora
 *
 */


public class SearchRequest {

	private String movie;
	private String city;
	private String bookingDate;
	private int offset = 0;
	private int limit = 50;
	private String sortBy;
	
	
	public SearchRequest() {
		super();
	}


	public SearchRequest(String movie, String city, String bookingDate, int offset, int limit, String sortBy) {
		super();
		this.movie = movie;
		this.city = city;
		this.bookingDate = bookingDate;
		this.offset = offset;
		this.limit = limit;
		this.sortBy = sortBy;
	}


	/**
	 * @return the movie
	 */
	public String getMovie() {
		return movie;
	}


	/**
	 * @param movie the movie to set
	 */
	public void setMovie(String movie) {
		this.movie = movie;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the bookingDate
	 */
	public String getBookingDate() {
		return bookingDate;
	}


	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}


	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}


	/**
	 * @param offset the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}


	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}


	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}


	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return sortBy;
	}


	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}


	@Override
	public String toString() {
		return "SearchRequest [movie=" + movie + ", city=" + city + ", bookingDate=" + bookingDate + ", offset="
				+ offset + ", limit=" + limit + ", sortBy=" + sortBy + "]";
	}
	
	
	
	
}
