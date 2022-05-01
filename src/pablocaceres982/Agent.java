package pablocaceres982;

import java.util.ArrayList;
import java.util.Random;
import core.game.Observation;
import core.game.StateObservation;
import core.player.AbstractPlayer;
import ontology.Types;
import ontology.Types.ACTIONS;
import tools.ElapsedCpuTimer;
import tools.Vector2d;

/**
 * Created with IntelliJ IDEA. User: ssamot Date: 14/11/13 Time: 21:45 This is a
 * Java port from Tom Schaul's VGDL - https://github.com/schaul/py-vgdl
 */
public class Agent extends AbstractPlayer {
	
	protected Random randomGenerator;
	
	protected ArrayList<Types.ACTIONS> actions;
	
	private AEstrella aE;
	private Vector2d posAvatarInicialPixel;
	private Coordenadas posAvatarCeldas;


	
	public Agent(StateObservation so, ElapsedCpuTimer elapsedTimer) {
		randomGenerator = new Random();
		actions = so.getAvailableActions();
		aE=new AEstrella();
		Vector2d v=so.getAvatarPosition();
		posAvatarInicialPixel=new Vector2d(v.x,v.y);//Esto lo usaremos para saber cuando ha vuelto a la posicion inicial

		
	}

	/**
	 * Picks an action. This function is called every game step to request an action
	 * from the player.
	 * 
	 * @param stateObs     Observation of the current state.
	 * @param elapsedTimer Timer when the action returned is due.
	 * @return An action for the current state
	 */
	
	
	
	
	
	
	

	//@SuppressWarnings({ "rawtypes", "unchecked" })
	public Types.ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {
		
		
		
		/*Primero vamos a determinar la posicion del avatar, pare ello utilizaremos su posicion en pixeles*/
		Vector2d v=stateObs.getAvatarPosition();
		if(posAvatarInicialPixel.y==v.y && posAvatarInicialPixel.x==v.x) {
			
			posAvatarCeldas=new Coordenadas(13,13);//En el inicio lo pondremos en su posicion inicial
		}
		else if(posAvatarInicialPixel.y==v.y) {

			posAvatarCeldas=new Coordenadas((int)v.x/stateObs.getBlockSize(),13);//Cuando muere lo colocamos en la fila 13 y calculamos la columna
		}
		/*****/
		
		/*Miro en toda la fila 1 hasta que aparezcca la meta*/
		ArrayList<Observation>[][] ao=stateObs.getObservationGrid();
		Coordenadas meta=null;
		for (int i = 1; i < ao.length-1; i++) {
			if(ao[i][1].size()>0 && ao[i][1].get(0).itype==4) {//si la celda no esta vacia y su tipo es el de la meta
				meta=new Coordenadas(i,1);
			}
		}
		/*
		 * He dotado al avatar de dos opciones para que haga mientras espera la bandera
		 * Si esperar==true ---> espera en el punto inicial hasta que la bandera aparezca
		 * Si esperar==false --> avanza hasta la primera fila, y espera en esa fila hasta que aparezca la bandera
		 */
		boolean esperar=false; 
		if(meta==null ) {
			if(esperar)
				return ACTIONS.ACTION_NIL;
			if(!esperar)
			meta=new Coordenadas(13,1);
		}
		/*****/
		
		/*Una vez se encuentre la posicion de la meta, llamamos al A* para que deduzca el mejor movimiento*/
		//else {
		
			Types.ACTIONS ac=aE.selectActions(stateObs, meta, posAvatarCeldas);
			this.posAvatarCeldas=posAvatarCeldas.posicionFutura(ac);
			return ac;
		/*****/
		//}

	}

}
