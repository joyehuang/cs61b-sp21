package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int length = 1000;
        for (int i = 0; i < 8; i ++){
            if (i > 0) {
                length *= 2;
            }
            Ns.addLast(length);
            Stopwatch sw = new Stopwatch();
            AList<Integer> testAlist = new AList<>();
            for (int j = 0; j < length; j ++){
                testAlist.addLast(1);
            }
            double timeInSecond = sw.elapsedTime();
            times.addLast(timeInSecond);
            opCounts.addLast(length);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
