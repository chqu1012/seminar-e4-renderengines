package de.dc.hska.seminararbeit.rap.model;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class MyLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		Person p =(Person)element;
		switch (columnIndex) {
		case 0:
			return p.getName();
		case 1:
			return p.getFirstname();
		case 2:
			return p.getEmail();
		default:
		}
		return null;
	}

}
