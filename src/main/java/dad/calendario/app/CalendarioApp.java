package dad.calendario.app;

import dad.calendario.controllers.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalendarioApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Cargar el icono
        Image icon = new Image(getClass().getResourceAsStream("/images/calendar-16x16.png"));

        primaryStage.getIcons().add(icon);

        RootController rootController = new RootController();
        Scene scene = new Scene(rootController.getRoot());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
