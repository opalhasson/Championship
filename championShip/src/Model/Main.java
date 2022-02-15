package Model;
import Controller.Controller;
import Model.Model;
import View.ChampionShipView;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main  extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage)throws Exception{
		View theView=new View(stage);
		Model theModel=new Model();
		Controller theController=new Controller(theModel,theView);
		
	}
}
