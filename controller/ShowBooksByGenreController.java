package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Author;
import model.Book;
import model.Catalogue;
import model.Genre;

public class ShowBooksByGenreController extends Controller<Catalogue>{
    @FXML private Text genreTxt;
    @FXML private ListView<Genre> genresLv;
    @FXML private Button displayBtn;
    @FXML private Text filterTxt;
    @FXML private ListView<Book> filterLv;
    @FXML private Button closeBtn;
    
    @FXML private void initialize(){}
    
    public final Catalogue getCatalogue() { return model; }
    
    private Genre getSelectedGenre() {
        return genresLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleFilter(ActionEvent event) throws Exception { 
        Genre genre = getSelectedGenre();
        if ( genre != null) { //set list to show only books by selectd author
            filterLv.setItems(getCatalogue().getBooksInGenre(genre));
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }

}
