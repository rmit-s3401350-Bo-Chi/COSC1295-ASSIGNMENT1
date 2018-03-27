import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
*
*@author s3365432  Qiaoxi LI 
*/

public class Driver {

	private static Set<String> adultFriends = new HashSet<>();
	private static Set<String> dependentFriends = new HashSet<>();
	private static List<Person> allPeople = new ArrayList<>();
	private static List<Adult> allAdult = new ArrayList<>();
	private static List<Dependent> allChild = new ArrayList<>();

	public Driver() {

	}


	/**
	 * add person to the list
	 * @param p
	 */

	public void addPersonToNetwork(Person p) {

		allPeople.add(p);

	}
	
	public void addAdultToNetwork(Adult p) {

		allAdult.add(p);

	}
	
	public void addChildToNetwork(Dependent p) {

		allChild.add(p);

	}



	/**

	 * search a person by name

	 * @param name

	 * @return

	 */

	public Person selectPersonByName(String name) {

		for (Person p: allPeople) {
			if (name.equals(p.getName())) {
				return p;
			}
		}
		return null;
	}

	/**

	 * two adults make friend

	 * @param a1

	 * @param a2

	 */

	public void makeFriends(Adult a1, Adult a2) {

		adultFriends.add(a1.getName() + "-" + a2.getName());
		a1.friends.add(a2);
		a2.friends.add(a1);

	}



	/**

	 * two dependent make friend

	 * @param d1

	 * @param d2

	 */

	public void makeFriends(Dependent d1, Dependent d2) {

		if (d1.getAge() < 3) {

			throw new IllegalArgumentException("Dependent " + d1.getName() + " is too young to have a friend.");

		} else if (d2.getAge() < 3) {

			throw new IllegalArgumentException("Dependent " + d2.getName() + " is too young to have a friend.");

		} else if (Math.abs(d2.getAge() - d1.getAge()) > 3) {

			throw new IllegalArgumentException("The age difference between these two young friends cannot be more than 3 years.");

		}

		dependentFriends.add(d1.getName() + "-" + d2.getName());
		d1.friends.add(d2);
		d2.friends.add(d1);

	}



	/**

	 * two person make friend

	 * @param p1

	 * @param p2

	 */

	public void makeFriends(Person p1, Person p2) {

		if (p1 instanceof Adult && p2 instanceof Adult) {

			makeFriends((Adult)p1, (Adult)p2);
			
			System.out.println("Adult " + p1.getName()+ " and " + p2.getName() + " are friends now.");

			return;

		}



		if (p1 instanceof Dependent && p2 instanceof Dependent) {

			makeFriends((Dependent)p1, (Dependent)p2);

			System.out.println("Dependent " + p1.getName()+ " and " + p2.getName() + " are friends now.");

			return;

		}

		System.out.println("Adult cannot make friends with dependent.");

	}



	/**

	 * check if two adults are friends

	 * @param a1

	 * @param a2

	 * @return

	 */

	public boolean checkFriendship(Adult a1, Adult a2) {

		if (adultFriends.contains(a1.getName() + "-" + a2.getName())) {

			return true;

		}

		if (adultFriends.contains(a2.getName() + "-" + a1.getName())) {

			return true;

		}
		
		for(int i=0;i<a1.friends.size();i++) {
			for(int j=0;j<a2.friends.size();j++) {
				if(a1.friends.get(i).getName().equals(a2.friends.get(i).getName()))
					return true;
			}
		}

		return false;

	}



	/**

	 * check if two dependents are friends

	 * @param d1

	 * @param d2

	 * @return

	 */

	public boolean checkFriendship(Dependent d1, Dependent d2) {

		if (dependentFriends.contains(d1.getName() + "-" + d2.getName())) {

			return true;

		}

		if (dependentFriends.contains(d2.getName() + "-" + d1.getName())) {

			return true;

		}
		
		for(int i=0;i<d1.friends.size();i++) {
			for(int j=0;j<d2.friends.size();j++) {
				if(d1.friends.get(i).getName().equals(d2.friends.get(i).getName()))
					return true;
			}
		}

		return false;
	}



	/**

	 * check if two person are friends

	 * @param p1

	 * @param p2

	 * @return

	 */

	public boolean checkFriendship(Person p1, Person p2) {

		if (p1 instanceof Adult && p2 instanceof Adult) {

			return checkFriendship((Adult)p1, (Adult)p2);

		}



		if (p1 instanceof Dependent && p2 instanceof Dependent) {

			return checkFriendship((Dependent)p1, (Dependent)p2);

		}
		return false;

	}





	/**

	 * get all adults

	 * @return

	 */

	public List<Adult> getAllAdults() {

		return allAdult;
	}



	/**

	 * get all dependents

	 * @return

	 */

	public List<Dependent> getAllDependents() {

		return allChild;
	}



	/**

	 * get all people

	 * @return

	 */

	public List<Person> getAllPeople() {

		return allPeople;

	}

}
