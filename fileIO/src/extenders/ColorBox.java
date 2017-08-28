package extenders;

/**
 * Created by Vardan on 07.08.2017.
 */
public class ColorBox extends Box {
    int color;
    double weight;

    public ColorBox(double w, double h, double d, int color, double m) {
        super(w, h, d);
        this.color = color;
        weight=m;
    }

    public ColorBox(int color, double weight) {
        this.color = color;
        this.weight = weight;
    }
}
