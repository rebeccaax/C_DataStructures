package unit4.day1;
public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        setLength(length);
        setWidth(width);

    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length == 0) {
            RuntimeException ex = new RuntimeException ("Length must be postive.");
            throw ex;
        }
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            throw new RuntimeException ("Width must be postive.");
        }
        this.width = width;
    }


}
