package beans;

/**
 * <p><strong>Executive Summary</strong><br>
 *
 * <p><strong>State Information</strong><br>
 *
 * <p><strong>Implementational Details</strong><br>
 *
 * <p><strong>Created</strong> on: Jul 19, 2018
 *
 * @author Vladimir Kremnyov (vkre@isddesign.com)
 */
public class Client {

    private String id;
    private String fullName;
    private String greeting;

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}


