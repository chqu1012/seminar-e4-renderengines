package de.dc.hska.seminararbeit;

import java.security.acl.LastOwnerException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javax.inject.Inject;

import de.dc.hska.seminararbeit.bean.Person;
import de.dc.hska.seminararbeit.bean.Student;

public class TestView {

	@Inject
	public TestView(BorderPane parent) {
		TableView<Student> table = new TableView<Student>();
		
        final Label label = new Label("Studentenliste");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        String[] titles = {"Matrikel","Vorname","Nachname","Email"};
        createColumns(table, titles);
        
        final ObservableList<Student> data = createData();
		table.setItems(data);
        
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(table.getColumns().get(0).getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(table.getColumns().get(1).getPrefWidth());
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(table.getColumns().get(2).getPrefWidth());
        addEmail.setPromptText("Email");
 
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Student(
                		addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText(),"12345"));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
            }
        });
        final HBox hb = new HBox();
        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        hb.setSpacing(3);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
		
        parent.setCenter(vbox);
	}

	private void createColumns(TableView view,String[] titles){
		TableColumn column;
		for (String title : titles) {
	        column = new TableColumn(title);
	        column.setMinWidth(100);
	        column.setCellValueFactory( new PropertyValueFactory<Student,String>(title.toLowerCase()));
	        view.getColumns().add(column);
		}
	}
	
	private ObservableList<Student> createData() {
		ObservableList<Student> data = FXCollections.observableArrayList(
			    new Student("Jacob", "Smith", "jacob.smith@example.com", "33123"),
			    new Student("Isabella", "Johnson", "isabella.johnson@example.com", "31123"),
			    new Student("Ethan", "Williams", "ethan.williams@example.com", "43123"),
			    new Student("Emma", "Jones", "emma.jones@example.com", "553123"),
			    new Student("Michael", "Brown", "michael.brown@example.com", "34423")
			);	
		return data;
	}
}
