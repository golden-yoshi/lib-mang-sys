package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Book;
import model.Catalogue;
import model.Library;
import model.Patron;

public class RecordController  extends Controller<Catalogue>{
    @FXML private TextField IDTf;
    @FXML private ListView<Book> borrowedLv;
    @FXML private ListView<Book> historyLv;
    @FXML private Button showBtn;
    @FXML private Text patronTxt;
    
    @FXML private void initialize(){
        IDTf.textProperty().addListener((o, oldText, newText) 
                -> showBtn.setDisable(!IDTf.getText().matches("[0-9]+")));
    }
    
    public final Catalogue getCatalogue() { return model; }
    public final Library getLibrary() { return model.library; }
    private int getID() { return Integer.parseInt(IDTf.getText()); }
    private String getPatronName() { return getLibrary().getPatron(getID()).getName(); }
    
    @FXML private void handleShowRecord(ActionEvent event) throws Exception { 
        if (getLibrary().getPatron(getID()) != null) {
            patronTxt.setText(getID() + " " + getPatronName());
            borrowedLv.setItems(getCatalogue().getPatron(getID()).currentlyBorrowed());
            historyLv.setItems(getCatalogue().getPatron(getID()).borrowingHistory());
        } else {
            patronTxt.setText("Invalid Patron ID.");
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
