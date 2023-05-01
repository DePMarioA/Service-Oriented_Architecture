package edu.mario.depaul.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Qservice {
    private Map<Integer,Quotes> quoteList = QuoteDB.getQuoteList(); //not thread safe.
    private int LargestID = QuoteDB.getLargestID(); //not thread safe
    private int pagesize = 3; // global variable to set the amount of quotes listed per page. I did 3 since list was short
    public Qservice() {
    }


    /**According to the assignment: the default getAllQuotes() endpoint must return only the first page’s worth of results*/
    //so it does not return all the quotes.. it can be adjust if needed.
    //So I returned a list of length pagesize of the first page
    public List<Quotes> getAllQuotes(){
        return new ArrayList<Quotes>(quoteList.values()).subList(0,pagesize);
    }

    public List<Quotes> getAllQuotes(int start, int size){ //customize param search of quote, meaning they can create a page with a custom start search and length
        List<Quotes> list = new ArrayList<Quotes>(quoteList.values());
        if(start +size> quoteList.size()) {
            return new ArrayList<>();
        }
        return list.subList(start,size);
    }
    public List<Quotes> getAllQuotes(int page){ // default size equals 3.
        List<Quotes> list = new ArrayList<Quotes>(quoteList.values());
//        System.out.println(list.size());
       int endpt = page*pagesize; // when the listing should end
       if(endpt>list.size()){
           if(endpt- list.size()<pagesize){ //edge case
               return list.subList((endpt-pagesize),list.size());
           }
           else
           return new ArrayList<>(); // if request is out of bound just return an empty list.
       }
     return list.subList(endpt-pagesize,endpt);
    }


  public Quotes addQuote(Quotes quotes){

      if(quotes.id>LargestID){
          QuoteDB.setLargestID(quotes.id); //for now ensure new id creation
      }
      if(quotes.id==0){
          quotes.setId(LargestID+1); //next largest
      }
        quoteList.put(quotes.id,quotes); //add to Map
        return quotes;
  }

  public Quotes update(Quotes quotes){ //updates the quote by id so that quote can adjust accordingly
        if(quotes.getId()<=0){
            return null;
        }
//      System.out.println(quotes.id);
        quoteList.put(quotes.getId(),quotes);
        return quotes;
  }

  public Quotes deleteQuote(Integer id){


        return quoteList.remove(id);
  }

    public Quotes getQuote(Integer id) { //gets the quote by id
        return quoteList.get(id);
    }

    public int size(){//just needed it once for the header location when post request was done
        return quoteList.size();
  }






}
