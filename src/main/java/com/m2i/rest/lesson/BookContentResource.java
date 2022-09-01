/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.rest.lesson;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author navee
 */
@Path("/contentbooks")
public class BookContentResource {
    
    @GET
    @Path("details/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDetailTextBookId(@PathParam("id") String id){
        
        System.out.println("BookContentResource.getDetailTextBookId()");
        return "this book is about the introduction on life (in form of text file)";
    }
    
    @GET
    @Path("details/{id}")
    @Produces(MediaType.TEXT_XML)
    public String getDetailXMLBookId(@PathParam("id") String id){
        
        System.out.println("BookContentResource.getDetailXMLBookId()");
        return "<?xml version=\"1.0\"?>" + "<details>Ce livre est une introduction sur la vie" + "</details>";
    }
    
     @GET
    @Path("details/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String getDetailHTMLBookId(@PathParam("id") String id){
        
        System.out.println("BookContentResource.getDetailHTMLBookId()");
        return "<html>" + "<title>" + "Details" + "</title>" + "<body><h1>" + "Ce livre est une introduction sur la vie"
                + "</h1></body>" + "</html>";
    }
    
    // notations to send data in the form of XML by using consumes and produces 
    
    @Path("xml")
    @Consumes(MediaType.APPLICATION_XML)
    @PUT
    public void updateContentBookWithXML(Book current) throws IOException {
        System.out.println ("Name:"+current.getName() +",ISBN"+current.getIsbn());
    }
    
     @Path("xml")
     @GET
    @Produces(MediaType.APPLICATION_XML)

    public Book getContentBookWithXML() {
        Book current = new Book();
        current.setName("Iqra");
        current.setIsbn("2-222222-22");
        return current;
    }
    
    // send data in form of json 
    
     @Path("json")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public void updateContentBookWithJSON(Book current) throws IOException {
        System.out.println ("Name:"+current.getName() +",ISBN"+current.getIsbn());
    }
    
     @Path("json")
     @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Book getContentBookWithJSON() {
        Book current = new Book();
        current.setName("Iqra");
        current.setIsbn("2-222222-22");
        return current;
    }
    // Different status of responses 
    
    // this will send the response by default as we use method String to send jyst the content 
    @GET
    @Path("ok/without_response")
    public String getBookWithoutResponse(){
        return" java response of ok/without_response" ;
    }
    
    // that is what we made API to send the response as we use the method response 
     @GET
    @Path("ok")
    public Response getBookWithResponse(){
        return Response.status(Response.Status.OK).entity("Java For life").build() ;
    }
}
