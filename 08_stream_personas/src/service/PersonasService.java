package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Persona;

public class PersonasService {
	List<Persona> personas = new ArrayList<>();

	public PersonasService() {
		personas.add(new Persona("Alex", "al@gg.com", 20));
		personas.add(new Persona("Juan", "alfd@gg.com", 29));
		personas.add(new Persona("Elena", "al@gg.es", 17));
		personas.add(new Persona("Marta", "alaaoi@gg.com", 34));
		personas.add(new Persona("Lucas", "alert@gg.es", 44));
		personas.add(new Persona("Alicia", "sdfl@gg.com", 35));
		personas.add(new Persona("Marta", "solp@dw.es", 50));
		personas.add(new Persona("Santiago", "solp@dw.net", 45));
	}

	// persona mas joven
	public Persona obtenerMasJoven() {
		return personas
				.stream()
				.min((n1, n2) -> n1.getEdad() - n2.getEdad())
				.orElse(null);
	}

	// el numero de personas cuya edad es superior a la media
	public int superiorMedia() {
		// sin crear una variable
		double edadMedia = personas
				.stream()
				.mapToDouble(p -> p.getEdad())
				.average()
				.orElse(0);

		// creando una variable de tipo stream
		Stream<Persona> personasStream1 = personas.stream();
		return personasStream1
				.filter(p -> p.getEdad() > edadMedia)
				.collect(Collectors.toList()).size();
	}

	// personas ordenadas por edad
	public List<Persona> ordenadasPorEdad() {
		return personas
				.stream()
				.sorted((p1, p2) -> p1.getEdad() - p2.getEdad())
				.collect(Collectors.toList());
	}

	// lista nombres de personas
	public List<String> nombres() {
		return personas
				.stream()
				.map(p -> p.getNombre())
				.collect(Collectors.toList());
	}

	// dominio sea igual al indicado
	public List<Persona> personasDominio(String dominio) {
		return personas
				.stream()
				.filter(p -> p.getEmail().endsWith(dominio))
				.collect(Collectors.toList());
	}
	
	public Set<Persona> personasEdadSuperiorValor(int edad) {
		return personas
				.stream()
				.filter(p -> p.getEdad() > edad)
				.collect(Collectors.toSet());
	}
	
	public Map<String, Persona> personasOrdenadasClaveEmail() {
		return personas
				.stream()
				.collect(Collectors.toMap(p -> p.getEmail(), p -> p));
	}
	
	public Map<String, List<Persona>> personasAgrupadasPorDominio() {
		return personas
				.stream()
				.collect(Collectors.groupingBy(p -> p.getEmail().split("[.]")[1]));
	}

}
