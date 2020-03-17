package food.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button btnCategory;
    Stage stage;

    public void Category(ActionEvent actionEvent) throws Exception{
        Parent category = FXMLLoader.load(getClass().getResource("view/category.fxml"));
        stage.setTitle("Category");
        stage.setScene(new Scene(category,800,400));
        stage.show();
    }

}
