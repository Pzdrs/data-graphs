package me.pzdrs.dataGraphs;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public VBox content;
    private List<Person> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            data = Utils.parseCVS(new File(getClass().getResource("/data.csv").getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showPie() {
        content.getChildren().clear();
        PieChart chart = new PieChart();
        data.forEach(person -> chart.getData().add(new PieChart.Data(person.getName() + " IQ: " + person.getIq(), person.getIq())));
        content.getChildren().add(chart);
    }

    public void showBar() {
        content.getChildren().clear();

        StackedBarChart<String, Number> chart = new StackedBarChart<>(new CategoryAxis(), new NumberAxis());
        chart.setCategoryGap(50);

        data.forEach(person -> {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.getData().add(new XYChart.Data<>(person.getName(), person.getIq()));
            chart.getData().add(series);
        });

        content.getChildren().add(chart);
    }

    public void showData() {
        content.getChildren().clear();

        TableView<Person> table = new TableView<>();
        TableColumn<Person, String> name = new TableColumn<>("Jmeno");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Person, Double> iq = new TableColumn<>("IQ");
        iq.setCellValueFactory(new PropertyValueFactory<>("iq"));

        table.getColumns().addAll(Arrays.asList(name, iq));
        table.setItems(FXCollections.observableList(data));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        content.getChildren().add(table);
    }
}
