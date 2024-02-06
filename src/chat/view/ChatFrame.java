package chat.view;

import chat.controller.Controller;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private Controller app;
	private ChatPanel panel;
	
	public ChatFrame(Controller app)
	{
		super();
		this.app = app;
		this.panel = new ChatPanel(this.app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		setContentPane(panel);
		setSize(1027, 768);
		setTitle("Chatbot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
