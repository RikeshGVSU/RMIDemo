package client;

import java.io.Serializable;
import java.math.BigDecimal;

import compute.Task;

public class Prime implements Task<String>, Serializable {

	public int min;
	public int max;
	
	/**
	 * 
	 */
	public Prime(int min, int max) {
		this.min = min;
		this.max = max;
	}
	@Override
	public String execute() {
		return getPrimes(this.min, this.max);
	}
	
	public String getPrimes(int min, int max) {
		String primeNumbers = "";
		int i = 0;
	    int num = 0;
	    for (i = 1; i <= max; i++){ 		  	  
	       int counter=0; 	  
	       for(num =i; num>=1; num--){
	          if(i%num==0){
	        	  counter = counter + 1;
	          }
		  }
		  if (counter == 2 && i >= min){
		     primeNumbers = primeNumbers + i + " ";
		  }
	    }
		return primeNumbers;
	}
	
}
