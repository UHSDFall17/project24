package Group24.Trello;

public class Cred {

		public String username;
		private int teamid;
		private int memberid;
		private int boardid;
		private int cardid;
		private int listid;
		protected String getUsername() {
			return username;
		}
		protected void setUsername(String username) {
			this.username = username;
		}
		protected int getTeamid() {
			return teamid;
		}
		protected void setTeamid(int teamid) {
			this.teamid = teamid;
		}
		protected int getMemberid() {
			return memberid;
		}
		protected void setMemberid(int memberid) {
			this.memberid = memberid;
		}
		protected int getBoardid() {
			return boardid;
		}
		protected void setBoardid(int boardid) {
			this.boardid = boardid;
		}
		protected int getCardid() {
			return cardid;
		}
		protected void setCardid(int cardid) {
			this.cardid = cardid;
		}
		protected int getListid() {
			return listid;
		}
		protected void setListid(int listid) {
			this.listid = listid;
		}
/*private final static Cred instance = new Cred();
private Cred() {}
public static Cred getInstance() {
	return instance;*/



}
