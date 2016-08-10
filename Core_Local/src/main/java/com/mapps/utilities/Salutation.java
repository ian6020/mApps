package com.mapps.utilities;

public enum Salutation {

	// Ladies first! ;)
	MS("model.salutation.ms"), 
	MISS("model.salutation.miss"), 
	MRS("model.salutation.mrs"), 
	MR("model.salutation.mr"),
	SIR("model.salutation.sir");
	
	private final String key;
	
    private Salutation(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
    
    public static String getAllKeys() {
		boolean first = true;
		StringBuffer str = new StringBuffer("[");
		for( Salutation one : Salutation.values() ) {
			if(first) {
				str.append(one);
				first = false;
			} else str.append(", " + one);
		}
		str.append("]");
		return str.toString();
	}
}
