package appStore;

public class Review {
	private int numStars;
	private String review;
	
	public Review(int stars, String review) {
		numStars = stars;
		this.review = review;
	}

	public int getNumStars() {
		return numStars;
	}

	public void setNumStars(int numStars) {
		this.numStars = numStars;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
}
