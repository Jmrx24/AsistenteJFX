package application;

import com.jfoenix.controls.JFXButton;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Control {

	@FXML
	private AnchorPane pane1;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;

	@FXML
	private Label countLabel;
	
	@FXML
	private JFXButton skip;
	

/**
 * 
 * Este método permite el cambio entre panes
 */
	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	public void initialize() {
		translateAnimation(0.5, pane2, 621);
		translateAnimation(0.5, pane3, 621);
	}

	int showSlide = 0;

	/**
	 * Este es el método skip, que permite terminar el programa
	 * en cualquier momento de la ejecución del mismo.
	 */
	@FXML
	void skip() 
	{
	System.exit(0);	
	}
	
	@FXML
	void nextAction() {

		if (showSlide == 0) {
			translateAnimation(0.5, pane2, -621);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
		} else if (showSlide == 1) {

			translateAnimation(0.5, pane3, -621);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");

		} else {
			System.out.println("No more slides");
		}

	}

	@FXML
	void backAction() {

		if (showSlide == 0) {
			System.out.println("No more slides");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 621);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 621);
			showSlide--; // showSlide=1
			countLabel.setText("2/3");
		}

		

	}
}