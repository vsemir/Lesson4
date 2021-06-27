package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

    public class Controller {

        Game game = new Game();
        int n = 0;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button blowButton;

        @FXML
        private Button resetButton;

        @FXML
        private Button giveUpButton;

        @FXML
        private ImageView backgraund;

        @FXML
        private ImageView player;

        @FXML
        private ImageView enemy;

        @FXML
        private TextArea infoButtle;

        @FXML
        private TextArea infoGame;

        @FXML
        private TextArea console;

        @FXML
        void initialize() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, game.getIntro());
            alert.showAndWait();
            resetButton.setOnAction(event -> {
                game = new Game();
                infoButtle.setText(null);
                infoButtle.setText("HP Player - " + game.getHpPlayer() + "\n" + "Def Player - " + game.getDefPlayer() + "\n" + "Dmg Player - " + game.getDmgPlayer() +
                        "\n\n" + "HP Enemy - " + game.getHpEnemy() + "\n" + "Def Enemy - " + game.getDefEnemy() + "\n" + "Dmg Enemy - " + game.getDmgEnemy()
                        + "\n");
                infoGame.setText(null);
                infoGame.setText("Point - " + game.getPoint());
                console.setText(null);
            });
            giveUpButton.setOnAction(event -> Platform.exit());
            infoGame.setText("Point - " + game.getPoint());
            infoButtle.setText("HP Player - " + game.getHpPlayer() + "\n" + "Def Player - " + game.getDefPlayer() + "\n" + "Dmg Player - " + game.getDmgPlayer() +
                    "\n\n" + "HP Enemy - " + game.getHpEnemy() + "\n" + "Def Enemy - " + game.getDefEnemy() + "\n" + "Dmg Enemy - " + game.getDmgEnemy() + "\n");
        }

        public void blowAction(ActionEvent event) {


            if (game.getHpPlayer() > 0){
                if (!game.getMessage().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, game.getMessage());
                    alert.showAndWait();
                    game.setMessage("");
                }
                if (game.getHpPlayer() <= 0){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы проиграли! у вас " + game.getPoint() + " очков");
                    alert.showAndWait();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION, game.getRoomInfo());
                alert.showAndWait();

                game.expPlayer();
                game.battle();

                console.setText( console.getText() + "\n" + n++ + ". " + game.getMessage() + game.getRoomInfo() +"\nВраг побежден");

                infoButtle.setText(null);
                infoButtle.setText("HP Player - " + game.getHpPlayer() + "\n" + "Def Player - " + game.getDefPlayer() + "\n" + "Dmg Player - " + game.getDmgPlayer() +
                        "\n\n" + "HP Enemy - " + game.getHpEnemy() + "\n" + "Def Enemy - " + game.getDefEnemy() + "\n" + "Dmg Enemy - " + game.getDmgEnemy()
                        + "\n");
                infoGame.setText(null);
                infoGame.setText("Point - " + game.getPoint());
            }else {
                console.setText(console.getText() + "Игра окончена! Очков получено - " + game.getPoint() + "\n");
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы проиграли! у вас " + game.getPoint() + " очков");
                alert.showAndWait();
            }


            console.setWrapText(true);
            console.setScrollTop(Double.MAX_VALUE);

        }


    }
