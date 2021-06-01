package HomeworkAfterLesson3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Rectangle extends GeometricalFigure {

    private final double width;
    private final double height;

    @Override
    public String getName() {
        return "Прямоугольник";
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
