package com.restfulapp;

import java.text.DecimalFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("temperatureservice")
public class TemperatureService {
	
	@GET
	@Path("/convertceltofar")
	@Produces("application/xml")
	public String convertCelToFar() {
		Double celsius, fahrenheit;
		DecimalFormat df;
		String result;
		
		df = new DecimalFormat("#.##");
		
		celsius = 100.0;
		fahrenheit = ((celsius * 9) / 5) + 32;
		result = "Result in XML. Celsius to Fahrenheit: " + df.format(fahrenheit);
		
		return "<temperatureservice>" + 
		       "<celsius>" + df.format(celsius) + "</celsius>" + 
		       "<result>" + result + "</result>" + 
		       "</temperatureservice>";
	}
	
	@Path("/convertceltofar/{c}")
	@GET
	@Produces("application/xml")
	public String convertCelToFarInput(@PathParam("c") Double celsiusPrm) {
		Double celsius, fahrenheit;
		DecimalFormat df;
		String result;
		
		df = new DecimalFormat("#.##");
		
		celsius = celsiusPrm;
		fahrenheit = ((celsius * 9) / 5) + 32;
		result = "Result in XML. Celsius to Fahrenheit: " + df.format(fahrenheit);
		
		return "<temperatureservice>" + 
		       "<celsius>" + df.format(celsius) + "</celsius>" + 
		       "<result>" + result + "</result>" + 
		       "</temperatureservice>";
	}
	
	@GET
	@Path("/convertfartocel")
	@Produces("application/json")
	public Response convertFarToCel() throws JSONException {
		JSONObject jsonObject;
		Double fahrenheit, celsius;
		DecimalFormat df;
		String result;
		
		df = new DecimalFormat("#.##");
		jsonObject = new JSONObject();
		fahrenheit = 212.0;
		jsonObject.put("Fahrenheit Value", df.format(fahrenheit));
		
		celsius = (fahrenheit - 32) * 5 / 9;
		jsonObject.put("Celsius Value", df.format(celsius));
 
		result = "See the result below in JSON.\n\nFahrenheit to Celsius:\n" + 
				 jsonObject;
		
		return Response.status(200).entity(result).build();
	}
	
	@Path("/convertfartocel/{f}")
	@GET
	@Produces("application/json")
	public Response convertFarToCelInput(@PathParam("f") Double fahrenheitPrm) throws JSONException {
		JSONObject jsonObject;
		Double fahrenheit, celsius;
		DecimalFormat df;
		String result;
		
		df = new DecimalFormat("#.##");
		jsonObject = new JSONObject();
		fahrenheit = fahrenheitPrm;
		jsonObject.put("Fahrenheit Value", df.format(fahrenheit));
		
		celsius = (fahrenheit - 32) * 5 / 9;
		jsonObject.put("Celsius Value", df.format(celsius));
 
		result = "See the result below in JSON.\n\nFahrenheit to Celsius:\n" + 
				 jsonObject;
		
		return Response.status(200).entity(result).build();
	}
}
