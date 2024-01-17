public class Reservation {
    public String name;
    public int Name;
    public int NPeople;
    public int timeMade;
    public int timeFor;

    //timeStuff();

    /*public Reservation(String name, int nPeople, int time) {

        Name = name;
        timeFor = time;
        NPeople = nPeople;

    }*/


    public void timeStuff(){
    /*    long now = new Date().getTime();
        System.out.println(now);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd k:mm");
        String timeString = dateFormat.format(now);

        long future = new Date().getTime() + 10000000;
        String futureString = dateFormat.format(future)
        System.out.println(timeString);;
        System.out.println(futureString);
        System.out.println(future > now);*/

    }

    public Reservation() {
        Name = (int)(Math.random()*10+1);
        name = "Carter";
        NPeople = (int)(Math.random()*10+1);
        timeFor = (int)(Math.random()*10+1);
        timeMade = (int)(Math.random()*10+1);

        if (Name == 1){
            name = "Joe";
        }
        if (Name == 2){
            name = "Danny";
        }
        if (Name == 3){
            name = "Mariana";
        }
        if (Name == 4){
            name = "Brent";
        }
        if (Name == 5){
            name = "Lisa";
        }
        if (Name == 6){
            name = "Maya";
        }
        if (Name == 7){
            name = "Jack";
        }
        if (Name == 8){
            name = "Raina";
        }
        if (Name == 9){
            name = "Francesca";
        }
        if (Name == 10){
            name = "Georgio";
        }


    }

    public void printInfo() {
        System.out.println("Reservation made at " + timeMade + " for " + name + " for " + NPeople + " people at " + timeFor);
    }

    public String getInfo() {
        return ("Reservation made at " + timeMade + " for " + name + " for " + NPeople + " people at " + timeFor);
    }
}
