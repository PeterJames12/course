package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.Getter;
import service.InitService;

public class AppManager extends Application {

    @Getter
    private static Stage stage;

    public void start(Stage primaryStage) throws Exception {
        InitService.createTables();
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("\\view\\users.fxml"));
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("photo/miracle.png"));
        scene.getStylesheets().add("css/main.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miracle IT");
        primaryStage.show();
    }
}
