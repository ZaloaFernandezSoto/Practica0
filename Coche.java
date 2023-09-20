package ventanas;

public class Coche {
	protected double miVelocidad;
	protected double miDireccionActual;
	protected double posX;
	protected double posY;
	protected String piloto;
	
	public Coche() {
		this.miVelocidad=0.0;
		this.miDireccionActual=0.0;
		this.posX=  300.0;
		this.posY= 300.0;
		this.piloto= "";	
	}

	public double getMiVelocidad() {
		return miVelocidad;
	}

	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}

	public double getMiDireccionActual() {
		return miDireccionActual;
	}

	public void setMiDireccionActual(double dir) {
		 if (dir < 0.0) {
	            dir += 360.0;
	        }
	        if (dir > 360.0) {
	            dir -= 360.0;
	        }
		this.miDireccionActual = dir;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public void setPosicion(final double posX, final double posY) {
	    this.setPosX(posX);
	    this.setPosY(posY);
	    }
	    
	
	public void acelera( double aceleracion) {
		this.miVelocidad += aceleracion;
	}
	public void frena( double freno) {
		this.miVelocidad= 0;
		
	}
	public void gira( double giro) {
		this.setMiDireccionActual(this.miDireccionActual + giro);
	}
	public void mueve( double tiempoDeMovimiento) {
		this.setPosX(this.posX + this.miVelocidad * Math.cos(this.miDireccionActual / 180.0 * 3.141592653589793) * tiempoDeMovimiento);
        this.setPosY(this.posY + this.miVelocidad * -Math.sin(this.miDireccionActual / 180.0 * 3.141592653589793) * tiempoDeMovimiento);
	}


    @Override
    public String toString() {
        return String.valueOf(this.piloto) + " (" + this.posX + "," + this.posY + ") - " + "Velocidad: " + this.miVelocidad + " ## Direcci\u00f3n: " + this.miDireccionActual;
    }
    
	
}
	