package com.restfulapp;

import java.text.DecimalFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("lengthservice")
public class LengthService {

	@Path("convertcmtoft/{c}")
	@GET
	@Produces("application/xml")
	public String convertCmToFt(@PathParam("c") Double centimeterPrm) {
		Double centimeter, feet;
		DecimalFormat df;
		String result;
		
		df = new DecimalFormat("#.##");
		
		centimeter = centimeterPrm;
		feet = centimeter / 30.48;
		result = "Result in XML. Centimeters to Feet: " + df.format(feet);
		
		return "<lengthservice>" + 
		       "<centimeter>" + df.format(centimeter) + "</centimeter>" + 
		       "<result>" + result + "</result>" + 
		       "</lengthservice>";
	}
	
	@Path("convertfttocm/{f}")
	@GET
	@Produces("application/xml")
	public String convertFtToCm(@PathParam("f") Double feetPrm) {
		Double feet, centimeter;
		DecimalFormat df;
		String result;

		df = new DecimalFormat("#.##");
		
		feet = feetPrm;
		centimeter = feet * 30.48;
		result = "Result in XML. Feet to Centimeters: " + df.format(centimeter);

		return "<lengthservice>" + 
		       "<feet>" + df.format(feet) + "</feet>" + 
		       "<result>" + result + "</result>" + 
		       "</lengthservice>";
	}
}
