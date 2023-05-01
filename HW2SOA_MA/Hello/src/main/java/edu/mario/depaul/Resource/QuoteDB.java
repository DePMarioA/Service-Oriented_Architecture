package edu.mario.depaul.Resource;

import java.util.HashMap;
import java.util.Map;


/**
 * To ensure that the data is stored properly I created a somewhat quote database.
 * I instantiated here because if I did it in Qservice then I couldn't delete the preset quote 1-5.
 * Thus having it separated and instantiating at within the class made sense
 * Mapping made it easy to manipulate the data.
 */

public class QuoteDB {
    private static int LargestID =5;

    public static int getLargestID() {
        return LargestID;
    }

    public static void setLargestID(int largestID) {
        LargestID = largestID;
    }

    private static Map<Integer,Quotes> QuoteList = new HashMap<Integer,Quotes>(){{
        put(1,new Quotes(1,"When you have something to say, silence is a lie."));
        put(2,new Quotes(2,"If you fulfill your obligations everyday you don't need to worry about the future."));
        put(3,new Quotes(3,"Perhaps you are overvaluing what you don’t have and undervaluing what you do."));
        put(4,new Quotes(4,"The computer was born to solve problems that did not exist before."));
        put(5,new Quotes(5,"A good programmer is someone who always looks both ways before crossing a one-way street."));
    }};

    public static  Map<Integer,Quotes> getQuoteList(){
        return QuoteList;
    }

}
