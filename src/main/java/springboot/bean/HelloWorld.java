package springboot.bean;

public class HelloWorld {
private String message;

    public HelloWorld() {
    }

    public HelloWorld(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void initialization(){
        System.out.println("Init: start doing ");
    }
    public void destroy(){
        System.out.println("Destroy : start doing");
    }
}
