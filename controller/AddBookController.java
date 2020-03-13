package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Catalogue;
import model.Library;

public class AddBookController extends Controller<Catalogue>{
    @FXML private TextField titleTf;
    @FXML private TextField authorTf;
    @FXML private TextField genreTf;
    @FXML private Button addBtn;
    @FXML private Text addBookTxt;
    
    @FXML private void initialize(){}
    
    public final Catalogue getCatalogue() { return model; }
    private String getTitle() { return titleTf.getText(); }
    private String getAuthor() { return authorTf.getText(); }
    private String getGenre() { return genreTf.getText(); }
    
    @FXML private void handleAddBook(ActionEvent event) throws Exception {
        if (!(titleTf.getText().matches("")) && !(authorTf.getText().matches("")) && !(genreTf.getText().matches(""))){
            if(!getCatalogue().hasBook(getTitle(), getAuthor())){ 
            //if catalogue doesn't have book title and author, add book
                getCatalogue().addBook(getTitle(), getAuthor(), getGenre());
                addBookTxt.setText("Book added to Catalogue.");
            } else {
                addBookTxt.setText("That book is already in the Catalogue.");
            }
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close(); //closes current window
    }
}
