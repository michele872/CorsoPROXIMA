package org.proxima.chat.exception;

import org.proxima.chat.entities.ChatMessages;

public class CustomErrorType extends ChatMessages{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
    public CustomErrorType(final String errorMessage){        
    	this.errorMessage = errorMessage;    
    	}
    
	public String getErrorMessage() {        
		return errorMessage;    
		} 

}
