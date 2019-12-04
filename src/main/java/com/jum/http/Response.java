package com.jum.http;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Response {
	
	private int status;
	private String responseStr;
	private boolean isSuccess = false;

	public Response(int responseStatus, String responseStr){
		this.status = responseStatus;
		this.responseStr = responseStr;
		if (this.status == 200) {
			JsonObject resp = (new JsonParser()).parse(this.responseStr).getAsJsonObject();
			if (resp.get("code").getAsInt() == 1) {
				this.isSuccess = true;
			}
		}
	}

	public int getStatus() {
		return status;
	}

	public String getResponseStr() {
		return responseStr;
	}

}
