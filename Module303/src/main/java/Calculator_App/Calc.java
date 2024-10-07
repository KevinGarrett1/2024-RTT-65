package Calculator_App;

// Define the functional interface
@FunctionalInterface
public interface Calc<T, R> {
    R compute(T[] intArray); // This method takes an array of type T and returns a type R
}
