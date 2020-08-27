//만든이: 최 철녕
package data;

public class Money {
   private int name;
   private int num;
   public Money(int name ,int num) {
      this.name = name;
      this.num = num;
   }
public int getName() {
	return name;
}
public void setName(int name) {
	this.name = name;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
}