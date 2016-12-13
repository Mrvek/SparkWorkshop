package Domain.PAssignment;

public class Assignment {
	private String naam;
	private String description;
	
	public Assignment(String nm, String des){
		naam = nm;
		description =  des;
	}
	
	public String getNaam(){
		return naam;
	}
	public String getDescription(){
		return description;
	}

}
