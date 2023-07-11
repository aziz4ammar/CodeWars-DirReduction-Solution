import java.util.*;

public class DirReduction {

    public static String[] dirReduc(String[] directions) {
        // Create a stack to store the reduced directions
        Stack<String> stack = new Stack<>();

        // Iterate over the directions
        for (String direction : directions) {
            if (!stack.isEmpty() && oppositeDirection(stack.peek()).equals(direction)) {
                // If the current direction cancels out the previous direction, remove the previous direction from the stack
                stack.pop();
            } else {
                // Otherwise, push the current direction to the stack
                stack.push(direction);
            }
        }

        // Convert the stack to an array and return it
        return stack.toArray(new String[0]);
    }

    private static String oppositeDirection(String direction) {
        // Return the opposite direction for a given direction
        switch (direction) {
            case "NORTH":
                return "SOUTH";
            case "SOUTH":
                return "NORTH";
            case "EAST":
                return "WEST";
            case "WEST":
                return "EAST";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        String[] directions = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
        String[] reducedDirections = dirReduc(directions);
        System.out.println(Arrays.toString(reducedDirections));
    }
}