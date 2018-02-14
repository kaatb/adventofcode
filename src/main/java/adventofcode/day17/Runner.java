package adventofcode.day17;

import java.util.List;

class Runner {

    public static void main(String[] args) {
        List<Value> allValues = new Spinner(377).spin(2017);
        Value valueAfterLastInserted = allValues.stream()
                .filter(value -> value.getValue() == 2017)
                .findFirst()
                .get()
                .getNextValue();
        System.out.println(valueAfterLastInserted.getValue());

        System.out.println(new Spinner(377).findElementAtIndex1After(50000000));
    }
}
