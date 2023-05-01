import java.util.Random;
import java.util.Scanner;

public class FlightServices {

    public static void main(String[] args) {
        Scanner demo = new Scanner(System.in);

        System.out.print("Please enter multiple inputs you want to print: ");

//takes an integer input

        String[] string = new String [3];
        String[] flights = {"Flight1","Flight2","Flight3"};
        String[] location =  {"Loc1","Loc2","Loc3"};
        String answer ="";
        int price ;
        String RID = "";

        System.out.println("Select service 1 or 2" +
                "\nMatching Flight [1]" +
                "\nPayment [2]");
        answer = demo.nextLine();
        System.out.println(answer);
        boolean options = false;
        boolean acceptcost = false;
//consuming the <enter> from input above
        if(answer.contains("1")){

            while(!options){
                System.out.println("Matching[1]" +
                        "\n Reserving[2]" +
                        "\nCanceling[3]" +
                        "\nDone[4]");
                answer= demo.nextLine();
                if(answer.contains("1")){

                    System.out.println("Select location and date (ex:/loc5-6/10/22)");
                    answer = demo.nextLine();
                    while(!acceptcost) {
                        int ss = (int) (answer.hashCode() * Math.random());
                        ss = ss % 2;
                        price = ((int) (Math.random() * (300 - 100))) + 100;
                        RID = RID();
                        System.out.println(flights[(int) ss] + "price: " + price + "Reservation ID: " + RID);
                        String answer2;
                        System.out.println("Accept cost?" +
                                "\n yes[1]" +
                                "\nno[2]");
                        answer2 = demo.nextLine();
                        if(answer2.contains("1")){
                            acceptcost=true;
                        }
                    }

                }
                else if(answer.contains("2")){

                    System.out.println("/reserve" +
                            "\n enter RID:");
                    answer = demo.nextLine();
                    if(RID.isBlank()){
                        System.out.println("[Info]: PUT /reserve" + answer);
                    }
                    else {
                        System.out.println("[Info]: PUT /reserve" + RID);
                    }
                    System.out.println("reserved!");
                }
                else if (answer.contains("3")){
                    System.out.println("/cancel" +
                            "\n enter RID:");
                    answer = demo.nextLine();
                    if(RID.isBlank()){
                        System.out.println("[Info]: DELETE /reserve" + answer);
                    }
                    else {
                        System.out.println("[Info]: DELETE /reserve" + RID);
                    }
                    System.out.println("cancelled!");
                }
                else options=true;
                System.out.println("Ending session");

                }

            }
        else{
            System.out.println("Enter RID to pay or cancel:");
            answer = demo.nextLine();
            String rid = answer;
            String confirmationid = RID();
            while(!options){
                System.out.println("pay[1]" +
                        "\n cancel[2]" +
                        "\n done[3]");
                answer= demo.nextLine();
                if(answer.contains("1")){
                    System.out.println("enter info:");
                    answer= demo.nextLine();
                    System.out.println("POST//pay"+rid+"-"+answer);
                    int num = (int) ((Math.random()*10)%2);
                    if(num ==1 ) {
                        System.out.println("sucessful: confirmationID: "+confirmationid);
                    }
                }
                else if(answer.contains("2")){
                    System.out.println("enter confirmationID:");
                    System.out.println("CID: " + confirmationid);
                    answer= demo.nextLine();
                    System.out.println("DELETE//pay"+rid+"-"+answer);
                    System.out.println("sucessful: confirmationID: "+confirmationid);
                    options = true;
                    System.out.println("Ending session");



                }
                else
                    options=true;
            }
        }
        System.out.println("GoodBye Have a nice day");

    }

    public static String RID(){
        String s;
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return  generatedString;
    }

}
