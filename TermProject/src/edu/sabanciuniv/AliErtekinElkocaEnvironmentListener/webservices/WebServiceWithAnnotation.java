package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.webservices;

import javax.ejb.Stateless;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/evlwebservicetrail")
@Stateless
public class WebServiceWithAnnotation {
	
	@GET
	@Path("/user/{id}{format:(/format/[^/]+?)?}{encoding:(/encoding/[^/]+?)?}")
	public Response getUser(
	  @PathParam("id") int id,
	  @PathParam("format") String format,
	  @PathParam("encoding") String encoding) {
	 String responseText = "";
	 
	if (format.equals("")) {
	  // Optional parameter "format" not specified
	  responseText += "No format specified.";
	 } else {
	  // Optional parameter "format" has looks like "/format/pdf" -&gt; get it's value only
	  format = format.split("/")[2];
	  responseText += "Format=" + format;
	 }
	 
	if (encoding.equals("")) {
	  // Optional parameter "encoding" not specified
	  responseText += " No encoding specified";
	 } else {
	  // Optional parameter "encoding" has looks like "/encoding/utf8" -&gt; get it's value only
	  encoding = encoding.split("/")[2];
	  responseText += " Encoding=" + encoding;
	 }
	 
	return Response.status(200).type("text/plain").entity(responseText).build();
	
	//Requesting http://localhost:8080/services/user/3, will return “No format specified. No encoding specified”.
	//Requesting http://localhost:8080/services/user/3/format/pdf/encoding/utf8, will return “Format=pdf Encoding=utf8”.
	//Requesting http://localhost:8080/services/user/3/encoding/utf8, will return “No format specified. Encoding=utf8”.
	
	}

}
