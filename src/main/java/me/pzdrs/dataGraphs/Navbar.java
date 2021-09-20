package me.pzdrs.dataGraphs;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import me.pzdrs.dataGraphs.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class Navbar implements Initializable {
    public AnchorPane navbar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            navbar.setPrefHeight((Double) newValue);
        });
    }

    public void showPie() {
        Main.controller.showPie();
    }

    public void showBar() {
        Main.controller.showBar();
    }

    public void showData() {
        Main.controller.showData();
    }
}
