import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.*;    
import javax.swing.*;   

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.event.GraphEvent.Vertex;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationServer.Paintable;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class MyFrame extends JFrame
{
	

	private JPanel panel;
	private JTextField txtField;
	private JButton findButton;
	private JButton visualizeButton;
	private JTextField diameter;
	
	
	public MyFrame(ArrayList<Suspect> sus,ArrayList<Communication>comm) 
	{	
		panel = new JPanel();
		txtField = new JTextField("Please enter suspect's name");
		findButton = new JButton("Find");
		visualizeButton = new JButton("visualize Network");
		diameter = new JTextField(35);		
		
		
		
		panel.add(txtField);
		panel.add(findButton);		
		panel.add(visualizeButton);
		
		
		visualizeButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						Graph<String, String> g = new SparseMultigraph<String,String>();
						
					
						for(Suspect suss: sus)
						{	
							g.addVertex(suss.getCodeName());
						}
						
						float count=0;
						int counter=0;
						
						for(Suspect s : sus)
						{
							for(Suspect ss : sus)
							{	
								if(s.isConnectedTo(ss))
								{	
									
										counter++;
										String str = Integer.toString(counter); 
									
										String combine = s.getCodeName().concat(ss.getCodeName());
										String combine2 = ss.getCodeName().concat(s.getCodeName());
										
										
										if(!g.containsEdge(combine) & !g.containsEdge(combine2))
										{
											g.addEdge(combine, s.getCodeName(),ss.getCodeName());
											
											if(g.outDegree(s.getCodeName())>count)
											{
												count=g.outDegree(s.getCodeName());
												
												diameter.setText("Diameter = "+Float.toString(count));
												
											}
										}
										
								}
								
							}
						}

						
						
						
						Layout<Integer, String> layout = new CircleLayout(g);
						layout.setSize(new Dimension(300,300)); // sets the initial size of the space
						BasicVisualizationServer<Integer,String> vv = new BasicVisualizationServer<Integer,String>(layout);
						vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size

												
						vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
						
						JFrame frame = new JFrame("Simple Graph View");
						frame.setLayout(new BorderLayout());
						frame.add(vv,BorderLayout.NORTH);
						
						
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.pack();
						frame.setVisible(true);
							
						frame.add(diameter,BorderLayout.SOUTH);						
						
						
						
					}
			
				});
		
		
		
		findButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtField.getText();			
				for(Suspect sus1 : sus)
				{
					if(name.equalsIgnoreCase(sus1.getName()))
					{
						panel.setVisible(false);
						new suspectsPage(sus1,sus,comm);
					}
//					TODO: fix warning pop up window
//					else 
//					{
//						JOptionPane.showMessageDialog(MyFrame.this, "User " + name + " not found", "Message", JOptionPane.ERROR_MESSAGE);
//					}		
				}
			}
		});
		
		
		this.setContentPane(panel);
		
		this.setSize(600,600);
		this.setTitle("Find Suspect");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
}

