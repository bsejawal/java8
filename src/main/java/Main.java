import com.bsejawal.generics.Box;
import com.bsejawal.generics.Pair;

class Main {
    public static void main(String[] args) {

        Box<Integer> box = new Box<>(10);
//        box.setValue(20);
        System.out.println(box.getValue());

        Pair<String, Integer> pair = new Pair<>("Hello", 10);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

    }
}