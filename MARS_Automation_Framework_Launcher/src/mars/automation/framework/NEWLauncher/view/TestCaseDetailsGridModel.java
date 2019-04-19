package mars.automation.framework.NEWLauncher.view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TestCaseDetailsGridModel {

	// private final String testCaseDescription;

	private SimpleStringProperty Name;
	private SimpleBooleanProperty Check;

	public TestCaseDetailsGridModel(Boolean checked, String name) {
		Check = new SimpleBooleanProperty(checked);
		Name = new SimpleStringProperty(name);

	}

	public String getName() {
		return Name.get();
	}

	public Boolean getCheck() {
		return Check.get();
	}

	public void setCheck(SimpleBooleanProperty check) {
		Check = check;
	}

	public void setName(SimpleStringProperty name) {
		Name = name;
	}

}
