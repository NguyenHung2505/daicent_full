package reflection;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface ProductAnnotation {
    String idProduct () default "";
    String name() default "";
    String price() default "";
    String quantity () default "";
}
