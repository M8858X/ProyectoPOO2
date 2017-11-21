import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBotonesObjeto extends JPanel{
	private JTextField tfnombre,
						tfprecio,
						tfcantidad,
						tfindex;
	private JLabel lbnombre,
					lbprecio,
					lbcantidad,
					lbindex;

	private JButton btagregar,
				btquitar;
	private PanelInventario pi;
	private int num;

	public PanelBotonesObjeto(){
		super(new GridLayout(5,2));
		this.setPreferredSize(new Dimension(160,170));
		this.num = 0;
		
		this.lbnombre = new JLabel("Nombre:");
		this.add(this.lbnombre);
			
		this.tfnombre = new JTextField();
		this.add(this.tfnombre);
			
		this.lbprecio = new JLabel("Precio");
		this.add(this.lbprecio);
			
		this.tfprecio = new JTextField();
		this.add(this.tfprecio);
			
		this.lbcantidad = new JLabel("Cantidad");
		this.add(this.lbcantidad);
			
		this.tfcantidad = new JTextField();
		this.add(this.tfcantidad);
		
		this.lbindex = new JLabel("Index");
		this.add(this.lbindex);
		
		this.tfindex = new JTextField();
		this.add(this.tfindex);
			
		this.btagregar = new JButton("Agregar");
		this.btagregar.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			if(tfnombre.getText().equals("")||tfcantidad.getText().equals("")||tfprecio.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
			}else{
				try{
				pi.agregarArticulo(new Objeto(tfnombre.getText(), Integer.parseInt(tfcantidad.getText()),Integer.parseInt(tfprecio.getText())));
				num++;
				}catch(NumberFormatException e2){
					JOptionPane.showMessageDialog(null, "Tienes que ingresar un numero");
				}
			}
		}
			
		});
		this.add(this.btagregar);
			
		this.btquitar = new JButton("Quitar");
		this.btquitar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				if(Integer.parseInt(tfindex.getText())>num||Integer.parseInt(tfindex.getText())<1){
					JOptionPane.showMessageDialog(null, "Objeto no registado \nIndex fuera de rango");
				}else{
				pi.quitarArticulo(Integer.parseInt(tfindex.getText())-1);
				num--;
			}
			}
		});
		this.add(this.btquitar);
		
	
	}
	public void setPi(PanelInventario pi) {
		this.pi = pi;
	}
	public int getNum() {
		return num;
	}
}
