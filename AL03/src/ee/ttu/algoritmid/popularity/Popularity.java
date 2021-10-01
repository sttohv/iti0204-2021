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
     * @return the number of occurrennces of the point
     */
    int pointPopularity(Integer x, Integer y) {
        List<Integer> point = List.of(x, y);
        return points.get(point);
    }


    /**
     * @return the number of occurrennces of the most popular point
     */
    int maxPopularity() {
        return maxCount;
    }

}