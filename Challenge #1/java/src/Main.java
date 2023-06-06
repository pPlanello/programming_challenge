import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var printStrategies = new ArrayList<PrintStrategy>();
        printStrategies.add(new FizzBuzzPrinting());
        printStrategies.add(new FizzPrinting());
        printStrategies.add(new BuzzPrinting());
        printStrategies.add(new DefaultPrinting());

        numbers.forEach(number -> {
            printStrategies.forEach(action -> action.print(number));
        });
    }

    private static final List<Integer> numbers = IntStream.rangeClosed(0, 100).boxed().toList();

    interface PrintStrategy {
        void print(Integer number);
    }

    static class FizzBuzzPrinting implements PrintStrategy {
        @Override
        public void print(Integer number) {
            if (isFizzBuzzNumber.test(number)) {
                System.out.println("FizzBuzz");
            }
        }

        private static final IsFizzBuzzNumber isFizzBuzzNumber = new IsFizzBuzzNumber();
    }

    static class FizzPrinting implements PrintStrategy {
        @Override
        public void print(Integer number) {
            if (isFizzNumber.test(number)) {
                System.out.println("Fizz");
            }
        }

        private static final IsFizzNumber isFizzNumber = new IsFizzNumber();
    }

    static class BuzzPrinting implements PrintStrategy {
        @Override
        public void print(Integer number) {
            if (isBuzzNumber.test(number)) {
                System.out.println("Buzz");
            }
        }

        private static final IsBuzzNumber isBuzzNumber = new IsBuzzNumber();
    }

    static class DefaultPrinting implements PrintStrategy {
        @Override
        public void print(Integer number) {
            var allPredicateStrategy = new ArrayList<Predicate>();
            allPredicateStrategy.add(new IsBuzzNumber());
            allPredicateStrategy.add(new IsFizzBuzzNumber());
            allPredicateStrategy.add(new IsFizzNumber());

            if (allPredicateStrategy.stream().noneMatch(result -> result.test(number))) {
                System.out.println(number);
            }
        }

    }

    static class IsFizzBuzzNumber implements Predicate<Integer> {
        @Override
        public boolean test(Integer number) {
            return number % 3 == 0 && number % 5 == 0;
        }
    }

    static class IsFizzNumber implements Predicate<Integer> {
        @Override
        public boolean test(Integer number) {
            return number % 3 == 0;
        }
    }

    static class IsBuzzNumber implements Predicate<Integer> {
        @Override
        public boolean test(Integer number) {
            return number % 5 == 0;
        }
    }


}