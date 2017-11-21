import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	private PanelBotones pb;
	private PanelGraficas pg;
	private PanelBotonesObjeto pbo;
	private PanelInventario pi;
	
	public Ventana(){
		super("Inventario");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		this.pbo = new PanelBotonesObjeto();
		this.add(this.pbo,BorderLayout.WEST);
		
		this.pi = new PanelInventario(pbo);
		this.add(this.pi, BorderLayout.EAST);
		
		this.pg = new PanelGraficas();
		this.add(this.pg, BorderLayout.SOUTH);
		
		this.pb = new PanelBotones(this.pi);
		this.add(this.pb, BorderLayout.CENTER);
		this.pbo.setPi(pi);
		this.pb.setPbo(pbo);
		
		this.pack();
		
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ventana();

	}

}
