/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.rest.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author navee
 */

@XmlRootElement(name="book")  // the name book we will use in xml to create tag like <book> </book> each property would be written in tag 
@JsonPropertyOrder ({"isbn" , "name"}) // this will help to order the display in Json file as if i declare inverse in method 
public class Book {
    
    @JsonProperty("book_name") // this will just display name as book_name in json file which we will send to client but in out class it will remain name
    protected String name;
    @JsonProperty("book_isbn")
    protected String isbn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", isbn=" + isbn + '}';
    }
    
    
    
}
