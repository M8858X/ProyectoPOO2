import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBotones extends JPanel{

	private JTextField 	tfindex,
						tfmenos,
						tfmas;
	
	private JLabel lbindex,
					lbmenos,
					lbmas;
	
	private JButton btsumar,
					btrestar;
	private PanelInventario pi;
	private PanelBotonesObjeto pbo;

	public PanelBotones(PanelInventario pi){
		super(new GridLayout (4,2));
		this.setPreferredSize(new Dimension(160,170));
		this.pi = pi;

		this.lbindex = new JLabel("Index:");
		this.add(this.lbindex);
			
		this.tfindex = new JTextField();
		this.add(this.tfindex);
			
		this.lbmas = new JLabel("Más:");
		this.add(this.lbmas);
			
		this.tfmas = new JTextField();
		this.add(this.tfmas);
			
		this.lbmenos = new JLabel("Menos");
		this.add(this.lbmenos);
			
		this.tfmenos = new JTextField();
		this.add(this.tfmenos);
		
		this.btsumar = new JButton("Agregar");
		this.btsumar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(tfindex.getText()) > pbo.getNum()||Integer.valueOf(tfindex.getText())<1){
					JOptionPane.showMessageDialog(null, "Objeto no registado \nIndex fuera de rango");
				}else{
					PanelBotones.this.pi.sumarArticulos(Integer.valueOf(tfindex.getText())-1, Integer.valueOf(tfmas.getText()));
				}
			}
			
		});
		this.add(this.btsumar);
			
		this.btrestar = new JButton("Quitar");
		this.btrestar.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(tfindex.getText()) > pbo.getNum()||Integer.valueOf(tfindex.getText())<1){
					JOptionPane.showMessageDialog(null, "Objeto no registado \nIndex fuera de rango");
				}else{
				PanelBotones.this.pi.restarArticulos(Integer.valueOf(tfindex.getText())-1, Integer.valueOf(tfmenos.getText()));
				}
			}
			
		});
		this.add(this.btrestar);
			
	}
	public void setPbo(PanelBotonesObjeto pbo) {
		this.pbo = pbo;
	}
}
