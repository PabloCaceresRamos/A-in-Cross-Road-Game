package pablocaceres982;

import ontology.Types;

public class Coordenadas {
/* Clase que contiene toda la informacion de cada celda del mapa*/
	
	private int x;
	private int y;
	private int DistanciaCeldas;//numero de celdas que hay desde esta coordenada a la meta
	private int tipo;//Tipo del objeto que hay en la celda
	private int numpasos;//numero de pasos que hay que dar para llegar aqui
	private int costeTotal;//numero de pasos+distanciaCeldas, es para el A*
	private Coordenadas anterior;//Celda por la que llegamos a esta
	
	/*"Movimiento" guarda el primer paso que se dio para hacer el camino, si de la posicion del avatar se coge a la izquierda, todo el 
	 * camino hasta finalizar tendra el String "izquierda"*/
	private String Movimiento;
	
	
	
	Coordenadas(int x,int y){
		this.x=x;
		this.y=y;
		this.numpasos=-1;
		this.DistanciaCeldas=-1;
		this.costeTotal=-1;
		this.anterior=null;
	}
	
	Coordenadas(int x,int y,int tipo){
		this.x=x;
		this.y=y;
		this.tipo=tipo;
		this.numpasos=-1;
		this.DistanciaCeldas=-1;
		this.costeTotal=-1;
		this.anterior=null;
		
	}
	
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	public int getDistC() {
		return this.DistanciaCeldas;
	}
	public int getCosteTotal() {
		return this.costeTotal;
	}
	public int getTipo() {
		return this.tipo;
	}
	public Coordenadas getAnterior() {
		return this.anterior;
	}
	public int getPasosDados() {
		return this.numpasos;
	}
	public String getMovimiento() {
		return this.Movimiento;
	}
	
	
	public void SetDist(int x2,int y2) {
		this.DistanciaCeldas= Math.abs(x2-x)+Math.abs(y2-y);
	}
	
	public void SetDist(Coordenadas m) {
		this.DistanciaCeldas=Math.abs(m.x-x)+Math.abs(m.y-y);
	}
	public void setNumPasos(int p) {
		if(DistanciaCeldas==-1) System.out.println("Clacula primero la distancia");
		else {
			this.numpasos=p;
			this.costeTotal=numpasos+DistanciaCeldas;
		}
	}
	public void setMovimiento(String M) {
		this.Movimiento=M;
	}
	public void setAnterior(Coordenadas a) {
		this.anterior=a;
	}
	
	/* "posicionFutura" recibe un string, que es la accion que se hace, segun la accion devuelve la coordenada a la que se pasaria*/
	public Coordenadas posicionFutura(String act) {
		if(act=="Izquierda") return new Coordenadas(x-1,y);
		if(act=="Derecha") return new Coordenadas(x+1,y);
		if(act=="Arriba") return new Coordenadas (x,y-1);
		if(act=="Abajo") return new Coordenadas (x,y+1);
		else return null;
		}
	
	/*"posicionFutura" recibe una accion y devuelve la coordenada a la que se pasaria */
	public Coordenadas posicionFutura(Types.ACTIONS act) {
		if(act.toString().equals("ACTION_LEFT")) return new Coordenadas(x-1,y);
		if(act.toString().equals("ACTION_RIGHT"))  return new Coordenadas(x+1,y);
		if(act.toString().equals("ACTION_UP")) return new Coordenadas (x,y-1);
		if(act.toString().equals("ACTION_DOWN"))  return new Coordenadas (x,y+1);
		if(act.toString().equals("ACTION_NIL"))  return new Coordenadas (x,y);
		else return null;
	}
	
	
	public boolean equal(Coordenadas c) {
		return(x==c.x &&y==c.y);
	}
	public String toString() {
		return "x: "+this.x+"  y: "+this.y;
	}
	
	
	
	
}
