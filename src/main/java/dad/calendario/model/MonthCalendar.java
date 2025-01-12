package dad.calendario.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MonthCalendar extends VBox {

    private IntegerProperty monthProperty = new SimpleIntegerProperty();
    private IntegerProperty yearProperty = new SimpleIntegerProperty();

    public MonthCalendar() {
        monthProperty.addListener((obs, oldMonth, newMonth) -> updateCalendar());
        yearProperty.addListener((obs, oldYear, newYear) -> updateCalendar());
        this.setPrefSize(200, 200); // Tamaño preferido inicial
        this.setMinSize(100, 100); // Tamaño mínimo
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // Permitir crecimiento

        // Detectar cambios en el tamaño
        this.widthProperty().addListener((obs, oldVal, newVal) -> updateCalendar());
        this.heightProperty().addListener((obs, oldVal, newVal) -> updateCalendar());
    }

    private void updateCalendar() {
        // Limpiar el contenido actual del calendario
        this.getChildren().clear();

        // Obtener el mes y el año actuales
        int month = monthProperty.get();
        int year = yearProperty.get();

        // Crear un título con el nombre del mes y el año
        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};        Label title = new Label(monthNames[month - 1] + " " + year);
        this.getChildren().add(title);

        // Crear los días del mes
        GridPane daysGrid = new GridPane();
        daysGrid.setHgap(5);
        daysGrid.setVgap(5);

        // Añadir los nombres de los días de la semana
        String[] dayNames = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
        for (int i = 0; i < dayNames.length; i++) {
            Label dayLabel = new Label(dayNames[i]);
            daysGrid.add(dayLabel, i, 0);
        }

        // Obtener el primer día del mes y el número de días en el mes
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        int firstDayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        // Añadir los días del mes al GridPane
        int row = 1;
        int col = firstDayOfWeek;
        for (int day = 1; day <= daysInMonth; day++) {
            Label dayLabel = new Label(String.valueOf(day));
            daysGrid.add(dayLabel, col, row);
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }

        // Añadir el GridPane al VBox
        this.getChildren().add(daysGrid);
    }

    public IntegerProperty monthProperty() {
        return monthProperty;
    }

    public IntegerProperty yearProperty() {
        return yearProperty;
    }
}