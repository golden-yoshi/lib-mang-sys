package controller;

import au.edu.uts.ap.javafx.Controller;
import java.awt.print.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import model.Author;
import model.Catalogue;
import model.Genre;

public class ShowBooksByAuthorController extends Controller<Catalogue>{
    @FXML private Text genreTxt;
    @FXML private ListView<Author> authorsLv;
    @FXML private Button displayBtn;
    @FXML private Text filterTxt;
    @FXML private ListView<model.Book> filterLv;
    @FXML private Button closeBtn;
    
    @FXML private void initialize(){}
    
    public final Catalogue getCatalogue() { return model; }
    
    private Author getSelectedAuthor() {
        return authorsLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleFilter(ActionEvent event) throws Exception { 
        Author author = getSelectedAuthor();
        if ( author != null) { //set list to show only books by selectd author
            filterLv.setItems(getCatalogue().getBooksByAuthor(author));
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }

}
