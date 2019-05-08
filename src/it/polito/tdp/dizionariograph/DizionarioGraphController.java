package it.polito.tdp.dizionariograph;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
  Model modello;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField finestranumlettere;

    @FXML
    private TextField finestraparoladacercare;

    @FXML
    private Button bottonegenera;

    @FXML
    private Button bottonetrovavicini;

    @FXML
    private Button doTrovaGradoMax;

    @FXML
    private TextArea arearisultato;

    @FXML
    private Button bottonereset;

    @FXML
    void doGeneraGrafo(ActionEvent event) {
    	int num=Integer.parseInt(finestranumlettere.getText());
    	modello.createGraph(num);
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	finestranumlettere.clear();
    	finestraparoladacercare.clear();
    	arearisultato.clear();

    }

    @FXML
    void doTrovaVicini(ActionEvent event) {
    	int a=Integer.parseInt(finestranumlettere.getText());
    	String parola=finestraparoladacercare.getText();
    	if(parola.length()!=a) {arearisultato.setText("La parola deve essere della stessa lunghezza!");}
    	else {
    		List<String> parole=modello.displayNeighbours(parola);
    		for(String s:parole) {
    			arearisultato.appendText(""+s+"\n");
    		}
    		int grado=modello.findMaxDegree();
    		arearisultato.appendText("La parola con grado massimo è: "+modello.getparolagradomax()+" "+"e il grado è: "+grado);
    		
    	}

    }

    @FXML
    void initialize() {
        assert finestranumlettere != null : "fx:id=\"finestranumlettere\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert finestraparoladacercare != null : "fx:id=\"finestraparoladacercare\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert bottonegenera != null : "fx:id=\"bottonegenera\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert bottonetrovavicini != null : "fx:id=\"bottonetrovavicini\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert doTrovaGradoMax != null : "fx:id=\"doTrovaGradoMax\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert arearisultato != null : "fx:id=\"arearisultato\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert bottonereset != null : "fx:id=\"bottonereset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }

	public void setModel(Model m) {
		modello=m;
		
	}
}
