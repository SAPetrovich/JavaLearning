package HomeworkAfterLesson3;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        ArrayList<GeometricalFigure> figures = new ArrayList<>();

        figures.add( new Square(5) );
        figures.add( new Rectangle( 2, 4) );
        figures.add( new Point() );
        System.out.println(figures);

        double totalArea = 0.0;
        for (GeometricalFigure figure : figures) {
            System.out.println(figure.getName() + " имеет площадь " + figure.getArea());
            totalArea += figure.getArea();
        }
        System.out.println("Общая площадь всех фигур " + totalArea);

    }

}
