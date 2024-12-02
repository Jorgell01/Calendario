package dad.calendario.app;

import dad.calendario.controllers.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalendarioApp extends Application {

    RootController rootController = new RootController();

    Scene scene = new Scene(rootController.getRoot(), 800, 600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Calendario");

    primaryStage.show();

}
