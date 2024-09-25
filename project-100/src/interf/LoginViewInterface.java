package interf;

import java.awt.event.ActionListener;

public interface LoginViewInterface {
	String getUsername();

	String getPassword();

	void addLoginButtonListener(ActionListener listener);

	void showError(String message);
}
