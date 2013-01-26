package de.dc.hska.seminararbeit.rap;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

import de.dc.hska.seminararbeit.rap.model.MyLabelProvider;
import de.dc.hska.seminararbeit.rap.model.Person;

public class View extends ViewPart {
	public static final String ID = "de.dc.hska.seminararbeit.rap.view";

	private TableViewer viewer;

	public void createPartControl(Composite parent) {
		int style = SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
		viewer = new TableViewer(parent, style);
		viewer.setContentProvider(new ArrayContentProvider());
//		viewer.setLabelProvider(new MyLabelProvider());
		
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true); 
		
		TableViewerColumn col = new TableViewerColumn(viewer, SWT.NONE);
		col.getColumn().setWidth(200);
		col.getColumn().setText("Firstname:");
		col.setLabelProvider(new ColumnLabelProvider() {
		  @Override
		  public String getText(Object element) {
		    Person p = (Person) element;
		    return p.getName();
		  }
		});

		col = new TableViewerColumn(viewer, SWT.NONE);
		col.getColumn().setWidth(200);
		col.getColumn().setText("Firstname:");
		col.setLabelProvider(new ColumnLabelProvider() {
			  @Override
			  public String getText(Object element) {
			    Person p = (Person) element;
			    return p.getFirstname();
			  }
			});
		
		col = new TableViewerColumn(viewer, SWT.NONE);
		col.getColumn().setWidth(200);
		col.getColumn().setText("Email:");
		col.setLabelProvider(new ColumnLabelProvider() {
			  @Override
			  public String getText(Object element) {
			    Person p = (Person) element;
			    return p.getEmail();
			  }
			});
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Peter","Hans","peter.hans@web.de"));
		persons.add(new Person("Jan","Krumm","jan.krumm@web.de"));
		persons.add(new Person("Günther","Matt","günther.matt@web.de"));
		persons.add(new Person("Anna","Otter","anna.otter@web.de"));
		persons.add(new Person("Maria","Kal","maria.kal@web.de"));
		viewer.setInput(persons);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}