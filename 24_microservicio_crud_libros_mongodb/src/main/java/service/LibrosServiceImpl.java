package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Libro;
import repository.LibrosMongoRepository;

@Service
public class LibrosServiceImpl implements LibrosService {
	@Autowired
	LibrosMongoRepository repository;

	@Override
	public List<Libro> todosLibros() {
		return repository.findAll();
	}

	@Override
	public List<Libro> librosPorTematica(String tematica) {
		return repository.findByTematica(tematica);
	}

	@Override
	public Libro libroIsbn(int isbn) {
		return repository.findByIsbn(isbn);
	}

	@Override
	public void nuevoLibro(Libro libro) {
		repository.save(libro);
	}

	@Override
	public void actualizarLibro(Libro libro) {
		repository.save(libro);
	}

	@Override
	public void eliminarLibro(int isbn) {
		repository.deleteByIsbn(isbn);
	}

}
