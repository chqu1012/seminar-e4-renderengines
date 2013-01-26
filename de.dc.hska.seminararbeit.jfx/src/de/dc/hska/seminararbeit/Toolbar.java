package de.dc.hska.seminararbeit;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javax.inject.Inject;

public class Toolbar {

	@Inject
	public Toolbar(GridPane pane) {
		Label label = new Label();
		label.setText("Willkommen bei der Seminararbeit");
		pane.add(label, 0, 0);
	}
}
