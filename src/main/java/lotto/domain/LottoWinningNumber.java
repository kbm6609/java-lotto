package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumber {


    public List<Integer> winningNumberConversion(String inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] separate = separateByComma(inputWinningNumber);

        validSixNumber(separate);
        validConsistNumber(separate);

        for (int i = 0; i < separate.length; i++) {
            winningNumber.add(Integer.parseInt(separate[i]));
        }
        validAllNumberRange(winningNumber);

        return winningNumber;
    }

    public void validSixNumber(String[] inputNumbers) {
        if (inputNumbers.length != Lotto.numberCount) {
            throw new IllegalArgumentException();
        }
    }

    public void validConsistNumber(String[] inputNumbers) {
        try {
            for (int i = 0; i < inputNumbers.length; i++) {
                Integer.parseInt(inputNumbers[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void validAllNumberRange(List<Integer> inputNumbers) {
        for (int inputNumber : inputNumbers) {
            validOneNumberRange(inputNumber);
        }
    }

    public void validOneNumberRange(int inputNumber) {
        if (inputNumber < Lotto.numberMinRage || inputNumber > Lotto.numberMaxRage) {
            throw new IllegalArgumentException();
        }
    }

    public String[] separateByComma(String inputNumbers) {
        return inputNumbers.split(",");
    }
}
