import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import static java.lang.System.out;

class LifeStream
{
    static class LifeGridSource {
        public static int width, height = 1024;
        public static long lifeGridSize = 1048576;
        static {
            lifeGridSize = width * height;
        }
        public static Stream<Boolean> streamNewRandomGrid() {
            out.println(lifeGridSize);
            return Stream.generate(Math::random)
                .map(Math::round).limit(7)
                .map(x->x==0?new Boolean(true):new Boolean(false));
        }
    }

    public static void main(String[] args){
        Stream<Boolean> stream = LifeGridSource.streamNewRandomGrid();
        stream.forEach(out::println);
        int s = 3;
        Stream.generate(Math::random)
                .map(Math::round).limit(9)
                .map(x->x==0?new Boolean(true):new Boolean(false))
                .forEach(out::print);
    }
}
