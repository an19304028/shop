package mysqltest;

import java.io.Serializable;

public class Bean implements Serializable{
  private String name;
  private String pass;

  public Bean(){}

  public void setName(String name) {
    this.name=name;
  }
  public String getName(){
    return name;
  }
  public void setPass(String pass){
    this.pass=pass;
  }
  public String getPass(){
    return pass;
  }
}
