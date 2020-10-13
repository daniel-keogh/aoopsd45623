package ie.gmit.legacy;

public enum County {
	Cork			("C", "Corcaigh"), 
	Clare			("CE", "An Clár"), 
	Cavan			("CN", "An Cabhán"), 
	Carlow			("CW", "Ceatharlach"),
	Dublin			("D", "Baile Átha Cliath"), 
	Donegal			("DL", "Dún na nGall"), 
	Galway			("G", "Gaillimh"),
	Kildare			("KE", "Cill Dara"), 
	Kilkenny		("KK", "Cill Chainnigh"), 
	Kerry			("KY", "Ciarraí"), 
	Limerick		("L", "Luimneach"),
	Longford		("LD", "An Longfort"), 
	Louth			("LH", "Lú/Lughbhaidh"), 
	Leitrim			("LM", "Liatroim"), 
	Laois			("LS", "Laois"),
	Meath			("MH", "An Mhí"), 
	Monaghan		("MN", "Muineachán"), 
	Mayo			("MO", "Maigh Eo"), 
	Offaly			("OY", "Uíbh Fhailí"),
	Roscommon		("RN", "Ros Comáin"), 
	Sligo			("SO", "Sligeach"), 
	Tipperary		("T", "Tiobraid Árann"),
	Waterford		("W", "Port Láirge"), 
	Westmeath		("WH", "An Iarmhí"), 
	Wexford			("WX", "Loch Garman"),
	Wicklow			("WW", "Cill Mhantáin");

	private final String reg;
	private final String gaeilge;

	County(String reg, String gaeilge) {
		this.reg = reg;
		this.gaeilge = gaeilge;
	}

	private String reg() {
		return reg;
	}

	private String gaeilge() {
		return gaeilge;
	}
}