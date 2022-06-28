package Hanged.Man.Utility;

public enum Colors{
    RED("[1;31m"), GREEN("[1;32m"), YELLOW("[1;33m"), RESET("[0m");

    private final String color;

    public String getColor() {
        return Colors.valueOf(color).toString();
    }

    Colors(String color) {
        return Colors.valueOf(color).toString();
    }
}
