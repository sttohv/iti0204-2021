package ee.ttu.algoritmid.interestingstamps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InterestingStamps {
    public static List<Integer> findStamps(int sum, List<Integer> stampOptions) throws IllegalArgumentException {
        // TODO
        if(stampOptions.isEmpty()){
            throw new IllegalArgumentException();
        }
        List<Integer> sorted = stampOptions.stream().sorted().collect(Collectors.toList());
        int len = sorted.size();
        int[][] array = new int[len][sum + 1];
        //täidab kogu tabeli 0-dega
        for (int i = 0; i < len; i++) {
            array[i][0] = 0;
        }
        for (int i = 0; i < sum + 1; i++) {
           array[0][i] = i / sorted.get(0);
        }

        for (int i = 1; i < len; i++) {
            Integer num = sorted.get(i);
            for (int j = 0; j <= sum ; j++) {
                if (num > j) {
                    array[i][j] = array[i-1][j];
                }else{
                    array[i][j] = Math.min(array[i-1][j], 1+array[i][j-num]);
                }
            }
        }

        int i = len - 1;
        int j = sum;
        int min = array[i][j];
        List<Integer> result = new ArrayList<>();
        while (j!=0){
            if(i>0 && array[i-1][j] == min){
                i--;
            }else{
                j = j-sorted.get(i);
                result.add(sorted.get(i));
                min = array[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> coins = List.of(1, 10, 24, 30, 33, 36);
        //List<Integer> coins = List.of(1, 5, 6, 8);
        List<Integer> result = findStamps(100, coins);
        for (Integer num:result
             ) {
            System.out.println(num);

        }


    }
}
