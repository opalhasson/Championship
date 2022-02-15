package Model;

import java.util.ArrayList;
import javafx.scene.control.TextField;

public class Model {
	private ArrayList<String> participants;
	private ArrayList<String> winnersOfFirstRound;
	private ArrayList<String> winnersOfSecondRound;

	public Model() {
		participants = new ArrayList<String>();
		winnersOfFirstRound= new ArrayList<String>();
		winnersOfSecondRound= new ArrayList<String>();
	}

	public void updateList(String name) {
		participants.add(name);
	}

	public String getParticipant(int i) {
		return participants.get(i).toString();
	}

	public void updateFirstRoundWinners(String name, int i) {
		winnersOfFirstRound.add(i, name);
	}

	public ArrayList<String> getpart() {
		return participants;
	}

	public void updateSecondRoundWinners(String name, int i) {
		winnersOfSecondRound.add(i, name);
	}
	
	public ArrayList<String> getFirstRoundWinners(){
		return winnersOfFirstRound;
	}

	public ArrayList<String> getSecondRoundWinners(){
		return winnersOfSecondRound;
	}

}
