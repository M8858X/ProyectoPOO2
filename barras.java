import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.util.*;



public class barras extends JFrame {
	
	static JTextField tx1;
	static JTextField tx2;
	static JTextField tx3;
	static JButton btVer;
	static JLabel Imagen;
	static JLabel c1;
	static JLabel c2;
	static JLabel c3;
	
	public barras() {
		super("Grafica");
		setLayout(null);
		Container c = getContentPane();
		evento e = new evento();
		
		tx1 = new JTextField();
		tx1.setBounds(80, 50, 70, 30);
		
		tx2 = new JTextField();
		tx2.setBounds(80, 100, 70, 30);
		
		tx3 = new JTextField();
		tx3.setBounds(80, 150, 70, 30);
		
		btVer = new JButton("Ver");
		btVer.setBounds(80, 200, 80, 30);
		btVer.addActionListener(e);
		
		Imagen = new JLabel();
		Imagen.setBounds(200,200,500,500);
		
		c1 = new JLabel("Napoleon");
		c1.setBounds(20, 50, 40, 30);
		
		c2 = new JLabel("Chepina");
		c2.setBounds(20, 100, 40, 30);
		
		c3 = new JLabel("Ken Bauer");
		c3.setBounds(20, 150, 40, 30);
		
		c.add(tx1);
		c.add(tx2);
		c.add(tx3);
		c.add(btVer);
		c.add(Imagen);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void pintar() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue(c1.getText() , Integer.parseInt(tx1.getText()));
		dataset.setValue(c2.getText() , Integer.parseInt(tx2.getText()));
		dataset.setValue(c3.getText() , Integer.parseInt(tx3.getText()));
		
		JFreeChart grafica = ChartFactory.createBarChart("Title", "lo", "yi", (CategoryDataset) dataset);
				
		BufferedImage bri = grafica.createBufferedImage(400, 400);
		ImageIcon img = new ImageIcon(bri);
		Imagen.setIcon(img);
		
		ChartFrame frame = new ChartFrame("Graficador", grafica);
		frame.pack();
		
		
	}

	public static void main(String[] args) {
		
		barras v = new barras();
		v.setVisible(true);

	}
	
	private class evento implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			
			if(ev.getSource().equals(btVer)) {
				pintar();
			}			
		}
	}
	

}
