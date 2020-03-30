import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import static java.lang.System.out;

class LifeStream
{
    static class GridSource {
        public static int width, height = 1024;
        public static long gridSize = 1048576;

        public static Stream<Boolean> streamNewRandomGrid() {
            return Stream.generate(Math::random)
                .map(Math::round).limit(gridSize)
                .map(x->x==0?new Boolean(true):new Boolean(false));
        }
    }

    public void testGridSource() {
        Stream<Boolean> stream = GridSource.streamNewRandomGrid();
        long sum = stream
            .map((x)->x?1:0)
            .mapToInt(Integer::intValue)
            .sum();
        long oneHalf = GridSource.gridSize/2;
        long difference = Math.abs(oneHalf - sum);
        long onePercent = GridSource.gridSize / 100;
        //differance is less then one percent of the grid size
        assert(difference < onePercent);
    }

    public static void print(Stream<Boolean> stream){
        long sum = stream
            .map((x)->x?1:0)
            .mapToInt(Integer::intValue)
            .sum();
        out.println(sum + " sum");
        long oneHalf = GridSource.gridSize/2;
        out.println(oneHalf + " one half");
        long difference = Math.abs(oneHalf - sum);
        out.println(difference + " difference");
        long onePercent = GridSource.gridSize / 100;
        out.println(onePercent + " one percent");
    }

    public static void main(String[] args){
        LifeStream lifeStream = new LifeStream();
        lifeStream.testGridSource();
        print(GridSource.streamNewRandomGrid());
    }
}
