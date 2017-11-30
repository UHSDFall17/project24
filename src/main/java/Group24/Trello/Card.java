package Group24.Trello;

import java.util.*;

public class Card {

	private int card_id;
	private String card_name;
	private Date due_date; 
	private String card_des;
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public String getCard_des() {
		return card_des;
	}
	public void setCard_des(String card_des) {
		this.card_des = card_des;
	}


}
