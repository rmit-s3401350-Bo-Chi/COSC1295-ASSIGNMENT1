import java.util.ArrayList;
/**
*
*@author s3365432  Qiaoxi LI 
*/

public class Person {
	private String name;
	private int age;
	private String status;
	
	public ArrayList<Person> friends= new ArrayList<Person>();
	
	public  Person(String name,int age) {
		//super();
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public double getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
		
	}
	 public ArrayList<Person> getFriends(){
	        return friends;
    }
	 
	 public  String toString() {
		 
		 return this.name + " Age: " + this.age + " " + this.status;
	 }
	
}
