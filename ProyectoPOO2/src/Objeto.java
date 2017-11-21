
public class Objeto {
	private String nombre;
	private int precio;
	private int numeroPiezas;
	
	public Objeto(String nombre, int precio, int piezas){
		this.precio= precio;
		this.nombre = nombre;
		this.numeroPiezas = piezas;
	}
	public void agregarArticulos(int articulos){
		this.numeroPiezas+= articulos;
	}
	public void restarArticulos(int articulos){
		this.numeroPiezas -= articulos;	
	}
	

	public int getNumeroPiezas() {
		return numeroPiezas;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
