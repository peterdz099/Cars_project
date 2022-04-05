import java.lang.Math;

public class Pozycja {
    private double x;
    private double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void przemiesc(double V, double dt, Pozycja cel) {

        if (cel.getX() != this.x || cel.getY() != this.y) {
            double dx = (V * dt / 10000 * (cel.getX() - this.x)) / ((Math.sqrt(Math.pow(cel.getX() - this.x, 2) + Math.pow(cel.getY() - this.y, 2))));
            double dy = (V * dt / 10000 * (cel.getY() - this.y)) / ((Math.sqrt(Math.pow(cel.getX() - this.x, 2) + Math.pow(cel.getY() - this.y, 2))));
            if (dx > Math.abs(cel.getX()-x)){
                setX(cel.getX());
            }else{
                setX(x + dx);
            }
            if (dy > Math.abs(cel.getY()-y)) {
                setY(cel.getY());
            } else {
                setY(y + dy);
            }
        }
    }
}
