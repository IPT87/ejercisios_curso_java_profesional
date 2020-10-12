package model;

public class Tema {
	   private int idTema;
	   private String tema;

	    public Tema() {
		super();
	}

		public Tema(int idTema, String tema) {
	        this.idTema = idTema;
	        this.tema = tema;
	    }

	    public int getIdTema() {
	        return idTema;
	    }

	    public void setIdTema(int idTema) {
	        this.idTema = idTema;
	    }

	    public String getTema() {
	        return tema;
	    }

	    public void setTema(String tema) {
	        this.tema = tema;
	    }

	    @Override
	    public String toString() {
	        return tema;
	    }
	   
	}
