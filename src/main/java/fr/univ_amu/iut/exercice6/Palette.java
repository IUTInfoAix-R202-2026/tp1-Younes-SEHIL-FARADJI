package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Exercice 6 - Palette de couleurs (capstone).
 *
 * <p>Dernier exercice du TP : synthèse des concepts vus jusqu'ici (layout, boutons, événements,
 * mise à jour d'un label) sur une petite application autonome.
 *
 * <h3>Comportement attendu</h3>
 *
 * <pre>
 * ┌──────────────────────────────┐
 * │ [Rouge] [Vert] [Bleu]        │  ← HBox de 3 boutons
 * ├──────────────────────────────┤
 * │                              │
 * │     (zone de couleur)        │  ← Pane "#zone" dont le fond change
 * │                              │
 * ├──────────────────────────────┤
 * │ Rouge: 0  Vert: 0  Bleu: 0   │  ← Label "#compteurs"
 * └──────────────────────────────┘
 * </pre>
 *
 * <p>Chaque clic sur un bouton :
 *
 * <ul>
 *   <li>change la couleur de fond de la zone centrale ;
 *   <li>incrémente le compteur correspondant dans le label du bas.
 * </ul>
 *
 * <p>Les trois compteurs sont indépendants : cliquer "Rouge" n'affecte pas les compteurs "Vert" et
 * "Bleu".
 */
public class Palette extends Application {
  private int compteurRouge = 0;
  private int compteurVert = 0;
  private int compteurBleu = 0;

  @Override
  public void start(Stage primaryStage) {
    // TODO exercice 6 : implémenter la palette décrite dans la Javadoc.
    //
    // Stratégie conseillée :
    //
    // 1. Créer un BorderPane comme racine.
    //
    // 2. Top : un HBox avec trois boutons "Rouge", "Vert", "Bleu".
    // Donne-leur les ids "btn-rouge", "btn-vert", "btn-bleu" - les tests
    // les retrouvent via robot.lookup("#btn-rouge") etc.
    //
    // 3. Center : un Pane avec l'id "zone", taille minimale 300×200.
    // Change sa couleur via setStyle("-fx-background-color: red;") etc.
    //
    // 4. Bottom : un Label avec l'id "compteurs", texte initial
    // "Rouge: 0 Vert: 0 Bleu: 0".
    //
    // 5. Trois entiers compteur_rouge, compteur_vert, compteur_bleu
    // (ou trois variables d'instance). Chaque clic incrémente le bon
    // compteur et reformate le texte du label.
    //
    // 6. Attention au format du texte du label : les tests vérifient la
    // présence exacte des substrings "Rouge: 2", "Vert: 0", "Bleu: 1"
    // après une séquence de clics.
    BorderPane borderPane = new BorderPane();

    HBox hboxBoutons = new HBox();
    Button btnRouge = new Button("Rouge");
    btnRouge.setId("btn-rouge");
    Button btnVert = new Button("Vert");
    btnVert.setId("btn-vert");
    Button btnBleu = new Button("Bleu");
    btnBleu.setId("btn-bleu");
    hboxBoutons.getChildren().addAll(btnRouge, btnVert, btnBleu);
    borderPane.setTop(hboxBoutons);
    Pane zoneCouleur = new Pane();
    zoneCouleur.setId("zone");
    zoneCouleur.setMinSize(300, 200);
    borderPane.setCenter(zoneCouleur);
    Label labelCompteurs = new Label("Rouge: 0  Vert: 0  Bleu: 0");
    labelCompteurs.setId("compteurs");
    borderPane.setBottom(labelCompteurs);
    btnRouge.setOnAction(
        e -> {
          compteurRouge++;
          zoneCouleur.setStyle("-fx-background-color: red;");
          labelCompteurs.setText(
              "Rouge: " + compteurRouge + "  Vert: " + compteurVert + "  Bleu: " + compteurBleu);
        });
    btnVert.setOnAction(
        e -> {
          compteurVert++;
          zoneCouleur.setStyle("-fx-background-color: green;");
          labelCompteurs.setText(
              "Rouge: " + compteurRouge + "  Vert: " + compteurVert + "  Bleu: " + compteurBleu);
        });
    btnBleu.setOnAction(
        e -> {
          compteurBleu++;
          zoneCouleur.setStyle("-fx-background-color: blue;");
          labelCompteurs.setText(
              "Rouge: " + compteurRouge + "  Vert: " + compteurVert + "  Bleu: " + compteurBleu);
        });
    Scene scene = new Scene(borderPane, 400, 350);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Palette de couleurs");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
