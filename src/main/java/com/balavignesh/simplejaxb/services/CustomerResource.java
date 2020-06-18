/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balavignesh.simplejaxb.services;


import com.balavignesh.simplejaxb.domain.Customer;
import com.balavignesh.simplejaxb.domain.CustomerList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author BalaVignesh
 */
@Path("/customer")
public class CustomerResource {
      
    private CustomerList customerList = new CustomerList();
    
     //POST /customer/name/zipcode/43085 
    
    @POST
    @Path("{name}/zipcode/{zipcode}")
    public Response addCustomer(@PathParam("name") String name,@PathParam("zipcode") String zipcode){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setZipcode(zipcode);
        customerList.getCustomer().add(customer);
        return Response.ok().build();
    }
    
   //GET /customer
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public CustomerList getCustomers(){
        return customerList;
    }
    
}
