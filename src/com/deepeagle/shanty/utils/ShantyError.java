package com.deepeagle.shanty.utils;

public class ShantyError {

	private final int code;
	public ShantyError(int code){
		this.code = code;
	}
	public int getId(){
		return code;
	}
	public String getInfoString(){
		String error;
		switch (code) {
        case 1:  error = "Input text too long";
                 break;
        case 2:  error = "Input ontains invalid characters";
                 break;
        default: error = "Unknown error code: " + code;
                 break;
		}
		return error;
	}
}
