/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.rest.lesson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author navee
 */
@Path("/hello")
public class HelloWorld {
    
    @GET
    @Produces("text/plain")
    public String getHelloWorld(){
        return "Hello World from text/plain from the page helloWorld.java";
    }
    
}
