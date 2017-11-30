package Group24.Trello;

import java.util.List;

public class Team_cre {
<<<<<<< HEAD:src/main/java/Group24/Trello/Team_cre.java
	
	String team_name, team_description;
=======

	String team_name, team_description,team_visibility;
>>>>>>> Nikhita:src/main/java/Group24/Trello/Team_cre.java
	int team_id;
	List<String> team_members;
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_description() {
		return team_description;
	}
	public void setTeam_description(String team_description) {
		this.team_description = team_description;
	}
	public List<String> getTeam_members() {
		return team_members;
	}
	public void setTeam_members(List<String> team_members) {
		this.team_members = team_members;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
<<<<<<< HEAD:src/main/java/Group24/Trello/Team_cre.java
	public Team_cre(String team_name, String team_description, List<String> team_members2) {
		super();
		this.team_name = team_name;
		this.team_description = team_description;
		this.team_members = team_members2;
	}
	

}
=======
	public String getTeam_visibility() {
		return team_visibility;
	}

	public void setTeam_visibility(String team_visibility) {
		this.team_visibility = team_visibility;
	}

	public Team_cre() {
		super();
		this.team_name = team_name;
		this.team_description = team_description;
		this.team_members = team_members;
	}


}
>>>>>>> Nikhita:src/main/java/Group24/Trello/Team_cre.java
