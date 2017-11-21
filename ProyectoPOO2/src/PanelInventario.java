import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelInventario extends JPanel{
	private int y;
	private PanelBotonesObjeto pbo;
	public Objeto[] objetos;
	
	public PanelInventario(PanelBotonesObjeto pbo){
		super(new GridLayout(14,3));
		this.setPreferredSize(new Dimension(620,170));
		this.setBackground(Color.LIGHT_GRAY);
		this.objetos = new Objeto[30];
		this.pbo = pbo;
		this.y = 15;
	
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("No.", 5, 15);
		g.drawString("Nombre", 35, 15);
		g.drawString("Cantidad", 260, 15);
		g.drawString("Precio", 540, 15);
		
		for(int i = 0; i< objetos.length ; i++){
			if(objetos[i] == null){
				break;
			}else{
			g.drawString(String.valueOf(i+1), 5, 30+this.y*i);
			g.drawString(objetos[i].getNombre(), 35, 30 + this.y*i);
			g.drawString(String.valueOf(objetos[i].getNumeroPiezas()), 260, 30 +this.y*i);
			g.drawString("$"+String.valueOf(objetos[i].getPrecio()), 540, 30 + this.y*i);
			}
		}
	
	}
	public void agregarArticulo(Objeto a){
		for(int i = 0; i<objetos.length; i++){
			if(objetos[i]== null){
				
				objetos[i]= a;
				this.repaint();
				break;
			}
		}
	}
	public void quitarArticulo(int index){
			objetos[index]= null;
			for(int i= index;i<objetos.length-1;i++){
				if(objetos[i+1]==null){
					break;
				}else{
					objetos[i] = objetos[i+1];
					objetos[i+1]=null;
				}
		}
		this.repaint();
	}
	public void sumarArticulos(int index, int mas){
		if(mas<=0){
			JOptionPane.showMessageDialog(null, "No puedes agregar cantidades negativas");
		}else{
			objetos[index].agregarArticulos(mas);
			this.repaint();
		}
		
	}
	public void restarArticulos(int index, int menos){
		if(menos>objetos[index].getNumeroPiezas() || menos<=0 ){
			JOptionPane.showMessageDialog(null, "No puedes quitar más de lo que se tiene\nNo se puede quitar cantidades negativas");
		}else{
		objetos[index].restarArticulos(menos);
		this.repaint();
		}
	}

}
