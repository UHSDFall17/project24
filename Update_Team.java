package Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Update_Team {
	public static void main(String[] args) {
			System.out.println("Enter a team name");
			Scanner scan = new Scanner (System.in);
			String team_name = scan.next();
			List <String> team_members = new ArrayList<>(); // Creating array for storing team members
			System.out.println("Enter description");
			String description = scan.next();	
			// Team members adding
			System.out.println("Team members");
			Start:
				do {System.out.println("Enter team member name");
				String member = scan.next();
				team_members.add(member);
				System.out.println("Add another member? (Y/N)");
				char x = scan.next().charAt(0);
				if (x=='Y'||x=='y')
				{
					continue Start;
				}
					else{
					if (x=='N'||x=='n'){
						break Start;
					}
					else {
						System.out.println("Wrong input");
						continue Start;
					}
				}
				
			}while (true) ;
			Team_cre team_cre1 = new Team_cre(team_name, description, team_members);
	}
}
	
