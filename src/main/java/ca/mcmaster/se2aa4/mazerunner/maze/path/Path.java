package ca.mcmaster.se2aa4.mazerunner.maze.path;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Path implements Iterable<PathInstruction> {
    private List<PathInstruction> path;

    public Path(String path) {
        this.path = new LinkedList<>();
        parsePath(path);
    }

    private void parsePath(String path) {
        // Iterate through the path string
        int number = -1;
        for (int i = 0; i < path.length(); i++) {
            char current = path.charAt(i);
            // If the character is a digit, store it in the number variable
            if (Character.isDigit(current)) {
                if (number == -1) {
                    number = Character.getNumericValue(path.charAt(i));
                } else {
                    number *= 10;
                    number += Character.getNumericValue(path.charAt(i));
                }
                // If the character is an F, L, or R, append it to the builder
            } else if (current != ' ') {
                // If the number variable is greater than 0, append the character to the builder
                // that many times
                if (number > 0) {
                    for (int j = 0; j < number; j++) {
                        this.path.add(PathInstruction.fromCharacter(path.charAt(i)));
                    }
                    number = -1;
                } else {
                    // If the number variable is not greater than 0, append the character to the
                    // builder
                    this.path.add(PathInstruction.fromCharacter(path.charAt(i)));
                }
            }
        }
    }

    @Override
    public Iterator<PathInstruction> iterator() {
        return path.iterator();
    }

    public String toFactoredForm() {
        return toFactoredForm(false);
    }

    public String toFactoredForm(boolean withSpaces) {
        if (path.isEmpty())
            return "";

        // Create a StringBuilder to store the factored path
        StringBuilder builder = new StringBuilder();
        // Create a variable to store the current character
        PathInstruction current = path.get(0);
        int count = 1;

        // Iterate through the path string
        for (int i = 1; i < path.size(); i++) {
            // If the character is the same as the current character, increment the number
            // variable
            if (path.get(i).equals(current)) {
                count++;
                // If the character is a space, skip it
            } else {
                // If the character is different from the current character, append the current
                if (count > 1)
                    builder.append(count);
                builder.append(current.toString());

                // Add a space if needed
                if (withSpaces)
                    builder.append(" ");

                // Reset the count and set the current character
                current = path.get(i);
                count = 1;
            }
        }

        // Add the last character
        if (count > 1)
            builder.append(count);
        builder.append(current.toString());

        return builder.toString();
    }

    public String toCanonicalForm() {
        return toCanonicalForm(false);
    }

    public String toCanonicalForm(boolean withSpaces) {
        if (path.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        // Iterate through the path string
        PathInstruction current = path.get(0);
        sb.append(current.toString());
        // If the character is a space, skip it
        for (int i = 1; i < path.size(); i++) {
            // If the character is different from the current character
            if (!path.get(i).equals(current)) {
                // Add a space if needed
                if (withSpaces)
                    sb.append(" ");
            }

            // Append the current character
            sb.append(path.get(i).toString());
            current = path.get(i);
        }

        // Add a space if needed
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Path other = (Path) obj;

        // Compare the size of the two paths
        if (path.size() != other.path.size())
            return false;

        // Compare the elements of the two paths
        Iterator<PathInstruction> thisIterator = this.path.iterator();
        Iterator<PathInstruction> otherIterator = other.path.iterator();

        // If all elements are equal, return true
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            PathInstruction thisInstruction = thisIterator.next();
            PathInstruction otherInstruction = otherIterator.next();

            // Compare the two instructions
            if (!thisInstruction.equals(otherInstruction))
                return false;
        }

        // If one iterator has more elements than the other, return false
        if (thisIterator.hasNext() || otherIterator.hasNext())
            return false;

        return true;
    }

    public boolean isSamePath(String path) {
        return equals(new Path(path));
    }

    @Override
    public String toString() {
        return toFactoredForm();
    }
}
