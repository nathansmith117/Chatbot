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
		
		layout = new SpringLayout();
		
		menuPanel = new JPanel(new GridLayout(0, 1));
		buttonPanel = new JPanel(new GridLayout(2, 0));
		
		chatPane = new JScrollPane();
		chatArea = new JTextArea();
		chatField = new JTextField();
		
		spookyCheckerButton = new JButton("Spooky checker");
		timeDateCheckerButton = new JButton("Time date checker");
		isValidHTMLCheckerButton = new JButton("HTML checker");
		translateToPigLatinButton = new JButton("Translate to pig latin");
		findSmallestWordButton = new JButton("Find smallest word");
		reversePronounDirectionButton = new JButton("Reverse pronoun direction");
		tellInsultingJokeButton = new JButton("Tell insulting joke");
		talkToKarlMarxButton = new JButton("Talk to Karl Marx");
		computerScienceResponseButton = new JButton("Computer science stuff");
		holidayResponseButton = new JButton("Hoiday stuff");
		
		saveButton = new JButton("save");
		loadButton = new JButton("load");
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		setLayout(layout);
		setBackground(Color.DARK_GRAY);
		
		chatPane.setViewportView(chatArea);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatArea.setEnabled(false);
		
		this.add(chatPane);
		this.add(menuPanel);
		
		menuPanel.add(chatField);
		menuPanel.add(buttonPanel);
		
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(spookyCheckerButton);
		buttonPanel.add(timeDateCheckerButton);
		buttonPanel.add(isValidHTMLCheckerButton);
		buttonPanel.add(translateToPigLatinButton);
		buttonPanel.add(findSmallestWordButton);
		buttonPanel.add(reversePronounDirectionButton);
		buttonPanel.add(tellInsultingJokeButton);
		buttonPanel.add(talkToKarlMarxButton);
		buttonPanel.add(computerScienceResponseButton);
		buttonPanel.add(holidayResponseButton);
	}
	
	private void setupListeners()
	{
		spookyCheckerButton.addActionListener(click -> updateDisplay(chatField.getText(), 0));
		timeDateCheckerButton.addActionListener(click -> updateDisplay(chatField.getText(), 1));
		isValidHTMLCheckerButton.addActionListener(click -> updateDisplay(chatField.getText(), 2));
		translateToPigLatinButton.addActionListener(click -> updateDisplay(chatField.getText(), 3));
		findSmallestWordButton.addActionListener(click -> updateDisplay(chatField.getText(), 4));
		reversePronounDirectionButton.addActionListener(click -> updateDisplay(chatField.getText(), 5));
		tellInsultingJokeButton.addActionListener(click -> updateDisplay(chatField.getText(), 6));
		talkToKarlMarxButton.addActionListener(click -> updateDisplay(chatField.getText(), 7));
		computerScienceResponseButton.addActionListener(click -> updateDisplay(chatField.getText(), 8));
		holidayResponseButton.addActionListener(click -> updateDisplay(chatField.getText(), 9));
		
		saveButton.addActionListener(click -> app.save());
		loadButton.addActionListener(click -> loadText());
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, chatPane, 25, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, chatPane, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, menuPanel, 25, SpringLayout.SOUTH, chatPane);
		layout.putConstraint(SpringLayout.EAST, menuPanel, 0, SpringLayout.EAST, chatPane);
		layout.putConstraint(SpringLayout.WEST, menuPanel, 0, SpringLayout.WEST, chatPane);
		layout.putConstraint(SpringLayout.SOUTH, menuPanel, -25, SpringLayout.SOUTH, this);
	}
	
	private void updateDisplay(String text, int choice)
	{
		String response = app.interactWithChatbot(text, choice);
		
		chatArea.append(text + "\n");
		chatArea.append(response + "\n");
		chatArea.setCaretPosition(chatArea.getDocument().getLength());
		chatField.setText("");
	}
	
	private void loadText()
	{
		String text = app.loadText();
		chatArea.setText(text);
	}
}
