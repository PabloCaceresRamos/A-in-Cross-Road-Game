package pablocaceres982.Automata;

import java.util.ArrayList;

import core.game.Observation;
import core.game.StateObservation;
import pablocaceres982.Coordenadas;
import pablocaceres982.*;

import tools.Vector2d;

public class TMetaEncontrada extends Transicion {

	public TMetaEncontrada() {
		sA = 2;
	}
	//Transicion de Defender a cazar
	public boolean cumpleDisparador(StateObservation Ob, Coordenadas Avatar) {
	//Se Busca a la meta, y si no se encuentra se devuelve false																										
		ArrayList<Observation>[][] ao=Ob.getObservationGrid();
		Coordenadas meta=null;
		for (int i = 1; i < ao.length-1; i++) {
			if(ao[i][1].size()>0 && ao[i][1].get(0).itype==4) {//si la celda no esta vacia y su tipo es el de la meta
				meta=new Coordenadas(i,1);
			}
		}
		 
		if(meta==null )	return false;
		else return true;
																											
	}

	public int getTransicion() {// nos devuelve la posicion del nodo al que pasamos
		return sA;
	}

}
