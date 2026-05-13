module com.jogo {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jogo to javafx.fxml;
    exports com.jogo;

    opens com.jogo.Controller to javafx.fxml;
    exports com.jogo.Controller;
}
