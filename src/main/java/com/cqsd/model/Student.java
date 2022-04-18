package com.cqsd.model;

public class Student {
    private String name;
    private String age;
    private int id;

    private Student(final String name, String age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Student setAge(String age) {
        this.age = age;
        return this;
    }

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                '}';
    }

    public static class Bulider {
        private String name;
        private String age;
        private int id;

        public String getName() {
            return name;
        }

        public Bulider setName(String name) {
            this.name = name;
            return this;
        }

        public String getAge() {
            return age;
        }

        public Bulider setAge(String age) {
            this.age = age;
            return this;
        }

        public int getId() {
            return id;
        }

        public Bulider setId(int id) {
            this.id = id;
            return this;
        }

        public Student build(){
            return new Student(name, age, id);
        }
    }
}
