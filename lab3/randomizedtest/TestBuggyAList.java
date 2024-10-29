package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();
          correct.addLast(1);
          correct.addLast(2);
          correct.addLast(3);

          broken.addLast(1);
          broken.addLast(2);
          broken.addLast(3);

          assertEquals(broken.size(), correct.size());
          assertEquals(correct.removeLast(), broken.removeLast());
          assertEquals(correct.removeLast(), broken.removeLast());
          assertEquals(correct.removeLast(), broken.removeLast());
  }

  @Test
    public void randomizedTest() {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> B = new BuggyAList<>();
      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              B.addLast(randVal);
              System.out.println("addLast(" + randVal + ")");
          } else if (operationNumber == 1) {
              // size
              int sizeL = L.size();
              int sizeB = B.size();
              System.out.println("sizeL: " + sizeL);
              System.out.println("sizeB: " + sizeB);
              assertEquals(sizeL, sizeB);
          } else if (operationNumber == 2 && L.size() > 0 && B.size() > 0) {
              int lLast = L.getLast();
              int bLast = B.getLast();
              assertEquals(lLast, bLast);
          } else if (operationNumber == 3 && L.size() > 0 && B.size() > 0) {
              int lLast = L.removeLast();
              int bLast = B.removeLast();
              assertEquals(lLast, bLast);
          }
      }
  }
}
