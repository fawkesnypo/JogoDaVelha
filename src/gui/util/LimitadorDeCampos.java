package gui.util;

import javafx.scene.control.TextField;

public class LimitadorDeCampos {
	
	public static void textFieldLimiter(TextField text) {
		text.textProperty().addListener((obs,oldValue,newValue) ->{
			if (newValue!=null && newValue.length()>8) {
				text.setText(oldValue);
			}
		}
		);
		
	}

}
