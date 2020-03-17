package food.controller;

import food.entity.Category;
import food.model.CategoryModel;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryController extends Application {
    @FXML
    private GridPane mygrid;
    CategoryModel categoryModel = new CategoryModel();
    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("category.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Category");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public void getGird() throws IOException {
        List<ImageDataObjs> imageURLs = new ArrayList<>();
        List<Category> categoryList = categoryModel.list();
        for (Category category: categoryList) {
           imageURLs.add(new ImageDataObjs(category.getImage()));
        }
    }

    class ImageDataObjs{
        @FXML
        final ImageView the_image;
        String imgURL;

        public ImageDataObjs(String imgURL) throws IOException {
            this.imgURL = imgURL;
            WritableImage image = new WritableImage(50,50);
            this.the_image = new ImageView(image);
        }
    }

}
