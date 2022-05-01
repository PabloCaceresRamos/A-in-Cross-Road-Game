package pablocaceres982.Automata;

import java.util.ArrayList;

import core.game.Observation;
import core.game.StateObservation;
import ontology.Types;
import ontology.Types.ACTIONS;
import pablocaceres982.Coordenadas;
import pablocaceres982.*;
import tools.Vector2d;

public class AvanzarSinMeta extends SuperNodo {

	private Transicion[] Transiciones;
	private AEstrella AE;
	
	
	//nodo del automata encargado de perseguir a la presa
	public AvanzarSinMeta() {
		super();
		Transiciones= new Transicion[]{new TMetaEncontrada(),new TUltimaFilaNoMeta()};
		AE=new AEstrella();
			
	}
	
	public Types.ACTIONS Accion(StateObservation Ob,Coordenadas Avatar){
		System.out.println("avanza sin meta");
		Coordenadas meta=new Coordenadas(13,1);
		
		return AE.selectActions(Ob, meta, Avatar);
	
	}
	
	public Transicion[] gettransiciones() {
		return this.Transiciones;
	}
	
	
}
