package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Catalogue;
import model.Library;

public class AdminController extends Controller<Library> {
        @FXML private Button addPatronBtn;
        @FXML private Button removePatronBtn;
        @FXML private Button addBookBtn;
        @FXML private Button removeBookBtn;
        @FXML private Button closeBtn;
        
    @FXML private void initialize(){}
    
    public final Library getLibrary() { return model; }
    public final Catalogue getCatalogue() { return model.catalogue; }
    
    @FXML private void handleAddPatron(ActionEvent event) throws Exception { 
        ViewLoader.showStage(model, "/view/addPatron.fxml", "Add Patron", new Stage());
    }
    
    @FXML private void handleRemovePatron(ActionEvent event) throws Exception { 
         ViewLoader.showStage(model, "/view/removePatron.fxml", "Remove Patron", new Stage());
    }
    
    @FXML private void handleAddBook(ActionEvent event) throws Exception { 
        ViewLoader.showStage(getCatalogue(), "/view/addBook.fxml", "Add Book", new Stage());
    }
    
    @FXML private void handleRemoveBook(ActionEvent event) throws Exception { 
        ViewLoader.showStage(getCatalogue(), "/view/removeBook.fxml", "Remove Book", new Stage());
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
