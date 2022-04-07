package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientChat extends Application {
	private PrintWriter pw;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)throws Exception{
        primaryStage.setTitle("Client");
        var borderPane = new BorderPane();
        var hostField = new TextField("localhost");
        var portField = new TextField("1234");
        var scene = new Scene(borderPane,800,600);
        var button = new Button("Connecter");
        var hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));
        var vBox = new VBox();
        ObservableList<String> listModel = FXCollections.observableArrayList();
        var listView = new ListView<String>(listModel);
        vBox.getChildren().add(listView);
        borderPane.setCenter(vBox);
        hBox.getChildren().addAll(
            new Label("Host"),
            hostField,
            new Label("Port"),
            portField,
            button
        );
        borderPane.setTop(hBox);
        var messageField = new TextField();
        messageField.setPrefSize(400, 30);
        var envoyer = new Button("Envoyer");
        var hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.setPadding(new Insets(10));
        hBox2.getChildren().addAll(
        	new Label("Message : "),
        	messageField,
        	envoyer
        );
        borderPane.setBottom(hBox2);
        envoyer.setOnAction((e)->{
        	var message = messageField.getText();
        	pw.println(message);
        });
        button.setOnAction((event)->{
            var host = hostField.getText();
            var port = Integer.parseInt(portField.getText());
            try {
                var socket = new Socket(host,port);
                var br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                pw = new PrintWriter(socket.getOutputStream(),true);
                new Thread(()->{
            		while(true){
            			try {
                			var text = br.readLine();
                			Platform.runLater(()->{
                				listModel.add(text);
                			});
            			}catch(Exception e) {}
            		}                		
                }).start();
            } catch (Exception e) {
                
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
