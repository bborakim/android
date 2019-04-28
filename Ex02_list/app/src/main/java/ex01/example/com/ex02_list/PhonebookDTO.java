package ex01.example.com.ex02_list;

public class PhonebookDTO {
    private String name;
    private String tel;

    //기본생성자
    public PhonebookDTO() {
    }

    public PhonebookDTO(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
