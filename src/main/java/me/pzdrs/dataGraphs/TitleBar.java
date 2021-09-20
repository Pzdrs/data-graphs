package me.pzdrs.dataGraphs;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TitleBar implements Initializable {
    public BorderPane titleBar;
    public FontAwesomeIconView close, minimize;
    public FontAwesomeIconView resize;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            titleBar.setPrefWidth((Double) newValue);
        });
    }

    public void close() {
        Main.stage.close();
    }

    public void minimize() {
        Main.stage.setIconified(true);
    }

    public void maximize() {
        if (Main.stage.isMaximized()) {
            Main.stage.setMaximized(false);
            resize.setGlyphName("WINDOW_MAXIMIZE");
        } else {
            Main.stage.setMaximized(true);
            resize.setGlyphName("WINDOW_RESTORE");
        }
    }
}
