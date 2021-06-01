package HomeworkAfterLesson3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Square extends GeometricalFigure {

    private final double side;

    @Override
    public String getName() {
        return "Квадрат";
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
