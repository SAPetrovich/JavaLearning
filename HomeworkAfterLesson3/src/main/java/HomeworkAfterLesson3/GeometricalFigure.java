package HomeworkAfterLesson3;

public abstract class GeometricalFigure implements CalculatingPerimeter, CalculatingArea {

    public abstract String getName();

    @Override
    public String toString() {
        return "GeometricalFigure(name=" +getName() + ")";
    }
}

