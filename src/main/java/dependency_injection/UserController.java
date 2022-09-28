package dependency_injection;

public class UserController {
    private MessageService messageService;
    public UserController(MessageService messageService1){
        this.messageService = messageService1;
    }
    public void send(){
        messageService.sendMessage(" Hello Dependency Injection");
    }
}
