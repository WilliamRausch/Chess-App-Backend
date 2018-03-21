package io.javabrains.springbootstarter.Game;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class TestObj {
    @Id
    private String object;

    private int number;


    public List<testObj2> getTest2() {
        return test2;
    }

    public void setTest2(List<testObj2> test2) {
        this.test2 = test2;
    }

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)

  private List<testObj2> test2;





    public TestObj() {

    }

    public TestObj(String object, int number, List<testObj2> test2) {
        super();
        this.test2 = test2;
        this.object = object;
        this.number = number;
        this.test2.add(new testObj2(2));


    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
