package food.entity;

public class Account {
    private int id;
    private String username;
    private String password;
    private String membercardId;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;
    private int memberid;

    public Account() {
    }

    public Account(int id, String username, String password, String membercardId, long createdAt, long updatedAt, long deletedAt, int status, int memberid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.membercardId = membercardId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.status = status;
        this.memberid = memberid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMembercardId() {
        return membercardId;
    }

    public void setMembercardId(String membercardId) {
        this.membercardId = membercardId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }
}
