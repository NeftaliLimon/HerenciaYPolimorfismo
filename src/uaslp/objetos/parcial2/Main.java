package uaslp.objetos.parcial2;

import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Modifier;

abstract class Figure {

    private static int figuresCreated;
    private final String name;

    protected Figure(String name) {
        this.name = name;
        figuresCreated++;
    }

    public abstract float getArea();

    public abstract float getPerimeter();

    public final String getName() {
        return name;
    }

    public static int getFiguresCreated() {
        return figuresCreated;
    }

}

class Circle extends Figure {
    private float radio;

    public Circle() {
        super("Circulo");

    }

    public Circle(float radio) {
        super("Circulo");
        this.radio = radio;
    }

    public float getArea() {
        return (float) (Math.PI * radio * radio);
    }

    public float getPerimeter() {
        return (float) (Math.PI * radio * 2);
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
}

class Rectangle extends Figure {
    private float base;
    private float height;

    public Rectangle() {
        super("Rectángulo");
    }

    public Rectangle(float base, float height) {
        super("Rectángulo");
        this.base = base;
        this.height = height;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getArea() {
        return base * height;
    }

    public float getPerimeter() {
        return (2 * base + 2 * height);
    }
}

class Polygon extends Figure {
    private float apotema;
    private int sidesCount;
    private float sideLenght;

    public Polygon(float apotema, int sidesCount, float sideLenght) {
        super("Polígno");
        this.apotema = apotema;
        this.sideLenght = sideLenght;
        this.sidesCount = sidesCount;
    }

    public float getArea() {
        return getPerimeter() * apotema / 2;
    }

    public float getPerimeter() {
        return sidesCount * sideLenght;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Figure> figureList = new LinkedList<>();

        figureList.add(new Polygon(4, 5, 6.3f));
        figureList.add(new Polygon(4.5f, 8, 3.9f));
        figureList.add(new Rectangle(4, 5));
        figureList.add(new Rectangle(4.5f, 9.6f));
        figureList.add(new Circle(5.3f));
        figureList.add(new Circle(10.6f));

        for (Figure figure : figureList) {
            System.out.println(figure.getName() + ", Area: " + figure.getArea() + ", Perímetro: " + figure.getPerimeter());
        }

        if (Modifier.isAbstract(Figure.class.getModifiers())) {
            System.out.println("Figure es abstracta");
        }

        System.out.println("Se generaron: " + Figure.getFiguresCreated() + " figuras");
    }/*Salida del programa:
Polígono, Area: 63.0, Perímetro: 31.5
Polígono, Area: 70.200005, Perímetro: 31.2
Rectángulo, Area: 20.0, Perímetro: 18.0
Rectángulo, Area: 43.2, Perímetro: 28.2
Círculo, Area: 88.247345, Perímetro: 33.300884
Círculo, Area: 352.98938, Perímetro: 66.60177
Figure es abstracta
Se generaron: 6 figuras
*/
}