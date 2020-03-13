package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Catalogue;
import model.Library;

public class LibraryController extends Controller<Library> { //uses Library model
        @FXML private Button catalogueBtn;
        @FXML private Button patronRecordBtn;
        @FXML private Button favouritesBtn;
        @FXML private Button adminBtn;
        @FXML private Button exitBtn;
        
    public void initialize() {
    }
    
    public final Library getLibrary() { return model; } //uses the current model Library
    public final Catalogue getCatalogue() { return model.catalogue; } //calls Catalogue model 
    
    @FXML private void handleViewCatalogue(ActionEvent event) throws Exception { 
        //button uses action event parameter for when buton is pressed 
        //throws exception to be handled elsewhere
        ViewLoader.showStage(getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
        //ViewLoader.showStage( <model>, <fxml>, <title>, <stage>);
    }
    
    @FXML private void handleViewRecord(ActionEvent event) throws Exception {
        ViewLoader.showStage(getCatalogue(), "/view/record.fxml", "Patron Record", new Stage());
    }
    
    @FXML private void handleViewAdmin(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/admin.fxml", "Administration Menu", new Stage());
    }
    
    @FXML private void handleViewFavourites(ActionEvent event) throws Exception {
        ViewLoader.showStage(getCatalogue(), "/view/favourites.fxml", "Favourites", new Stage());
    }
     
    @FXML private void handleExit(ActionEvent event) throws Exception {
        Platform.exit(); //closes all windows in program
    }
     
     
    

}
