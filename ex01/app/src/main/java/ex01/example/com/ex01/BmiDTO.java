package ex01.example.com.ex01;

import java.io.Serializable;

public class BmiDTO implements Serializable { //반드시 시리얼라이져블을 구현해야함.. 직렬화
    private String name;
    private int age;
    private double height;
    private double weight;
    private double bmi;
    private String result;

    //Control+enter (getter and setter )


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
