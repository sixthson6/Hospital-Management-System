module manage.hospital {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens manage.hospital to javafx.fxml;
    exports manage.hospital;
}
