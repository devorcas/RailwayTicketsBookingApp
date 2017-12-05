package access;


public enum AccessType {
    /**
     * Admin role
     */
    ADMIN("admin"),
    
    /**
     * User role
     */
    USER("user"),
    
    /**
     * Guest role
     */
    GUEST("guest");

    private String content;

    private AccessType(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
