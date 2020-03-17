package food.entity;

public class Member {
    private int id;
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private String gender;

    public Member() {
    }

    public Member(int id, String fullname, String address, String phone, String email, String gender) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public enum Gender{
        FEMALE("female"),MALE("male"),OTHERS("others");

        private String value;

        Gender(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Gender findByValue(String value){
            for (Gender gender : Gender.values()){
                if(gender.value == value){
                    return gender;
                }
            }
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
