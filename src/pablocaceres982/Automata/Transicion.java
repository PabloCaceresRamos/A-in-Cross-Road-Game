package pablocaceres982.Automata;

import core.game.StateObservation;
import pablocaceres982.Coordenadas;
import pablocaceres982.*;


public class Transicion {//Padre de todas las transiciones utilizadas
	
	public int sA;//nodo al que se pasa
	
	public boolean cumpleDisparador(StateObservation Ob,Coordenadas Avatar) 
	{//nos dice si se cumple la condicion
		System.out.println("metodo Clase Transicion");
		return false;
	}
	public int getTransicion() {//nos devuelve el nodo al que pasamos
		System.out.println("metodo Clase Transicion");
		return -1;
	}
	
	
}
