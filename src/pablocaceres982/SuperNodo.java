package pablocaceres982;

import core.game.StateObservation;
import ontology.Types;
import ontology.Types.ACTIONS;
import pablocaceres982.Coordenadas;
import pablocaceres982.Automata.Transicion;

public class SuperNodo {
/*
 * Esta clase es la padre de todos los nodos de la maquina de estados para poder trabajar con herencias. Tambien es el padre de
 * la clase Arbol.
 */


public SuperNodo() {
	
}

public Types.ACTIONS Accion(StateObservation Ob,Coordenadas Avatar){
	//Esta funcion solo la va a hacer el nodo Raiz
	System.out.println("Metodo de SuperArbol");
	return null;
}


public Transicion[] gettransiciones() {
	System.out.println("Metodo de SuperArbol");
	return null;
}
}
