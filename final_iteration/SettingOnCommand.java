

public class SettingOnCommand implements Command {
	View view;
	public SettingOnCommand(View view) {
		this.view=view;
	}
	public void execute() {
		view.on();
	}
}
