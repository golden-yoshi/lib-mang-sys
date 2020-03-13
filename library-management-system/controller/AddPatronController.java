package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Catalogue;
import model.Library;
import model.Patron;

public class AddPatronController extends Controller<Library> {
    @FXML private TextField IDTf;
    @FXML private TextField nameTf;
    @FXML private Button addPatronBtn;
    @FXML private Text addPatronTxt;
  
    
    @FXML private void initialize(){}
    
    public final Library getLibrary() { return model; }
    public final Catalogue getCatalogue() { return model.catalogue; }
    private int getID() { return Integer.parseInt(IDTf.getText()); } //breaks down string input and returns as integer
    private String getName() { return nameTf.getText(); }
    
    @FXML private void handleAddPatron(ActionEvent event) throws Exception { 
        if (IDTf.getText().matches("[0-9]+") && !(nameTf.getText().matches(""))){ 
            //if ID is a number between 0 and 9 and if name is not empty
            if (getLibrary().getPatron(getID()) == null) { //if patron ID doesn't exist, add patron
                getLibrary().addPatron(getID(), getName());
                addPatronTxt.setText("Patron added.");
            } else {
                addPatronTxt.setText("Patron already exists!");
            }
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
