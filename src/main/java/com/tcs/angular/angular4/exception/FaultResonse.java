/**
 * 
 */
package com.tcs.angular.angular4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author HP
 *
 */

public class FaultResonse {
	
	private String message;
	 
	  public FaultResonse(String msg){
	    this.message = msg;
	  }
	  
	  public String getMessage() {
	    return message;
	  }
	 
	  public void setMessage(String message) {
	    this.message = message;
	  }

}
