package pablocaceres982.Automata;

import java.util.ArrayList;

import core.game.Observation;
import core.game.StateObservation;
import pablocaceres982.Coordenadas;
import pablocaceres982.*;

import tools.Vector2d;

public class TMetaNoEncontrada extends Transicion {
	

	
	public TMetaNoEncontrada() {
		sA=0;
	}
	//Se busca la mata y si se encuentra se devuelve false
	public boolean cumpleDisparador(StateObservation Ob,Coordenadas Avatar) {
		
		ArrayList<Observation>[][] ao=Ob.getObservationGrid();
		Coordenadas meta=null;
		for (int i = 1; i < ao.length-1; i++) {
			if(ao[i][1].size()>0 && ao[i][1].get(0).itype==4) {//si la celda no esta vacia y su tipo es el de la meta
				meta=new Coordenadas(i,1);
			}
		}
		 
		if(meta==null )	return true;
		else return false;
	}
	
	public int getTransicion() {//nos devuelve la posicion del nodo al que pasamos
		return sA;
	}
	
	
}
