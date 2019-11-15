package GeeksForGeeks;

import java.util.*;
public class SnapTravel {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int nHotel = in.nextInt();
        in.nextLine();

        HashMap<String, ArrayList<Hotel>> hotels = new HashMap<>();

        for (int i = 0; i < nHotel; i++){
            String cur = in.nextLine();
            String arr [] = cur.split(",");

            if (hotels.containsKey(arr[0])) {
                ArrayList<Hotel> current = hotels.get(arr[0]);
                current.add(new Hotel(Double.parseDouble(arr[2]), arr[1]));
                hotels.put(arr[0], current);
            }
            else {
                ArrayList<Hotel> current = new ArrayList<>();
                current.add(new Hotel(Double.parseDouble(arr[2]), arr[1]));
                hotels.put(arr[0], current);
            }
        }

        int q = in.nextInt();
        in.nextLine();

        for (int i = 0; i < q; i++){
            String cur = in.nextLine();
            String arr [] = cur.split(",");
            int day = Integer.parseInt(arr[1]);

            ArrayList<Hotel> curHotels = hotels.get(arr[0]);

            double calc [] = new double [curHotels.size()];

            for (int j = 0; j < calc.length; j++){

                double price = 0;
                Hotel hot = curHotels.get(j);

                if (hot.getType().equals("A") && day <= 1){
                    price = hot.getPrice() * 1.5;
                }
                else if (hot.getType().equals("B") && day < 3){
                    price = -1;
                }
                else if (hot.getType().equals("C") && day >= 7){
                    price = hot.getPrice() * 0.9;
                }
                else if (hot.getType().equals("D") && day < 7){
                    price = hot.getPrice() * 1.1;
                }

                calc[j] = price;

            }

            Arrays.sort(calc);

            if (calc[calc.length-1] == -1){
                System.out.print("None");
            }
            else {
                for (int j = 0; j < calc.length; j++){
                    if (calc[j] != -1){
                        System.out.format("%.2f", calc[j]);
                        System.out.print(",");
                    }
                }
            }

            System.out.println("");
        }
    }

    private static class Hotel {
        private double price;
        private String type;

        public Hotel (double price, String type){
            this.price = price;
            this.type = type;
        }

        public String getType (){
            return type;
        }

        public double getPrice (){
            return price;
        }
    }
}
