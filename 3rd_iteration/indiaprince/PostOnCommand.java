
public class PostOnCommand implements Command {
	Post post;
	public PostOnCommand(Post post) {
		this.post=post;
	}
	public void execute() {
		post.On();
	}
	
}
