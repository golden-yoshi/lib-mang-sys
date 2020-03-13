package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Book;
import model.Catalogue;
import model.Library;
import model.Patron;

public class RemoveBookController extends Controller<Catalogue>{
        @FXML private ListView<Book> booksLv;
        @FXML private Button removeBtn;
        @FXML private Button closeBtn;
        
    @FXML private void initialize(){}
        
    private Book getSelectedBook() {
        return booksLv.getSelectionModel().getSelectedItem();
    }
    
    public final Catalogue getCatalogue() { return model; }
    
    @FXML private void handleRemoveBook(ActionEvent event) throws Exception { 
        Book book = getSelectedBook();
        if (book != null){ //remove book only if selected
            getCatalogue().removeBook(book);
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
