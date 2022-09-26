package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) {
//        tao object ma khong dung tu khoa new
        try {
            Class<?> classStudent = Class.forName("reflection.Student");
            try {
                Student st = (Student) classStudent.newInstance();
//                st.getName
                Method[] methods = classStudent.getMethods();
                for (Method method: methods) {
                    System.out.println(method.getName());
                    if(method.getName().equals("setName")){
                        method.invoke(st , new String[] {"Nguyễn Văn A"});
                    };
                }
                System.out.println(st.getName());

//                cd: -> biến Private những vẫn truy cập được
                System.out.println("***********************");
                Field [] fields = classStudent.getDeclaredFields();
                for (Field f: fields
                     ) {
                    System.out.println(f.getName());
                    if(f.getName().equals("age")){
                        f.setAccessible(true);
                        f.setInt(st,25); // gán cứng cho st.age = 25(age)
                    }
                    System.out.println("age = " + st.getAge());
                }

            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
