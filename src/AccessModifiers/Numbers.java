package AccessModifiers;

public class Numbers {
    int number;
    int arr[];
    String name;

    public Numbers(int number, int[] arr, String name) {
        this.number = number;
        this.arr = arr;
        this.name = name;
    }

    public Numbers(int number, String name) {
        this.number = number;
        this.name = name;
    }

    Numbers(int number) {
        this.number = number;
    }

}
