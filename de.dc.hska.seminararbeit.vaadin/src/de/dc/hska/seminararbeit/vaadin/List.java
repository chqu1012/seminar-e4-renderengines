package de.dc.hska.seminararbeit.vaadin;

import javax.inject.Inject;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;

public class List {
	@Inject
	public List(ComponentContainer parent)
	{
        parent.addComponent(new Label("First View"));
	}
}
