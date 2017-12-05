package entity;

public enum BerthType {
    
    BERTH("berth"), SUIT("suit"), COUPE("coupe");

    private BerthType(String content) {
        this.content = content;
    }
    private String content;

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

}
