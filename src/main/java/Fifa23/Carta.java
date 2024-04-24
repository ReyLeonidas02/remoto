package Fifa23;

public class Carta {
	
	private String nombre;
	private int cod_jugador;
	private int rat;
	private String pos;
	private int precio;
	private int pac;
	private int sho;
	private int pas;
	private int dri;
	private int def;
	private int phy;
	private int pierna_mala;
	private int filigranas;
	
	public Carta(String nombre, int cod_jugador, int rat, String pos, int precio, int pac, int sho, int pas, int dri,
			int def, int phy, int pierna_mala, int filigranas) {
		super();
		this.nombre = nombre;
		this.cod_jugador = cod_jugador;
		if(rat>=0||rat<=99) {
			this.rat = rat;
		}else {
			this.rat = (Integer) null;
		}
		this.pos = pos;
		this.precio = precio;
		if(pac>=0||pac<=99) {
			this.pac = pac;
		}else {
			this.pac = (Integer) null;
		}
		if(sho>=0||sho<=99) {
			this.sho = sho;
		}else {
			this.sho = (Integer) null;
		}
		if(pas>=0||pas<=99) {
			this.pas = pas;
		}else {
			this.pas = (Integer) null;
		}
		if(dri>=0||dri<=99) {
			this.dri = dri;
		}else {
			this.dri = (Integer) null;
		}
		if(def>=0||def<=99) {
			this.def = def;
		}else {
			this.def = (Integer) null;
		}
		if(phy>=0||phy<=99) {
			this.phy = phy;
		}else {
			this.phy = (Integer) null;
		}
		if(pierna_mala>=0||pierna_mala<=5) {
			this.pierna_mala = pierna_mala;
		}else {
			this.pierna_mala = (Integer) null;
		}
		if(filigranas>=0||filigranas<=5) {
			this.filigranas = filigranas;
		}else {
			this.filigranas = (Integer) null;
		}
	}

	public Carta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCod_jugador() {
		return cod_jugador;
	}

	public void setCod_jugador(int cod_jugador) {
		this.cod_jugador = cod_jugador;
	}

	public int getRat() {
		return rat;
	}

	public void setRat(int rat) {
		if(rat>=0||rat<=99) {
			this.rat = rat;
		}else {
			this.rat = (Integer) null;
		}
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPac() {
		return pac;
	}

	public void setPac(int pac) {
		if(pac>=0||pac<=99) {
			this.pac = pac;
		}else {
			this.pac = (Integer) null;
		}
	}

	public int getSho() {
		return sho;
	}

	public void setSho(int sho) {
		if(sho>=0||sho<=99) {
			this.sho = sho;
		}else {
			this.sho = (Integer) null;
		}
	}

	public int getPas() {
		return pas;
	}

	public void setPas(int pas) {
		if(pas>=0||pas<=99) {
			this.pas = pas;
		}else {
			this.pas = (Integer) null;
		}
	}

	public int getDri() {
		return dri;
	}

	public void setDri(int dri) {
		if(dri>=0||dri<=99) {
			this.dri = dri;
		}else {
			this.dri = (Integer) null;
		}
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		if(def>=0||def<=99) {
			this.def = def;
		}else {
			this.def = (Integer) null;
		}
	}

	public int getPhy() {
		return phy;
	}

	public void setPhy(int phy) {
		if(phy>=0||phy<=99) {
			this.phy = phy;
		}else {
			this.phy = (Integer) null;
		}
	}

	public int getPierna_mala() {
		return pierna_mala;
	}

	public void setPierna_mala(int pierna_mala) {
		if(pierna_mala>=0||pierna_mala<=5) {
			this.pierna_mala = pierna_mala;
		}else {
			this.pierna_mala = (Integer) null;
		}
	}

	public int getFiligranas() {
		return filigranas;
	}

	public void setFiligranas(int filigranas) {
		if(filigranas>=0||filigranas<=5) {
			this.filigranas = filigranas;
		}else {
			this.filigranas = (Integer) null;
		}
	}

	@Override
	public String toString() {
		return "Carta [nombre=" + nombre + ", cod_jugador=" + cod_jugador + ", rat=" + rat + ", pos=" + pos
				+ ", precio=" + precio + ", pac=" + pac + ", sho=" + sho + ", pas=" + pas + ", dri=" + dri + ", def="
				+ def + ", phy=" + phy + ", pierna_mala=" + pierna_mala + ", filigranas=" + filigranas + "]";
	}
	
	public String colorCarta (int valor) {
		if(valor<=49){
			return "red";
		}else if(valor>=50&&valor<=59) {
			return "orange";
		}else if(valor>=60&&valor<=69) {
			return "#f4f413";
		}else if(valor>=70&&valor<=89) {
			return "#03b50c";
		}else {
			return "#005904";
		}
	}
	
	public String longitudCarta (int valor) {
		if(valor<=49){
			return "60px";
		}else if(valor>=50&&valor<=59) {
			return "120px";
		}else if(valor>=60&&valor<=69) {
			return "180px";
		}else if(valor>=70&&valor<=89) {
			return "240px";
		}else {
			return "300px";
		}
	}

}
