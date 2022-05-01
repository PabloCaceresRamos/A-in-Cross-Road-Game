package pablocaceres982.Automata;

import java.util.ArrayList;

import core.game.Observation;
import core.game.StateObservation;
import ontology.Types;
import ontology.Types.ACTIONS;
import pablocaceres982.Coordenadas;
import pablocaceres982.*;

import tools.Vector2d;

public class Esperar extends SuperNodo {

	
	private Transicion[] Transiciones;
	
	public Esperar() {
		super();
		Transiciones= new Transicion[]{new TMetaEncontrada2()};
		
	}
	
	public Types.ACTIONS Accion(StateObservation Ob,Coordenadas Avatar){
		System.out.println("espera");
		return ACTIONS.ACTION_NIL;
		
	}
	
	
	

	public Transicion[] gettransiciones() {
		return this.Transiciones;
	}

	
}
