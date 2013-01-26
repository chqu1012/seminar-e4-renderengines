package de.dc.hska.seminararbeit.vaadin;

import javax.inject.Inject;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;

public class View {
	@Inject
	public View(ComponentContainer parent)
	{
        parent.addComponent(new Label("First View"));
	}
}
