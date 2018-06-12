package com.mayankbathla.studentdatabase2;

public class StudentModel {
    String name;
    int id;

    public StudentModel(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public StudentModel(String name) {
        this.id = id;
        this.name = name;

    }

    public StudentModel() {

    }


    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }


    public void setName(String name)
    {
        this.name = name;
    }



    public void setId(int id)
    {
        this.id = id;
    }

}
