package it.uniroma3.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.uniroma3.model.Studente;

public class StudenteServices {
	
	public void save(Studente stud) {
		//TODO
	}
	
	public List<Studente> listaStudenti(){
		//TODO
		Studente studente = new Studente();
		List<Studente> collection = new ArrayList<>();
		studente.setNome("Cri");
		studente.setCognome("Mon");
		studente.setMatricola(new Integer("489813"));
		
		collection.add(studente);
		
		Studente studente2 = new Studente();
		studente2.setNome("St1");
		studente2.setCognome("St1");
		studente2.setMatricola(new Integer("000000"));
		
		collection.add(studente2);
		
		return collection;
	}
	
}
