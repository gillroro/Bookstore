package actions;

import com.opensymphony.xwork2.ActionSupport;



public class ReviewBookAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean reviewMe;

	public boolean isReviewMe() {
		return reviewMe;
	}

	public void setReviewMe(boolean reviewMe) {
		this.reviewMe = reviewMe;
	}
	
	public String execute(){
		if(reviewMe){
			return SUCCESS;
		}
		else{
			return "failure";
		}
	}
	
	public String submit(){
		return SUCCESS;
	}

}
