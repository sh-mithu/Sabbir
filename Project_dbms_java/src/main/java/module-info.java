module com.example.project_dbms_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires java.mail;
    requires activation;
    requires java.desktop;
    requires jdk.internal.le;
    requires mysql.connector.java;


    //requires java.datatransfer;
    //requires javax.servlet.api;


    opens com.example.project_dbms_java to javafx.fxml;
    exports com.example.project_dbms_java;
}