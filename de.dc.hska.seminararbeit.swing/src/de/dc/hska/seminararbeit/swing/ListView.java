package de.dc.hska.seminararbeit.swing;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import org.eclipse.e4.ui.model.application.MApplication;

import de.dc.hska.seminararbeit.model.Student;

@SuppressWarnings("restriction")
public class ListView {
	@Inject
	public ListView(JPanel parent, final MApplication application) {
		final String[] columnNames = {"First Name",
                "Last Name",
                "Email",};
		
		final List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Hans", "Peter", "hans.peter@web.de"));
		studentList.add(new Student("Peter", "Parker", "Peter.Parker@web.de"));
		studentList.add(new Student("Mary", "Jane", "Mary.Jane@web.de"));
		studentList.add(new Student("James", "Bond", "James.Bond@web.de"));
		studentList.add(new Student("Bilbo", "Beutlin", "Bilbo.Bilbo@web.de"));
		studentList.add(new Student("Jens", "Jolton", "Jens.Jolton@web.de"));
		studentList.add(new Student("Don", "Wayne", "hans.peter@web.de"));
		studentList.add(new Student("Hans", "Peter", "hans.peter@web.de"));
		
		AbstractTableModel tableModel = new AbstractTableModel() {
			@Override
			public String getColumnName(int column) {
				return columnNames[column];
			}
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				Student student= studentList.get(rowIndex);
				if (columnIndex == 0) {
					return student.getFirstName();
				} else if (columnIndex == 1) {
					return student.getLastName();
				}else if (columnIndex == 2) {
					return student.getEmail();
				}
				return "?";
			}

			@Override
			public int getRowCount() {
				return studentList.size();
			}

			@Override
			public int getColumnCount() {
				return columnNames.length;
			}
		};
		
		
		JTable table = new JTable(tableModel);
		parent.add(table);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		parent.add(scrollPane, BorderLayout.CENTER);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = ((DefaultListSelectionModel) e.getSource()).getAnchorSelectionIndex();
				Student student= studentList.get(index);
				if (!e.getValueIsAdjusting()) {
					application.getContext().set(Student.class, student);
				}
			}
		});
	}
}
