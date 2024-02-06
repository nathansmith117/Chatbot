package chat.view;

import chat.controller.Controller;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Color;

public class ChatPanel extends JPanel
{
	private Controller app;
	
	private JButton spookyCheckerButton;
	private JButton timeDateCheckerButton;
	private JButton isValidHTMLCheckerButton;
	private JButton translateToPigLatinButton;
	private JButton findSmallestWordButton;
	private JButton reversePronounDirectionButton;
	private JButton tellInsultingJokeButton;
	private JButton talkToKarlMarxButton;
	private JButton computerScienceResponseButton;
	private JButton holidayResponseButton;
	
	private SpringLayout layout;
	
	private JScrollPane chatPane;
	private JTextArea chatArea;
	private JTextField chatField;
	
	private JButton saveButton;
	private JButton loadButton;
	
	private JPanel menuPanel;
	private JPanel buttonPanel;
	
	public ChatPanel(Controller app)
	{
		super();
		this.app  = app;
		
		setupPanel();
		setupListeners();
		setupLayout();
		
		layout = new SpringLayout();
		
		menuPanel = new JPanel(new GridLayout(0, 1));
		buttonPanel = new JPanel(new GridLayout(2, 0));
		
		chatPane = new JScrollPane();
		chatArea = new JTextArea();
		chatField = new JTextField();
		
		saveButton = new JButton("save");
		loadButton = new JButton("load");
	}
	
	private void setupPanel()
	{
		setLayout(layout);
		setBackground(Color.DARK_GRAY);
		
		this.add(menuPanel);
		
		menuPanel.add(chatField);
		menuPanel.add(buttonPanel);
		
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		
	}
}
