package org.acme.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import org.jboss.eap.quickstarts.wscalculator.calculator.CalculatorService;

import io.quarkiverse.cxf.annotation.CXFClient;

@Path("/cxf/calculator-client")
public class CxfClientRestResource {

    @CXFClient("myCalculator")
    CalculatorService myCalculator;

    @GET
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public int add(@QueryParam("a") int a, @QueryParam("b") int b) {
        return myCalculator.add(a, b);
    }

    @GET
    @Path("/multiply")
    @Produces(MediaType.TEXT_PLAIN)
    public int multiply(@QueryParam("a") int a, @QueryParam("b") int b) {
        return myCalculator.multiply(a, b);
    }

    @GET
    @Path("/divide")
    @Produces(MediaType.TEXT_PLAIN)
    public int divide(@QueryParam("a") int a, @QueryParam("b") int b) {
        return myCalculator.divide(a, b);
    }

    @GET
    @Path("/subtract")
    @Produces(MediaType.TEXT_PLAIN)
    public int subtract(@QueryParam("a") int a, @QueryParam("b") int b) {
        return myCalculator.subtract(a, b);
    }

}