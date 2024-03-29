package lab3.Ex2;

public class Reserva {
	 private ClassPlane classe;
	    private int nPassageiros;

	    public Reserva(ClassPlane classe, int nPassageiros) {
	        this.nPassageiros = nPassageiros;
	        this.classe = classe;
	    }

	    public int getnPassageiros() {
	        return nPassageiros;
	    }

	    public void setnPassageiros(int nPassageiros) {
	        this.nPassageiros = nPassageiros;
	    }

	    public ClassPlane getClassName() {
	        return this.classe;
	    }

	    public void setClasse(ClassPlane classe) {
	        this.classe = classe;
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((classe == null) ? 0 : classe.hashCode());
	        result = prime * result + nPassageiros;
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Reserva other = (Reserva) obj;
	        if (classe != other.classe)
	            return false;
	        if (nPassageiros != other.nPassageiros)
	            return false;
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "Reserva [classe=" + classe + ", nPassageiros=" + nPassageiros + "]";
	    }

}
