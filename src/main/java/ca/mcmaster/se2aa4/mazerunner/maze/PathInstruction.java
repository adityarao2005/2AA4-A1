package ca.mcmaster.se2aa4.mazerunner.maze;

public enum PathInstruction {
    FORWARD('F'), LEFT('L'), RIGHT('R');

    private char symbol;

    private PathInstruction(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    public char toCharacter() {
        return symbol;
    }

    public static PathInstruction fromString(String symbol) {
        for (PathInstruction instruction : PathInstruction.values()) {
            if (instruction.toString().equals(symbol)) {
                return instruction;
            }
        }
        throw new IllegalArgumentException("Invalid path instruction: " + symbol);
    }

    public static PathInstruction fromCharacter(char symbol) {
        for (PathInstruction instruction : PathInstruction.values()) {
            if (instruction.symbol == symbol) {
                return instruction;
            }
        }
        throw new IllegalArgumentException("Invalid path instruction: " + symbol);
    }
}
