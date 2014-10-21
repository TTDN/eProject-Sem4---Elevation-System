package dto;

public class ReplyComplaint {
	private int ID_ReplyComplaint;
	private int ID_Complaint;
	private String Contents;
	public int getID_ReplyComplaint() {
		return ID_ReplyComplaint;
	}
	public void setID_ReplyComplaint(int iD_ReplyComplaint) {
		ID_ReplyComplaint = iD_ReplyComplaint;
	}
	public int getID_Complaint() {
		return ID_Complaint;
	}
	public void setID_Complaint(int iD_Complaint) {
		ID_Complaint = iD_Complaint;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	public ReplyComplaint(int iD_ReplyComplaint, int iD_Complaint,
			String contents) {
		super();
		ID_ReplyComplaint = iD_ReplyComplaint;
		ID_Complaint = iD_Complaint;
		Contents = contents;
	}
	public ReplyComplaint() {
		super();
		// TODO Auto-generated constructor stub
	}

}
