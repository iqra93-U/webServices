/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.rest.lesson;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author navee
 */

@Path("/books")
public class BookResource {
    
    /**
     * URI: /
     */
    @GET
    public String getBooks(){
        System.out.println("BookResource.getBooks()");
        return "Cuisine et moi Java 18";
    }
    
      /**
     * URI: /borrowed
     */
    @GET
    @Path("/borrowed")
    public String getBorrowedBooks(){
        System.out.println("BookResource.getBorrowedBooks()");
        return "Java in 5 lessons / Java VS .NET";
    }
    @GET
    @Path("{id}")
    
    public String getBookById(@PathParam("id") int id){
        System.out.println("BookResource.getBookById()");
        return "Java for Life"+ id ;
    }
     @GET
    @Path("name-{bookname}-editor-{bookEditor}")
    
    public String getBookByName(@PathParam("bookname") String bookname,@PathParam("bookEditor") String bookEditor){
        System.out.println("BookResource.getBookByName()");
        return "Java for Life"+ bookname + bookEditor  ;
    }
    
    @GET 
    @Path("queryparameters")
    public String getQueryParameterBook(
        @DefaultValue("all") @QueryParam("name") String name,
        @DefaultValue("?-??????-?") @QueryParam("isbn") String isbn,
        @DefaultValue("false") @QueryParam("isExtended") boolean isExtended ){
        
        return name+" "+ isbn + " "+  isExtended ;
    }
    
    @POST
    @Path("createform")
    @Consumes("application/x-www-form-urlencoded")
    public String createBookForm(@FormParam("name") String name){
        System.out.println("BookResource.createBookForm");
        return name;
    }
     @POST
    @Path("headersparameters")

    public String getHeaderParametersBokk( @DefaultValue("all") @HeaderParam("name") String name,
        @DefaultValue("?-??????-?") @HeaderParam("isbn") String isbn,
        @DefaultValue("false") @HeaderParam("isExtended") boolean isExtended){
        System.out.println("BookResource.getHeaderParametersBokk()");
        
        return name+" "+ isbn + " "+  isExtended ;
    }
    
   @GET
    @Path("informationfromuriinfo/{name}")
    public String getInformationFromUriInfo(@Context UriInfo uriInfo, @PathParam("name") String name) {
        StringBuffer result = new StringBuffer();
        result.append("getPath(): " + uriInfo.getPath() + "\n");
        List<PathSegment> pathSegments = uriInfo.getPathSegments();
        result.append("getPathSegements(): ");
        for (PathSegment pathSegment : pathSegments) {
            result.append(pathSegment.getPath() + " ");
        }
        result.append("\n");
        result.append("getPathParameters(): ");
        MultivaluedMap<String, String> pathParameters = uriInfo.getPathParameters();
        Set<String> pathParametersSet = pathParameters.keySet();
        for (String currentParameter : pathParametersSet) {
            result.append(currentParameter + " ");
        }
        result.append("\n");
        result.append("getQueryParameters(): ");
        MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters();
        Set<String> queryParametersSet = queryParameters.keySet();
        for (String currentParameter : queryParametersSet) {
            result.append(currentParameter + " ");
        }
        result.append("\n");
        result.append("getAbsolutePath(): " + uriInfo.getAbsolutePath() + "\n");
        result.append("getBaseUri(): " + uriInfo.getBaseUri() + "\n");
        result.append("getRequestUri(): " + uriInfo.getRequestUri() + "\n");
        System.out.println(result.toString());
        return result.toString();
    }
    @GET
    @Path("informationfromhttpheaders")
    public String getInformationFromHttpHeaders(@Context HttpHeaders httpheaders) {
        StringBuffer result = new StringBuffer("Cookies:");
        Map<String, Cookie> cookies = httpheaders.getCookies();
        Set<String> currentKeySet = cookies.keySet();
        for (String currentCookie : currentKeySet) {
            result.append(currentCookie + "\n");
        }
        result.append("RequestHeaders:" + "\n");
        MultivaluedMap<String, String> requestHeaders = httpheaders.getRequestHeaders();
        Set<String> requestHeadersSet = requestHeaders.keySet();
        for (String currentHeader : requestHeadersSet) {
            result.append(currentHeader + ": " + requestHeaders.get(currentHeader) + "\n");
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
