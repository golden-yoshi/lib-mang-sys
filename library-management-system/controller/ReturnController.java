package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Book;
import model.Catalogue;
import model.Library;
import model.Patron;

public class ReturnController extends Controller<Catalogue>{
    @FXML private TextField IDTf;
    @FXML private ListView<Book> borrowedLv;
    @FXML private Button selectBtn;
    @FXML private Button returnBtn;
    
    @FXML private void initialize(){
        IDTf.textProperty().addListener((o, oldText, newText) 
            -> selectBtn.setDisable(!IDTf.getText().matches("[0-9]+")));
        borrowedLv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldBook, newBook) -> returnBtn.setDisable(newBook == null)
        );
    }
    
    public final Catalogue getCatalogue() { return model; }
    public final Library getLibrary() {return model.library; }
    private int getID() { return Integer.parseInt(IDTf.getText()); }
    public final Patron getPatron() { return getLibrary().getPatron(getID()); }
    
    @FXML private void handleSelectPatron(ActionEvent event) throws Exception { 
        if (getLibrary().getPatron(getID()) != null) {
            borrowedLv.setItems(getCatalogue().getPatron(getID()).currentlyBorrowed());
        }
    }
    
    private Book getSelectedBook() {
        return borrowedLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleReturn(ActionEvent event) throws Exception {
        Book book = getSelectedBook();
        getCatalogue().returnBookFromPatron(book, getPatron());
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
