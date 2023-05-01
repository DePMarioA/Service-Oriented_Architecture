package edu.mario.depaul.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


/**
 * This is where the crud aspect is.
 */

@Path("/quotes")
public class QuoteResource {
    Qservice qservice = new Qservice();
    @GET
    @Produces(MediaType.TEXT_HTML) // if browser is used, can click to see the first page of getall
    public String x (){
        return "<html>\n" +
                " <p>To get all quotes: <a href=\"quotes/getall\">getall</a>\n" +
                "</html>\n";
    }

    @Path("/getall")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllQuotes(@QueryParam("page") int page,@QueryParam("start") int start,@QueryParam("size") int size){ //@QueryParam is used to accept values to search

        if(page!=0){
            if(qservice.getAllQuotes(page).isEmpty())
            {return Response.noContent().header("End","YOU'VE REACH THE END OF THE LIST").build();}

            return Response.ok().entity(qservice.getAllQuotes(page)).build() ;
        }
        if(start!=0&size!=0){
            return Response.ok().entity(qservice.getAllQuotes(start,size)).build();
        }


        return Response.ok().entity(qservice.getAllQuotes()).build();
    }
    @GET
    @Path("/{id}") //no path is used, direct routing makes sense, quotes which one? 1 so /quotes/1. get me the first quote
    @Produces(MediaType.APPLICATION_JSON)
    public Quotes getQuoteByID(@PathParam("id") Integer id){ //searches per id
        return qservice.getQuote(id);
    }


    @Context
    UriInfo uriInfo; //helps find address
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addQuote(Quotes quotes){
        qservice.addQuote(quotes);
        //provides location of the created quote
        return Response.status(201).header("Location",String.format("%s"+"quotes/%s",uriInfo.getBaseUri(), quotes.id)).header("Quote add",quotes).build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Quotes updateQuote(@PathParam("id") Integer id,Quotes quotes){ //updating the quote by id, its accepting quote value
        quotes.setId(id); //ensuring the quote id match the request so for example
        // if {"id":6,"quotes":"mky1o1n"} for a PUT request at /quotes/1 it ensures that the correct id is adjusted which would be 1 not 6.
        return qservice.update(quotes);
    }
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Quotes deleteQuote(@PathParam("id") Integer id){
        return qservice.deleteQuote(id);
    }
    @Path("/size")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSize(){

        return Response.ok().entity("Size: "+qservice.size()).build();
    }

}
