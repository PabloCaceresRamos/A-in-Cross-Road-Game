package pablocaceres982.Automata;

import core.game.StateObservation;
import ontology.Types;
import pablocaceres982.Coordenadas;
import pablocaceres982.*;


public class Automata {

	private SuperNodo [] Nodos;
	
	private int NodoActual;
	private int vecesDefendida;
	
	public Automata() {
		
		Nodos=new SuperNodo[3];
		Nodos[0]=new AvanzarSinMeta();
		Nodos[1]=new Esperar();
		Nodos[2]=new Avanzar();
		NodoActual=0;
		 vecesDefendida = 0;
	}
	
	public Types.ACTIONS Accion(StateObservation Ob,Coordenadas Avatar){
		
		Transicion[] transiciones=Nodos[NodoActual].gettransiciones();//nos devuelve todas las transiciones disponibles
		for (int i = 0; i < transiciones.length; i++) {
			if(transiciones[i].cumpleDisparador(Ob, Avatar)) {//si alguna cumple se hace
				NodoActual=transiciones[i].getTransicion();
				break;
			}
		}
		return Nodos[NodoActual].Accion(Ob, Avatar);
	}
}
