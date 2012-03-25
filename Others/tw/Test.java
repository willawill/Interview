import java.util.*;
import java.io.*;
import java.security.InvalidParameterException;


public class Test{

    public static void main(String[] args){
        if (args.length > 0){
            String file = args[0];

        try{
            File f = new File(file);
            byte[] byteArray = new byte[(int)f.length()];
            InputStream inputS = new FileInputStream(f);
            inputS.read(byteArray);
            inputS.close();

            String reader = new String(byteArray);
//Incase input contains lowercase characters
            reader = reader.toUpperCase();
            String[] input = null;
            input = reader.split(",");
            if (input == null){
                throw new InvalidParameterException("Invalid input");
            }
            for(int i = 0;i<input.length; i++){
                input[i] = input[i].trim();
            }

            HashSet<City> cities = new HashSet();
            List<City> towns = new ArrayList<City>();
            List<Edge> trains = new ArrayList<Edge>();
            for (String s: input){
                    if (s.length() != 3) {
                        throw new InvalidParameterException("Invalid input");
                    }
                    String c1 = Character.toString(s.charAt(0));
                    String c2= Character.toString(s.charAt(1));
                    City start = new City(c1);
                    City end = new City(c2);
                    cities.add(start);
                    cities.add(end);
                    
                    int dis = s.charAt(2) -'0';
                    trains.add(new Edge(start, end, dis));
                    
            }
            for (City c : cities){
                towns.add(c);
            }
            Trains runner = new Trains(towns, trains);
            City a = new City("A");
            City b = new City("B");
            City c = new City("C");
            City d = new City("D");
            City e = new City("E");
            ArrayList r1 = new ArrayList<City>();
            r1.add(a);
            r1.add(b);
            r1.add(c);
            ArrayList r2 = new ArrayList<City>();
            r2.add(a);
            r2.add(d);
            ArrayList r3 = new ArrayList<City>();
            r3.add(a);
            r3.add(d);
            r3.add(c);
            ArrayList r4 = new ArrayList<City>();
            r4.add(a);
            r4.add(e);
            r4.add(b);
            r4.add(c);
            r4.add(d);
            ArrayList r5 = new ArrayList<City>();
            r5.add(a);
            r5.add(e);
            r5.add(d);
            ArrayList<ArrayList> q15 = new ArrayList<ArrayList>();
            q15.add(r1);
            q15.add(r2);
            q15.add(r3);
            q15.add(r4);
            q15.add(r5);
            for (ArrayList r: q15){
                System.out.println("OutPut: " +runner.computeRouteDistance(r));
            }
            System.out.println("Cities " + cities);
            
            System.out.println("#6 Output " + runner.getRouteWithMaxStops(c,c,3));
            System.out.println("#7 Output " + runner.getRouteWithExactStops(a,c,4));
            System.out.println("#8 Output " + runner.getShortestRoute(a,c));
            System.out.println("#9 Output " + runner.getShortestRouteWithCycle(b,b));
            System.out.println("#10 Outout " + runner.getRoutesWithDistance(c,c,30));

        }

        catch (IOException e){
            System.out.println("Problem occurs" + e.getMessage());

            }
        
        }
    }
}


