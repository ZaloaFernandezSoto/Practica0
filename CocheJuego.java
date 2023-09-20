package ventanas;

public class CocheJuego extends Coche{
	private JLabelCoche labelCoche;
	
	public CocheJuego() {
		super();
		labelCoche= new JLabelCoche();
		labelCoche.setLocation((int) posX, (int) posY);
	}

	public JLabelCoche getLabelCoche() {
		return labelCoche;
	}

	public void setPosicion(double x, double y) {
		posX= x;
		posY= y;
		labelCoche.setLocation((int) posX, (int) posY);
	}
	
	@Override
    public void acelera(double aceleracion) {
        super.acelera(aceleracion);
        
        System.out.println("Nueva velocidad: " + miVelocidad);
    }

    @Override
    public void frena(double freno) {
        super.frena(freno);
        
        System.out.println("Nueva velocidad: " + miVelocidad);
    }

    @Override
    public void gira(double giro) {
        super.gira(giro);
       
        System.out.println("Nueva dirección: " + miDireccionActual);
    }

    @Override
    public void mueve(double tiempoDeMovimiento) {
        super.mueve(tiempoDeMovimiento);
       
    }
    

}
