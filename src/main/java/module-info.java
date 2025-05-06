module manage.hospital {
    requires javafx.controls;
    requires javafx.fxml;

    opens manage.hospital to javafx.fxml;
    exports manage.hospital;
}
