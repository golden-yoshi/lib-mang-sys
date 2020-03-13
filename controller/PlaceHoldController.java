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

public class PlaceHoldController extends Controller<Catalogue>{
    @FXML private TextField IDTf;
    @FXML private ListView<Book> booksLv;
    @FXML private Button selectBtn;
    @FXML private Button holdBtn;
    @FXML private Text patronTxt;
    
    @FXML private void initialize() throws Exception{
        IDTf.textProperty().addListener((o, oldText, newText) 
            -> selectBtn.setDisable(!IDTf.getText().matches("[0-9]+")));
        //listener is added to see if texfield changes value, button currently disabled
        //if textfield has number value, button is no longer disabled
        booksLv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldBook, newBook) -> holdBtn.setDisable(newBook == null || IDTf.getText().matches("")));
        //if no book is selected from the list OR if there is no id 
    }
    
    public final Catalogue getCatalogue() { return model; }
    public final Library getLibrary() {return model.library; }
    private int getID() { return Integer.parseInt(IDTf.getText()); }
    //private String getPatronName() { return getLibrary().getPatron(getID()).getName(); } 
    private String getBookTitle() { return getSelectedBook().getTitle(); }
    //private Patron getHolder() { return getSelectedBook().patronWithFirstHold(); }
    private String getHolderName() { return getSelectedBook().patronWithFirstHold().getName(); }
    
    @FXML private void handleSelectPatron(ActionEvent event) throws Exception { 
        if (getLibrary().getPatron(getID()) != null) {
            holdBtn.setDisable(false);
        }
    }
    
     private Book getSelectedBook() {
        return booksLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleHoldBook(ActionEvent event) throws Exception {  
        Patron patron = getCatalogue().getPatron(getID());
        Patron holder = getSelectedBook().patronWithFirstHold();
        if (getLibrary().getPatron(getID()) != null) {
            if (!getSelectedBook().isHeldBy(holder)){
                getSelectedBook().addHold(patron);
                patronTxt.setText("Hold placed on " + getBookTitle() + " for " + getHolderName());
            } else {
                patronTxt.setText(getHolderName() + " has already placed a hold on " + getBookTitle());
            }
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
