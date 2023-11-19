class ATM {
	long[] notes = new long[5];                                                
	int[] denoms;
	public ATM() {
		denoms = new int[]{ 20,50,100,200,500 };
	}

	public void deposit(int[] banknotesCount) {
		for(int i = 0; i < banknotesCount.length; i++){
			notes[i] += banknotesCount[i];                                       
		}
	}

	public int[] withdraw(int amount) {                 
		int[] result = new int[5];                                              
		for(int i = 4; i >= 0; i--){
			if(amount >= denoms[i] ) {                                              
				int quantity = (int) Math.min(notes[i], amount / denoms[i]);     
				amount -= denoms[i] * quantity;                                 
				result[i] = quantity;
			}
		}
		if(amount != 0){ return new int[]{-1}; }
		for(int i = 0; i < 5; i++){  notes[i] -= result[i];  }                   
		return result;
	}
}