package io.javabrains.springbootstarter.Game;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class testObj2{
    @Id
    private int embTest;

    public testObj2(int embTest) {
        this.embTest = embTest;
    }

    public testObj2() {
    }

    public int getEmbTest() {
        return embTest;
    }

    public void setEmbTest(int embTest) {
        this.embTest = embTest;
    }
}
