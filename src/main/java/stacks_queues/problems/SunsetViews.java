package stacks_queues.problems;

import java.util.ArrayList;

public class SunsetViews {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

        ArrayList<Integer> result = new ArrayList<>();

        if(direction.equals("EAST")){

            int max = Integer.MIN_VALUE;

            for(int i = buildings.length - 1 ; i >=0 ; i--){
                if(buildings[i] > max){
                    result.addFirst(i);
                    max = buildings[i];
                }
            }
        }else {
            int max = Integer.MIN_VALUE;

            for(int i = 0; i <= buildings.length - 1 ; i++){
                if(buildings[i] > max){
                    result.add(i);
                    max = buildings[i];
                }
            }
        }
        return result;
    }
}
