package com.example;

// import java.util.Scanner;

// public class App 
// {
//     public static void main( String[] args )
//     {
//         // System.out.println( "Hello World!" );
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Кубын ирмэг: ");
//         double side = scanner.nextDouble();
//         Cube cube = new Cube(side);
//         System.out.printf("Кубын талбай: %.1f\n", cube.calculateSquare());
//         System.out.printf("Кубын эзэлхүүн: %.1f\n",  cube.calculateVolume());
//         // System.out.println("Кубын эзэлхүүн: " + cube.calculateVolume());
//         scanner.close();
//     }
// }

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("Кубын талбай болон эзэлхүүн тооцоологч");
        
        Label inputLabel = new Label("Кубын ирмэгийн урт (а):");
        TextField inputField = new TextField();
        inputField.setPromptText("Тоо оруулна уу...");

        Button calculateButton = new Button("Тооцоолох");
        
        // Үр дүн харуулах лабелууд
        Label lblSquare = new Label("Гадаргуугийн талбай (S): -");
        Label lblVolume = new Label("Эзэлхүүн (V): -");

        // Товчлуур дээр дарах үед ажиллах функц
        calculateButton.setOnAction(e -> {
            try {
                // Текст талбараас утгыг авч тоо руу хөрвүүлэх
                double edge = Double.parseDouble(inputField.getText());

                if (edge <= 0) {
                    lblSquare.setText("Гадаргуугийн талбай (S): -");
                    lblVolume.setText("Эзэлхүүн (V): -");
                } else {
                    
                    // Томьёоны дагуу бодох
                    Cube cube = new Cube(edge);
                    double sq = cube.calculateSquare();
                    double volume = cube.calculateVolume();

                    // Үр дүнг таслахаас хойш 2 орноор нарийвчилж харуулах
                    lblSquare.setText(String.format("Гадаргуугийн талбай (S): %.2f", sq));
                    lblVolume.setText(String.format("Эзэлхүүн (V): %.2f", volume));
                }
            } catch (NumberFormatException ex) {
                lblSquare.setText("Гадаргуугийн талбай (S): -");
                lblVolume.setText("Эзэлхүүн (V): -");
            }
        });

        // Элементүүдийг босоо байдлаар байршуулах (VBox)
        VBox root = new VBox(12); // Элементүүд хоорондоо 12px зайтай байна
        root.setPadding(new Insets(20)); // Цонхны захнаас авах зай
        root.setAlignment(Pos.CENTER_LEFT); // Зүүн тал руу нь зэрэгцүүлнэ
        
        // Бүх элементийг VBox дотор нэмэх
        root.getChildren().addAll(
            titleLabel, 
            inputLabel, 
            inputField, 
            calculateButton, 
            lblSquare, 
            lblVolume
        );

        // Сэнтий (Scene) үүсгэж цонхонд тохируулах
        Scene scene = new Scene(root, 350, 300);
        stage.setScene(scene);
        stage.setTitle("Куб Тооцоологч");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
