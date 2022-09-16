package org.ftc17191.ftclayer.kgmotion.motion;

public class Position
{
    /*
       0, 0 is the origin, or the middle  of the field
       Instead of using inches, we use centimeters. Everything else is the same as FTC's coordinate system
       Imagine you are standing on the red side, the y-axis goes across the field from you to the other wall,
       The X axis goes from your left side to your right side
     */
    public double x; // CM
    public double y; // CM
    public double rotation; // Degrees, just for ease of use

    public Position(double x, double y, double rotation)
    {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }
}
