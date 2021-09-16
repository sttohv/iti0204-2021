package ee.ttu.algoritmid.guessinggame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuessingGame {

    Oracle oracle;

    public GuessingGame(Oracle oracle) {
        this.oracle = oracle;
    }

    /**
     * @param fruitArray - All the possible fruits.
     * @return the name of the fruit.
     */
    public String play(Fruit[] fruitArray) {
        // TODO
        Fruit[] sortedFruitArray = sort(fruitArray).toArray(new Fruit[0]);
        Fruit middleWeightFruit = getMiddleElementByWeight(fruitArray);
        if(oracle.isIt(middleWeightFruit).equals("correct!")){
            return middleWeightFruit.getName();
        }else if(oracle.isIt(middleWeightFruit).equals("lighter")){
            Fruit[] newArray = Arrays.copyOfRange(sortedFruitArray, 0, sortedFruitArray.length/2);
            return play(newArray);
        }else{
            Fruit[] newArray = Arrays.copyOfRange(sortedFruitArray, sortedFruitArray.length/2 + 1,sortedFruitArray.length);
            return play(newArray);
        }
    }

    public List<Fruit> sort(Fruit[] fruitArray) {
        return Arrays.stream(fruitArray).sorted(Comparator.comparing(Fruit::getWeight)).collect(Collectors.toList());
    }

    public Fruit getMiddleElementByWeight(Fruit[] sortedValues) {
        // sort array
        // get count of fruits
        int totalElements = sortedValues.length;
        // check if total number of scores is even
        Fruit middle = sortedValues[sortedValues.length / 2];
        return middle;
    }

}