package View;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GamesView {
	private List<TextField> TextFields1;
	private List<TextField> TextFields2;
	private HBox hb1;
	private HBox hb2;
	private VBox vb;
	private Stage stage;
	private Button Done;
	private String gameType;
	private String name1, name2;
	private boolean isWinner;

	public GamesView() {
	}
	
	public GamesView(Stage stage, String gameType, String name1, String name2) {
		this.stage=stage;
		this.gameType = gameType;
		this.name1 = name1;
		this.name2 = name2;
		TextFields1 = new ArrayList<TextField>();
		TextFields2 = new ArrayList<TextField>();
		vb = new VBox();
		hb1 = new HBox();
		hb2 = new HBox();
		Done = new Button("Done");
		Done.setAlignment(Pos.BOTTOM_RIGHT);
		Text title = new Text(gameType + " Game");
		title.setFont(Font.font("Verdana", 26));
		Text txt1 = new Text(name1);
		Text txt2 = new Text(name2);
		txt1.setFont(Font.font("Verdana", 20));
		txt2.setFont(Font.font("Verdana", 20));
		hb1.getChildren().add(txt1);
		hb2.getChildren().add(txt2);
		hb1.setMargin(txt1, new Insets(0, 20, 0, 0));
		hb2.setMargin(txt2, new Insets(0, 20, 0, 0));

		if (gameType == "Tennis") {
			for (int i = 0; i < 3; i++) {
				TextFields1.add(new TextField());
				TextFields2.add(new TextField());
				TextFields1.get(i).setMaxSize(50, 30);
				TextFields2.get(i).setMaxSize(50, 30);
				hb1.getChildren().add(TextFields1.get(i));
				hb2.getChildren().add(TextFields2.get(i));
				hb1.setMargin(TextFields1.get(i), new Insets(0, 10, 0, 0));
				hb2.setMargin(TextFields2.get(i), new Insets(0, 10, 0, 0));
			}
		}

		if (gameType == "Basketball") {
			for (int i = 0; i < 4; i++) {
				TextFields1.add(new TextField());
				TextFields2.add(new TextField());
				TextFields1.get(i).setMaxSize(50, 30);
				TextFields2.get(i).setMaxSize(50, 30);
				hb1.getChildren().add(TextFields1.get(i));
				hb2.getChildren().add(TextFields2.get(i));
				hb1.setMargin(TextFields1.get(i), new Insets(0, 10, 0, 0));
				hb2.setMargin(TextFields2.get(i), new Insets(0, 10, 0, 0));
			}
		}

		if (gameType == "Soccer") {
			for (int i = 0; i < 2; i++) {
				TextFields1.add(new TextField());
				TextFields2.add(new TextField());
				TextFields1.get(i).setMaxSize(50, 30);
				TextFields2.get(i).setMaxSize(50, 30);
				hb1.getChildren().add(TextFields1.get(i));
				hb2.getChildren().add(TextFields2.get(i));
				hb1.setMargin(TextFields1.get(i), new Insets(0, 10, 0, 0));
				hb2.setMargin(TextFields2.get(i), new Insets(0, 10, 0, 0));
			}
		}

		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(title, hb1, hb2, Done);
		vb.setMargin(title, new Insets(0, 0, 90, 0));
		vb.setMargin(hb1, new Insets(0, 0, 30, 0));
		vb.setMargin(hb2, new Insets(0, 0, 50, 0));
		vb.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vb, 500, 500);
		stage.setScene(scene);
		stage.show();
	}

	public String getWinner() {
		int score1 = 0, score2 = 0; 
		int num1=0, num2=0;
		int scoreT1=0,scoreT2=0;
		boolean isOk1,isOk2;

		if(gameType=="Tennis") {
			isOk1=false;
			isOk2=false;
			for (int i = 0; i < TextFields1.size(); i++) {
				try {
					if (isANumber(TextFields1.get(i).getText())) {
						num1=Integer.parseInt(TextFields1.get(i).getText());
						isOk1 = true;
					} else throw new Excption("Try again,it's not a number");
				}catch (Excption e) {
					System.out.println(e.getMessage());
					TextFields1.get(i).clear();
					isOk1=false;
					break;
				}
				try {
					if (isANumber(TextFields2.get(i).getText())) {
						num2=Integer.parseInt(TextFields2.get(i).getText());
						isOk2 = true;
					} else throw new Excption("Try again,it's not a number");
				} catch (Excption e) {
					System.out.println(e.getMessage());
					TextFields2.get(i).clear();
					isOk2=false;
					break;
				}
				
				if(isOk1 && isOk2) {
					if(num1>num2)
						scoreT1++;
					else scoreT2++;

					if((num1-num2)>2)
						score1++;
					if((num2-num1)>2)
						score2++;	
				}
			}
			if(isOk1 && isOk2) {
				if(TextFields1.size()==5) {
					isWinner=true;
					if(scoreT1>scoreT2) 
						return name1;	
					else return name2;		
				}

				if(score1==3) {
					isWinner=true;
					return name1;
				}

				if(score2==3) {
					isWinner=true;
					return name2;
				}

				for (int i = 0; i < 2; i++) {
					TextFields1.add(new TextField());
					TextFields2.add(new TextField());
					TextFields1.get(i+3).setMaxSize(50, 30);
					TextFields2.get(i+3).setMaxSize(50, 30);
					hb1.getChildren().add(TextFields1.get(i+3));
					hb2.getChildren().add(TextFields2.get(i+3));
					hb1.setMargin(TextFields1.get(i+3), new Insets(0, 10, 0, 0));
					hb2.setMargin(TextFields2.get(i+3), new Insets(0, 10, 0, 0));
				}
			}
				isWinner=false;	
		}

		if(gameType=="Soccer") {
			isOk1 = false;
			isOk2=false;
				for (int i = 0; i < TextFields1.size(); i++) {
						try {
							if (isANumber(TextFields1.get(i).getText())){
								num1=Integer.parseInt(TextFields1.get(i).getText());
								score1 = score1 + num1;
								isOk1 = true;
							} else throw new Exception("Try again,it's not a number");
						} catch (Exception e) {
							System.out.println(e.getMessage());	
							TextFields1.get(i).clear();
							isOk1=false;
							break;
						}		

						try {
							if (isANumber(TextFields2.get(i).getText())) {
								num2=Integer.parseInt(TextFields2.get(i).getText());
								//score2 = score2 + num2;
								isOk2 = true;
							} else throw new Exception("Try again,it's not a number");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							TextFields2.get(i).clear();	
							isOk2=false;
							break;
						}
						
						if(isOk1 && isOk2) {
							score1 = score1 + num1;
							score2 = score2 + num2;
						}
				}

				
				
				
				if(isOk1 && isOk2) {
					if(score1 > score2) {
						isWinner=true;
						return name1;
					}	
					if((score1 == score2)&& (TextFields1.size()==2)) {
						TextFields1.add(new TextField());
						TextFields2.add(new TextField());
						TextFields1.get(2).setMaxSize(50, 30);
						TextFields2.get(2).setMaxSize(50, 30);
						hb1.getChildren().add(TextFields1.get(2));
						hb2.getChildren().add(TextFields2.get(2));
						hb1.setMargin(TextFields1.get(2), new Insets(0, 10, 0, 0));
						hb2.setMargin(TextFields2.get(2), new Insets(0, 10, 0, 0));
						isWinner=false;
						return null;
					}
					if((score1 == score2)&& (TextFields1.size()==3)){
						TextFields1.add(new TextField());
						TextFields2.add(new TextField());
						TextFields1.get(3).setMaxSize(50, 30);
						TextFields2.get(3).setMaxSize(50, 30);
						hb1.getChildren().add(TextFields1.get(3));
						hb2.getChildren().add(TextFields2.get(3));
						hb1.setMargin(TextFields1.get(3), new Insets(0, 10, 0, 0));
						hb2.setMargin(TextFields2.get(3), new Insets(0, 10, 0, 0));
						isWinner=false;
						return null;
					}
					
					else {
						isWinner=true;
						return name2;		
					}
				}
				isWinner=false;
		}

		if(gameType=="Basketball") {
			isOk1 = false;
			isOk2 = false;
			for (int i = 0; i < TextFields1.size(); i++) {
				isOk1 = false;
				try {
					String num = TextFields1.get(i).getText();
					if (isANumber(num)){
						num1=Integer.parseInt(num);
						score1 = score1 + num1;
						isOk1= true;
					} else throw new NumberFormatException("Try again,it's not a number");
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					TextFields1.get(i).clear();
					isOk1=false;
					break;
				}			
				try {
					String num=TextFields2.get(i).getText();
					if (isANumber(num)) {
						num2=Integer.parseInt(num);
						score2 = score2 + num2;
						isOk2 = true;
					} else throw new NumberFormatException("Try again,it's not a number");
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					TextFields2.get(i).clear();
					isOk2=false;
					break;
				}		
			}
			if(isOk1 && isOk2) {
				isWinner=true;
				if(score1 > score2) 
					return name1;
				else return name2;
			}
			isWinner=false;
		}	
		return null;
	}

	public boolean getIsWinner() {
		return isWinner;
	}

	public boolean isANumber(String text) {
		String numbers="1234567890";
		for(int i=0;i<text.length();i++) {
			if(!numbers.contains(text.subSequence(i, i+1))) {
				System.out.println("Invalid ID");
				return false;
			}
		}
		return true;
	}






	public void closeStage() {
		stage.close();
	}

	public void addEventToDoneButton(EventHandler<ActionEvent> event) {
		this.Done.setOnAction(event);	
	}


}
