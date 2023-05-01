package edu.mario.depaul.Resource;


/**
 * self-explanatory, creating a quote class with constructors, getter and setters.
 *
 */

public class Quotes {
    int id;
    String quotes;

    public Quotes(int id, String quotes) {
        this.id = id;
        this.quotes = quotes;
    }

    public Quotes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getQuotes() {
        return quotes;
    }
    @Override
    public String toString() { // provides a json style format if needed.
        return "Quote{" +
                "id: " + id +
                ", quote:" + quotes +
                '}';

    }
    }