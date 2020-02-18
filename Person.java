package testquicksort;

public class Person {

	private String city;
	private String name;
	private String[] cities;
	private String[] names;
	
	public Person() {
		
	}
	
	public Person(String name, String city) {
		this.city = city;
		this.name = name;
	}

	public String[] getCities() {
		return cities;
	}

	public void setCities(String[] cities) {
		this.cities = cities;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sortFromCityToName(Person[] persons) {
		int personsLength = persons.length;
		MySortAlgorithrm sort = new MySortAlgorithrm();
		String[] cities = new String[personsLength];
		String[] names = new String[personsLength];
		for (int i = 0; i < personsLength; i++) {
			cities[i] = persons[i].getCity();
			names[i] = persons[i].getName();
		}
		sort.quickSort(cities);
		setCities(cities);

		for (int i = 0; i < personsLength - 1; i++) {
			if (cities[i] == cities[i + 1]) {
				int j = i;
				while (j < personsLength) {
					if (cities[j] != cities[j + 1])
						break;
					j++;
				}
				names = sort.quickSortRecusion(names, i, j);
			}
		}
		setNames(names);
	}

}
