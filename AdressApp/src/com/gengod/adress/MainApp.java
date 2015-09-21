package com.gengod.adress;/**
 * Created by gener on 19.09.2015.
 */

import java.io.IOException;

import com.gengod.adress.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AdressApp");

        initRootLayout();

        showPersonOwerview();
    }

    public void initRootLayout()
    {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showPersonOwerview()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOwner.fxml"));
            AnchorPane personOwerview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOwerview);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp()
    {
        personData.add(new Person("Hans", "Muller"));
        personData.add(new Person("Barry", "Bones"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    public ObservableList<Person> getPersonData()
    {
        return personData;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
