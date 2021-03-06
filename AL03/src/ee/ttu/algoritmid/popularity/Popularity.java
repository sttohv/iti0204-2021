package ee.ttu.algoritmid.popularity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Popularity {
    public Map<List<Integer>, Integer> points = new HashMap<>();
    public int leftToEnter;
    public int maxCount = 0;

    public Popularity(int maxCoordinates) {
        leftToEnter = maxCoordinates;
    }

    /**
     * @param x, y - coordinates
     *           adds a picture at the point with coordinates (x, y)
     */
    void addPoint(Integer x, Integer y) {
        // todo
//        if(leftToEnter!=0){
//
//            leftToEnter--;
//        }
        List<Integer> point = List.of(x, y);
        if (points.containsKey(point)) {
            int count = points.get(point) + 1;
            points.put(point, count);
            if (maxCount < count) {
                maxCount = count;
            }
        } else {
            points.put(point, 1);
            if (maxCount == 0) {
                maxCount++;
            }
        }


    }

    /**
     * @param x, y - coordinates
     * @return the number of occurrences of the point
     */
    int pointPopularity(Integer x, Integer y) {
        List<Integer> point = List.of(x, y);
        if (points.containsKey(point)) {
            return points.get(point);
        }
        return 0;
    }


    /**
     * @return the number of occurrences of the most popular point
     */
    int maxPopularity() {
        return maxCount;
    }

    public static void main(String[] args) {
        int k = 53;
        int j = 5;
        System.out.println( k%11 +j*((k%7)+1));
    }

}