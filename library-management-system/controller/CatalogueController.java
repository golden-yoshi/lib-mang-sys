package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.Catalogue;
import model.Library;

public class CatalogueController extends Controller<Catalogue>{
        @FXML private Button showAllBtn;
        @FXML private Button availableBooksBtn;
        @FXML private Button byGenreBtn;
        @FXML private Button byAuthorBtn;
        @FXML private Button borrowBtn;
        @FXML private Button returnBtn;
        @FXML private Button holdBtn;
        @FXML private Button closeBtn;
        
    public void initialize() {
    }
    
    public final Catalogue getCatalogue() { return model; }
    public final Library getLibrary() { return model.library; }
    
    
    @FXML private void handleShowAll(ActionEvent event) throws Exception { 
        ViewLoader.showStage(model, "/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
    }
    
    @FXML private void handleShowAvailable(ActionEvent event) throws Exception { 
        ViewLoader.showStage(model, "/view/showAvailableBooks.fxml", "Available Books", new Stage());
    }
    
    @FXML private void handleByGenre(ActionEvent event) throws Exception { 
        ViewLoader.showStage(model, "/view/showBooksByGenre.fxml", "Browse by Genre", new Stage());
    }
    
    @FXML private void handleByAuthor(ActionEvent event) throws Exception { 
        ViewLoader.showStage(model, "/view/showBooksByAuthor.fxml", "Browse by Author", new Stage());
    }
    
    @FXML private void handleBorrow(ActionEvent event) throws Exception { 
        ViewLoader.showStage(model, "/view/borrow.fxml", "Borrow a Book", new Stage());
    }
    
    @FXML private void handleReturn(ActionEvent event) throws Exception { 
        ViewLoader.showStage(model, "/view/return.fxml", "Return a Book", new Stage());
    }
    
    @FXML private void handleHold(ActionEvent event) throws Exception { 
         ViewLoader.showStage(model, "/view/placeHold.fxml", "Place a Hold", new Stage());
    }
    
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
    
}


