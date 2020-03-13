package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Author;
import model.Book;
import model.Catalogue;
import model.Genre;

public class ShowAllBooksController extends Controller<Catalogue>{
    @FXML private TableView<Book> booksTv;
    @FXML private TableColumn<Book, String> titleClm;
    @FXML private TableColumn<Book, Author> authorClm;
    @FXML private TableColumn<Book, Genre> genreClm;
        
    @FXML private void initialize(){
    }
    
    public final Catalogue getCatalogue() { return model; }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }

}
