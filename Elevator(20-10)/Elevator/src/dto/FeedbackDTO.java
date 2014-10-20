package dto;

public class FeedbackDTO {
	private int ID_Feedback;
	private String Name;
	private String Email;
	private String Description;
	private String Satisfying;
	private String Contents;
	private String Problem;
	private String Improvement;
	
	public int getID_Feedback() {
		return ID_Feedback;
	}
	public void setID_Feedback(int iD_Feedback) {
		ID_Feedback = iD_Feedback;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getSatisfying() {
		return Satisfying;
	}
	public void setSatisfying(String satisfying) {
		Satisfying = satisfying;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	public String getProblem() {
		return Problem;
	}
	public void setProblem(String problem) {
		Problem = problem;
	}
	public String getImprovement() {
		return Improvement;
	}
	public void setImprovement(String improvement) {
		Improvement = improvement;
	}
	
	public FeedbackDTO(int iD_Feedback, String name, String email,
			String description, String satisfying, String contents,
			String problem, String improvement) {
		super();
		ID_Feedback = iD_Feedback;
		Name = name;
		Email = email;
		Description = description;
		Satisfying = satisfying;
		Contents = contents;
		Problem = problem;
		Improvement = improvement;
	}
	public FeedbackDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


}
