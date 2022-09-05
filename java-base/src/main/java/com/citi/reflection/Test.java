package com.citi.reflection;

public class Test {
  public static void main(String[] args) throws ClassNotFoundException {
    // 方式一
    Class c1 = Class.forName("com.citi.reflection.User");

    // 方式二
    User user = new User();
    Class c2 = user.getClass();

    //方式三
    Class<User> c3 = User.class;


  }
}

class User {
  private String name;
  private Integer age;
  private Integer id;

  public User() {}

  public User(String name, Integer age, Integer id) {
    this.name = name;
    this.age = age;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "User{" + "name='" + name + '\'' + ", age=" + age + ", id=" + id + '}';
  }
}
