package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	int grado=0;
	String parolagradomax;
Graph<String,DefaultEdge> grafo;
List<String> listafinale;


	public void createGraph(int numeroLettere) {
       grafo=new SimpleGraph<>(DefaultEdge.class);
       WordDAO dao=new WordDAO();
       listafinale=dao.getAllWordsFixedLength(numeroLettere);
       Graphs.addAllVertices(grafo, listafinale);
       for(int i=0;i<listafinale.size();i++) {
    	   for(int y=i+1;y<listafinale.size();y++)
    	   {
    		   if(this.confrontalettere(listafinale.get(y), listafinale.get(i))) {grafo.addEdge(listafinale.get(y), listafinale.get(i));}
    	   }
       }
       
       
		System.err.println(grafo.vertexSet().size());
	}
	public boolean confrontalettere(String a,String b) {
		int flag=0;
		for(int k=0;k<a.length();k++) {
			if(a.charAt(k)==b.charAt(k)) {} else {flag++;}
		}
		if(flag==1) return true;
		else return false;
	}
	public String getparolagradomax() {
		return parolagradomax;
	}
	

	public List<String> displayNeighbours(String parolaInserita) {

	
		
		return Graphs.neighborListOf(grafo, parolaInserita);
	}

	public int findMaxDegree() {
	   for(String s:listafinale) {
		   if(grafo.degreeOf(s)>grado) {parolagradomax=s; grado=grafo.degreeOf(s);}
	   }
		return grado;
	}
}
