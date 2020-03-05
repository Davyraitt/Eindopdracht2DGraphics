package GUIScreens.MainMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application {
	
	
	@Override
	public void start ( Stage primarystage ) throws Exception {
		Parent root = FXMLLoader.load ( getClass ( ).getResource ( "/GUIScreens/MainMenu/MainMenu.fxml" ) );
		primarystage.setTitle ( "Login applicatie" );
		primarystage.setScene ( new Scene ( root , 400 , 400 ) );
		primarystage.show ( );
		
		
	}
}
