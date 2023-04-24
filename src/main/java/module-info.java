module at.technikum.mvvm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.hibernate.orm.core;
    requires java.naming;
    requires jakarta.persistence;

    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens at.technikum.mvvm.dto to com.fasterxml.jackson.databind;

    opens at.technikum.mvvm.model to org.hibernate.orm.core;

    opens at.technikum.mvvm to javafx.fxml;
    opens at.technikum.mvvm.view to javafx.fxml;
    exports at.technikum.mvvm;
    opens at.technikum.mvvm.repository to org.hibernate.orm.core;
}