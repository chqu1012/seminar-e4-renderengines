package de.dc.hska.seminararbeit;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;

public class StatusBar {

	@Inject
	public StatusBar(BorderPane pane) {
		Button button = new Button("Add Student");
		pane.setCenter(button);
	}
}
