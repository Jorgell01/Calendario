# CalendarioApp

CalendarioApp es una aplicación JavaFX que muestra un calendario con la capacidad de navegar a través de diferentes años. La aplicación utiliza un componente personalizado `MonthCalendar` para mostrar cada mes en un diseño de cuadrícula.

## Características

- Mostrar un calendario para todo el año.
- Navegar a través de los años usando botones de anterior y siguiente.
- Diseño responsivo que se ajusta al tamaño de la ventana.

## Requisitos

- Java 22 o superior
- Maven 3.6.0 o superior

## Estructura del Proyecto

- `src/main/java/dad/calendario/app/CalendarioApp.java`: Clase principal de la aplicación.
- `src/main/java/dad/calendario/controllers/RootController.java`: Controlador para el diseño principal.
- `src/main/java/dad/calendario/model/MonthCalendar.java`: Componente personalizado para mostrar un mes.
- `src/main/resources/fxml/RootController.fxml`: Diseño FXML para la ventana principal.
- `src/main/resources/images/calendar-16x16.png`: Icono para la aplicación.

## Cómo Ejecutar

1. **Clonar el repositorio:**

    ```sh
    git clone https://github.com/yourusername/CalendarioApp.git
    cd CalendarioApp
    ```

2. **Compilar el proyecto:**

    ```sh
    mvn compile
    ```

3. **Ejecutar la aplicación:**

    ```sh
    mvn exec:java
    ```

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.
