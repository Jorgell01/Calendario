package dad.calendario.controllers;

import dad.calendario.model.MonthCalendar;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private GridPane calendarGrid;

    @FXML
    private Button nextButton;

    @FXML
    private Button prevButton;

    @FXML
    private BorderPane root;

    private IntegerProperty year = new SimpleIntegerProperty();

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootController.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        year.set(2025); // Año inicial
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Vincular los botones para avanzar y retroceder el año
        prevButton.setOnAction(e -> year.set(year.get() - 1));
        nextButton.setOnAction(e -> year.set(year.get() + 1));

        // Crear y añadir los calendarios mensuales al GridPane
        for (int month = 1; month <= 12; month++) {
            MonthCalendar monthCalendar = new MonthCalendar();
            monthCalendar.monthProperty().set(month);
            monthCalendar.yearProperty().bind(year);

            // Configurar para que el MonthCalendar crezca y se ajuste
            GridPane.setHgrow(monthCalendar, Priority.ALWAYS);
            GridPane.setVgrow(monthCalendar, Priority.ALWAYS);

            int row = (month - 1) / 4; // 3 filas
            int col = (month - 1) % 4; // 4 columnas
            calendarGrid.add(monthCalendar, col, row);
        }

        // Ajustar alineación central
        calendarGrid.setAlignment(Pos.CENTER);
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public BorderPane getRoot() {
        return root;
    }
}
