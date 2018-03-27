/**
*
*@author s3365432  Qiaoxi LI 
*/
public class Dependent extends Person{
	
	    public String name;
	    public int age;
	    public Person parent1;
	    public Person parent2;

	    public Dependent(String name, int age ,Person a1,Person a2) {
			super(name, age);
			parent1 = a1;
			parent2 = a2;
		}
	    
	public Person getparent1(){
	  return parent1;
	}
	
	public void setparent1(Person parent1){
	  this. parent1 = parent1;
	}
	
	public Person getparent2(){
	  return parent2;
	}
	
	public void setparent2(Person parent2){
	  this.parent2 = parent2;
	}
	
	//public String toString(){
	//         return this.name + " " + this.age + " parents:  " + this.parent1.getName() + " and " + this.parent2.getName();
	//}
	
	public void add(Dependent child) {
		// TODO Auto-generated method stub
		
	}

}
