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

public class FavouritesController extends Controller<Catalogue>{
    @FXML private TextField IDTf;
    @FXML private ListView<Book> favouritesLv;
    @FXML private Text patronTxt;
    @FXML private Button showBtn;
    
    @FXML private void initialize(){
        IDTf.textProperty().addListener((o, oldText, newText) 
                -> showBtn.setDisable(!IDTf.getText().matches("[0-9]+")));
        //listener is added to see if texfield changes value, button currently disabled
        //if textfield has number value, button is no longer disabled
    }
    
    public final Catalogue getCatalogue() { return model; }
    public final Library getLibrary() { return model.library; }
    private int getID() { return Integer.parseInt(IDTf.getText()); }
    private String getPatronName() { return getLibrary().getPatron(getID()).getName(); }
    //gets name of patron by calling methods from library model
    
    @FXML private void handleShowFavourites(ActionEvent event) throws Exception {
        if (getLibrary().getPatron(getID()) != null) { //if patron exists (doesn't not exist)
            patronTxt.setText(getPatronName() + "'s favourite books:");
            favouritesLv.setItems(getCatalogue().getPatron(getID()).favourites());
        } else {
            patronTxt.setText("Invalid Patron ID.");
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
