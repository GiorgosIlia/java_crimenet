import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class suspectsPage extends JFrame{
	
	private JTextField nameArea;
	private JTextField codenameArea;
	private JTextField numberArea;
	private JTextField numberArea2;
	private DefaultListModel<String> listmodel;
	private JList<String> messages;
	private JTextArea phoneNumber;
	private JButton findSmsButton;
	private JButton back;
	private JPanel panel;
	private DefaultListModel<String> listmodel2;
	private JList<String> partners;
	private ArrayList<Suspect> susss = new ArrayList<Suspect>();
	
	public suspectsPage(Suspect s1,ArrayList<Suspect> sus,ArrayList<Communication>comm) 
	{
		panel = new JPanel();
		nameArea = new JTextField(s1.getName());
		codenameArea = new JTextField(s1.getCodeName());
		numberArea = new JTextField(s1.getNumList().toString());
		listmodel = new DefaultListModel<>();
		phoneNumber = new JTextArea(5,5);
		numberArea2 = new JTextField(s1.getNumList().toString());
		messages = new JList<String>(listmodel);
		findSmsButton = new JButton("Find SMS");
		back = new JButton("Back to search screen");
		listmodel2 = new DefaultListModel<String>();
		partners = new JList<String>(listmodel2);
		
		
		panel.add(nameArea);
		panel.add(codenameArea);
		panel.add(numberArea);
		panel.add(phoneNumber);
		panel.add(numberArea2);
		panel.add(messages);
		panel.add(findSmsButton);
		panel.add(back);
		panel.add(partners);
		
		
		
		
		
		for(Suspect sus1 : sus)
		{
			if(sus1.isConnectedTo(s1))
			{
				listmodel2.addElement(sus1.getName()+ " " +sus1.getCodeName());
			}
		}
		
	back.addActionListener(new ActionListener () 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
				new MyFrame(sus, comm);
		}		
	});
	
	findSmsButton.addActionListener(new ActionListener()
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{			
			String susPhone = phoneNumber.getText();
			for(Communication com : comm)
			{ 
				if(susPhone.equals(com.getCaller()) || susPhone.equals(com.getReceiver()))
				{
					for(String s: s1.getNumList())
					{
						if(com.getCaller().contentEquals(s) || com.getReceiver().contentEquals(s) )
						{
							listmodel.addElement(com.getMessage());		
						}
							
					}
				}
			} 
		}
	});
		
		this.setContentPane(panel);
		

		
		this.setSize(400, 400);
		this.setTitle("Suspect's Page");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
