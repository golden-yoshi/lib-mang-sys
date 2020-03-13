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

public class BorrowController extends Controller<Catalogue> {
    @FXML private TextField IDTf;
    @FXML private ListView<Book> availableLv;
    @FXML private Button selectBtn;
    @FXML private Button borrowBtn;
    
    @FXML private void initialize(){
        IDTf.textProperty().addListener((o, oldText, newText) 
                -> selectBtn.setDisable(!IDTf.getText().matches("[0-9]+")));
        //listener is added to see if texfield changes value, button currently disabled
        //if textfield has number value, button is no longer disabled
        availableLv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldBook, newBook) -> borrowBtn.setDisable(newBook == null)
        ); //if no book is selected from list, borrow button is disabled
    }
    
    public final Catalogue getCatalogue() { return model; }
    public final Library getLibrary() {return model.library; }
    private int getID() { return Integer.parseInt(IDTf.getText()); }
    public final Patron getPatron() { return getLibrary().getPatron(getID()); }
    
    @FXML private void handleSelectPatron(ActionEvent event) throws Exception { 
        if (getLibrary().getPatron(getID()) != null) {
            availableLv.setItems(getCatalogue().getBorrowableBooks(getPatron()));
        }
    }
    
    private Book getSelectedBook() {
        return availableLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleBorrow(ActionEvent event) throws Exception {
        Book book = getSelectedBook();
        getCatalogue().loanBookToPatron(book, getPatron()); //calls method
        availableLv.setItems(getCatalogue().getBorrowableBooks(getPatron()));
        //sets items of the list to books that particular patron can borrow
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }

}
