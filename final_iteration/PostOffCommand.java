
public class PostOffCommand {
	Post post;
	public PostOffCommand(Post post) {
		this.post=post;
	}
	public void execute() {
		post.Off();
	}
	
}
