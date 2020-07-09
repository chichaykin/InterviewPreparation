package leetcode.facebook;

import java.util.HashMap;
import java.util.Map;


public interface Robot {
     // Returns true if the cell in front is open and robot moves into the cell.
     // Returns false if the cell in front is blocked and robot stays in the current cell.
     public boolean move();

     // Robot will stay in the same cell after calling turnLeft/turnRight.
     // Each turn will be 90 degrees.
     public void turnLeft();
     public void turnRight();

     // Clean the current cell.
     public void clean();
 }

// enum Direction {
//    left(270), right(90), up(0), down(180);
// }

class RobotImpl {
//    int x, y;
//    //Direction curDir = up;
//    Map<Integer, Integer> map = new HashMap<>();
//
//    public void cleanRoom(Robot robot) {
//        move(robot, up);
//        move(robot, down);
//        move(robot, left);
//        move(robot, right);
//    }
//
//    public void move(Robot robot, Direction dir) {
//        if (!map.containsKey(hashCode(x, y))) {
//            robot.clean();
//        }
//        while(curDir != dir) {
//            robot.turnRight(); curDir = -90
//        }
//        if (robot.move()) {
//
//        }
//    }
//
//    boolean allVisited() {
//        int cells = (bottom - top + 1) * (right - left + 1);
//        return map.size() == cells;
//    }
//
//    int hashCode(int x, int y) {
//        int result = x;
//        result = 31 * result + y;
//        return result;
//    }
}
