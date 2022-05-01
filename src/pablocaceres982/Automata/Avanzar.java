package pablocaceres982.Automata;

import java.util.ArrayList;

import core.game.Observation;
import core.game.StateObservation;
import ontology.Types;
import ontology.Types.ACTIONS;
import pablocaceres982.Coordenadas;
import pablocaceres982.*;
import tools.Vector2d;

public class Avanzar extends SuperNodo {

	private Transicion[] Transiciones;
	private AEstrella AE;
	
	
	//nodo del automata encargado de perseguir a la presa
	public Avanzar() {
		super();
		Transiciones= new Transicion[]{new TMetaNoEncontrada()};
		AE=new AEstrella();
			
	}
	
	public Types.ACTIONS Accion(StateObservation Ob,Coordenadas Avatar){
		
		System.out.println("avanza");
		ArrayList<Observation>[][] ao=Ob.getObservationGrid();
		Coordenadas meta=null;
		for (int i = 1; i < ao.length-1; i++) {
			if(ao[i][1].size()>0 && ao[i][1].get(0).itype==4) {//si la celda no esta vacia y su tipo es el de la meta
				meta=new Coordenadas(i,1);
			}
		}
		
		return AE.selectActions(Ob, meta, Avatar);
	
	}
	
	public Transicion[] gettransiciones() {
		return this.Transiciones;
	}
	
	
}
