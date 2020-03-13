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

public class RemovePatronController extends Controller<Library>{
        @FXML private ListView<Patron> patronsLv;
        @FXML private Button removeBtn;
        @FXML private Button closeBtn;
        
    @FXML private void initialize(){}
        
    private Patron getSelectedPatron() {
        return patronsLv.getSelectionModel().getSelectedItem();
    }
    
    public final Library getLibrary() { return model; }
    
    @FXML private void handleRemovePatron(ActionEvent event) throws Exception { 
        Patron patron = getSelectedPatron();
        if (patron != null){
            getLibrary().removePatron(patron);
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
