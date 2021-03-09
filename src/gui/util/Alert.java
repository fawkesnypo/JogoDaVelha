package gui.util;

import javafx.scene.control.Alert.AlertType;

public class Alert {

	public static void showAlert(String title, String header, String content, AlertType type) {
		javafx.scene.control.Alert alert = new javafx.scene.control.Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
}
