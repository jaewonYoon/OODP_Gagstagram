


public class RemoteControl {
	    Command[] OnCommands;
	    //Command[] OffCommand;
	    public RemoteControl() {
	    	OnCommands=new Command[2];
	    	//OffCommand=new Command[2];
	    }
	    
	    public void setCommand(int slot, Command OnCommand) {
	    	OnCommands[slot]= OnCommand;
	    	}
	    
	    public void OnButtonPressed(int slot) { 
	    	OnCommands[slot].execute(); 
	    	}

}
