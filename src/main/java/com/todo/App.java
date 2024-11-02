package com.todo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {

        /* Layout */
        VBox layout = new VBox(10);
        layout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        layout.setPadding(new Insets(20, 0, 0, 0));

        /* Titulo do TODO */
        Text titulo_do_app = new Text("TODO by Joao");
        titulo_do_app.setFont(Font.font("Consolas", 20));
        

        /* Input da tarefa */
        TextField input = new TextField();
        input.setPromptText("Tarefas");
        input.setPrefWidth(500);
        input.setMaxWidth(500);

        /* Adicionar Tarefa */
        Button button = new Button("Adicionar Tarefa");
        button.setOnAction(e -> {

            /* Pega a tarefa */
            String tarefa = new String(input.getText());

            if (!(input.getText().isEmpty())) {

                input.setText(""); // retira o conteudo do input
            
                /* Cria uma hbox */
                HBox area_botao = new HBox();      // HBOX
                area_botao.setAlignment(javafx.geometry.Pos.CENTER);
    

                /* Cria o titulo (um botao) */
                Button titulo = new Button(tarefa);
                titulo.setOnAction(f -> {
                    input.setText(titulo.getText());
                    layout.getChildren().remove(area_botao);
                });
                titulo.setPrefWidth(500);
    

                /* Cria o botao de check */
                Button marcar = new Button("OK");
                marcar.setPrefWidth(35);
                marcar.setOnAction(g -> {
                    if (titulo.isDisabled()) {
                        titulo.setDisable(false);
                    } else {
                        titulo.setDisable(true);
                    }
                });

                /* Cria o botao de excluir */
                Button excluir = new Button("Excluir");
                marcar.setPrefWidth(45);
                excluir.setOnAction(h -> layout.getChildren().remove(area_botao));
    
                area_botao.getChildren().add(titulo);
                area_botao.getChildren().add(marcar);
                area_botao.getChildren().add(excluir);
    
                layout.getChildren().add(area_botao);
            }
        }        
        );

        /* ADICIONANDO OS NODES */
        layout.getChildren().add(titulo_do_app);
        layout.getChildren().add(input);
        layout.getChildren().add(button);

        Scene cena = new Scene(layout, 800, 600);
        stage.setTitle("Aplicativo TODO");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}