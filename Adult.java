
import java.util.*;


public class Adult extends Person{
	
	public Adult(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
	private Adult spouse;
	
	private List<Dependent> child;

	public Adult getSpouse() {
		return spouse;
	}
	
	public void setSpouse(Adult spouse) {
		if (this.spouse != null && spouse != this.spouse) {
			throw new IllegalArgumentException("we are not find that data");
		}
	}
	
	public List<Dependent>getChild(){
		return child;
	}
	
    public void setChildren(List<Dependent> child)
    {
        this.child = child;
    }
    
    public void addChildren(Dependent child)
    {
        child.add(child);
    }
}
