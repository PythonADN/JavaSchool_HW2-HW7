package HW_6.reflection.task_3;

import java.lang.annotation.*;

//@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
}
