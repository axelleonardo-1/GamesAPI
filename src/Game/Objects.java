package Game;

/**
 * The Objects class is an abstract class representing game objects.
 * It provides properties and methods for the objects' position and movement.
 */
public abstract class Objects {

    /**
     * The x-coordinate of the object.
     */
    public int x;

    /**
     * The y-coordinate of the object.
     */
    public int y;

    /**
     * The width of the object.
     */
    public int width;

    /**
     * The height of the object.
     */
    public int height;

    /**
     * Constructs a new Objects object with the specified position and dimensions.
     *
     * @param x the x-coordinate of the object
     * @param y the y-coordinate of the object
     * @param width the width of the object
     * @param height the height of the object
     */
    public Objects(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Abstract method for moving the object.
     *
     * @param velocity the initial velocity of the object
     * @param acceleration the acceleration of the object
     * @return the updated position of the object
     */
    public abstract int move(int velocity, int acceleration);
}

