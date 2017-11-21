import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelGraficas extends JPanel{
	
	private PanelInventario pi;
	private JLabel Imagen;
	
	
	public PanelGraficas(PanelInventario pi){
		super();
		this.setPreferredSize(new Dimension(960,270));
		
		this.Imagen = new JLabel();
		this.setBounds(0, 0, 920, 230);
		this.add(this.Imagen);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		//for(int i = 0; i pi.objetos.length ; i++){
			//if(pi.objetos[i] == null){
				//break;
			//}else{
				//dataset.setValue(pi.objetos[i].getNombre(),pi.objetos[i].getNumeroPiezas());
			//}
		//}
		JFreeChart grafica = ChartFactory.createPieChart3D("Grafica", dataset, true, true, false);
		BufferedImage bri = grafica.createBufferedImage(400, 400);
		ImageIcon img = new ImageIcon(bri);
		Imagen.setIcon(img);
		
	}	
	public void repintarGraficas(){
		this.repaint();
	}
}
