package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Driver {
   
    /* **/
    private abstract class Person{
	 	private int age;
	 	private String fname;
	 	private String lname;
	 	
	 	// * Constructor * //
	 	
	 	public Person(int age,String fname,String lname){
	 		this.age = age;
	 		this.fname = fname;
	 		this.lname = lname;
	 	}
	 	
	 	public String getFname() {
            return fname;
        }

        public String getLname() {
            return lname;
        }

        public int getAge() {
            return age;
        }
	 	
        @Override
        public String toString() {
            return "FirstName: "+getFname()+ "\t LastName: " + getLname() +" "+ "\tAge: "+getAge();
        }
 	
    }
	
    private class Employee extends Person{
    	private int emp_id;
		private double wage;
 	
		Employee(int emp_id,int age, String fname, String lname,double wage) {
			super(age, fname, lname);
			this.emp_id = emp_id;
			this.wage = wage;
			// TODO Auto-generated constructor stub
		}
	
	 	public int getEmpId() {
	 		return emp_id;
	 	}
	 	
	 	public double getWage() {
	 		return wage;
	 	}
		
 	
	 	@Override
        public String toString() {
            return "Emp ID: "+getEmpId()+ "\tFirstName: " + getFname() +" "+ "\tLastName: "+getLname()+" "+ "\tAge: "+getAge()+" "+ "\tWage: "+getWage();
        }
    }
    
    /* ***/
    
    private interface Sellable {
        public double getPrice();
        public String getName();
        public int getId();
    }

    private static class Item implements Sellable {
        private int id;
        private String name;
        private double price;

        public Item(String itemData) {
            String[] itemDatas = itemData.split(",");
            this.id = Integer.parseInt(itemDatas[0]);
            this.price = Double.parseDouble(itemDatas[1]);
            this.name = itemDatas[2];
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "ID: "+getId()+ "ItemName: " + getName() +" "+ "Price: "+getPrice();
        }
    }
    
    /**
     * StoreAPI interface
     */
    private interface StoreAPI {
        void add(Person person);
        void add(Sellable item);
        void sortEmployees(Comparator<Person> c);
        void sortItems(Comparator<Sellable> c);
    }
   
    private class Store implements StoreAPI  {
    	
    	private List<Sellable> items;
    	private List<Person> employee;

        public Store() {
        	employee = new ArrayList<>();
            items = new ArrayList<>();
        }
    	@Override
		public void add(Person person) {
			// TODO Auto-generated method stub
    		employee.add(person);
		}

		@Override
		public void add(Sellable item) {
			// TODO Auto-generated method stub
			items.add(item);
		}

		@Override
		public void sortEmployees(Comparator<Person> c) {
			// TODO Auto-generated method stub
			employee.sort(c);
		}

		@Override
		public void sortItems(Comparator<Sellable> c) {
			// TODO Auto-generated method stub
			items.sort(c);
		}
		
		@Override
        public String toString() {
            StringBuilder sbl = new StringBuilder();
            sbl.append("Employee names: \n");
            employee.forEach(employee -> sbl.append(employee.toString() + "\n"));
            sbl.append("Items: \n");
            items.forEach(item -> sbl.append(item.toString() + "\n"));
            return sbl.toString();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("CSYE6200 Midterm July 2022 ...");
        
        Driver driver = new Driver();
        Store store = driver.new Store();
        
        store.add(driver.new Employee(3,21,"James","Pope",12.99));
        store.add(driver.new Employee(1,31,"Bob","James",15.99));
        store.add(driver.new Employee(2,27,"Don","Hope",14.99));
        
        store.add(new Item("3,1.49,Wheat Bread"));
        store.add(new Item("1,3.49,OJ"));
        store.add(new Item("2,2.49,Skim Milk"));
        

        System.out.println("-------------Sort employees by person id----------------");
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                Employee e1 = (Employee) p1;
                Employee e2 = (Employee) p2;
                return e1.getEmpId() - e2.getEmpId();
            }
        });
        System.out.println("---------------Sort items by item id------------------");
        store.sortItems(new Comparator<Sellable>() {
            @Override
            public int compare(Sellable s1, Sellable s2) {
                Item i1 = (Item) s1;
                Item i2 = (Item) s2;
                return i1.getId() - i2.getId();
            }
        });
        System.out.println(store);

        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        System.out.println("----------------Sort employees by person's last name--------------------");
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                Employee e1 = (Employee) p1;
                Employee e2 = (Employee) p2;
                return e1.getLname().compareTo(e2.getLname());
            }
        });
        System.out.println("------------------Sort items by item name-------------------");
        store.sortItems(new Comparator<Sellable>() {
            @Override
            public int compare(Sellable s1, Sellable s2) {
                Item i1 = (Item) s1;
                Item i2 = (Item) s2;
                return i1.getName().compareTo(i2.getName());
            }
        });
        System.out.println(store);

        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        System.out.println("-------------------Sort employees by person's first name---------------");
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                Employee e1 = (Employee) p1;
                Employee e2 = (Employee) p2;
                return e1.getFname().compareTo(e2.getFname());
            }
        });

        System.out.println("----------------------Sort items by item price-------------------");
        store.sortItems(new Comparator<Sellable>() {
            @Override
            public int compare(Sellable s1, Sellable s2) {
                Item i1 = (Item) s1;
                Item i2 = (Item) s2;
                return Double.compare(i1.getPrice(), i2.getPrice());
            }
        });
        System.out.println(store);

        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        System.out.println("----------------------Sort employees by PERSON AGE (YOUNGEST FIRST)...---------------------");
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                Employee e1 = (Employee) p1;
                Employee e2 = (Employee) p2;
                return e1.getAge() - e2.getAge();
            }
        });
        System.out.println(store);

        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        System.out.println("Sort employees by PERSON AGE (OLDEST FIRST)...");
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                Employee e1 = (Employee) p1;
                Employee e2 = (Employee) p2;
                return e2.getAge() - e1.getAge();
            }
        });
        System.out.println(store);

        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        System.out.println("Sort employees by HIGHEST WAGE...");
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                Employee e1 = (Employee) p1;
                Employee e2 = (Employee) p2;
                return Double.compare(e2.getWage(), e1.getWage());
            }
        });
        System.out.println(store);

        System.out.println("CSYE6200 Midterm July 2022 ... done!");   
    }
}


/* output */
//CSYE6200 Midterm July 2022 ...
//-------------Sort employees by person id----------------
//---------------Sort items by item id------------------
//Employee names: 
//Emp ID: 1	FirstName: Bob 	LastName: James 	Age: 31 	Wage: 15.99
//Emp ID: 2	FirstName: Don 	LastName: Hope 	Age: 27 	Wage: 14.99
//Emp ID: 3	FirstName: James 	LastName: Pope 	Age: 21 	Wage: 12.99
//Items: 
//ID: 1ItemName: OJ Price: 3.49
//ID: 2ItemName: Skim Milk Price: 2.49
//ID: 3ItemName: Wheat Bread Price: 1.49
//
//---------------------------------------------------------------------------------------------------------------------
//----------------Sort employees by person's last name--------------------
//------------------Sort items by item name-------------------
//Employee names: 
//Emp ID: 2	FirstName: Don 	LastName: Hope 	Age: 27 	Wage: 14.99
//Emp ID: 1	FirstName: Bob 	LastName: James 	Age: 31 	Wage: 15.99
//Emp ID: 3	FirstName: James 	LastName: Pope 	Age: 21 	Wage: 12.99
//Items: 
//ID: 1ItemName: OJ Price: 3.49
//ID: 2ItemName: Skim Milk Price: 2.49
//ID: 3ItemName: Wheat Bread Price: 1.49
//
//---------------------------------------------------------------------------------------------------------------------
//-------------------Sort employees by person's first name---------------
//----------------------Sort items by item price-------------------
//Employee names: 
//Emp ID: 1	FirstName: Bob 	LastName: James 	Age: 31 	Wage: 15.99
//Emp ID: 2	FirstName: Don 	LastName: Hope 	Age: 27 	Wage: 14.99
//Emp ID: 3	FirstName: James 	LastName: Pope 	Age: 21 	Wage: 12.99
//Items: 
//ID: 3ItemName: Wheat Bread Price: 1.49
//ID: 2ItemName: Skim Milk Price: 2.49
//ID: 1ItemName: OJ Price: 3.49
//
//---------------------------------------------------------------------------------------------------------------------
//----------------------Sort employees by PERSON AGE (YOUNGEST FIRST)...---------------------
//Employee names: 
//Emp ID: 3	FirstName: James 	LastName: Pope 	Age: 21 	Wage: 12.99
//Emp ID: 2	FirstName: Don 	LastName: Hope 	Age: 27 	Wage: 14.99
//Emp ID: 1	FirstName: Bob 	LastName: James 	Age: 31 	Wage: 15.99
//Items: 
//ID: 3ItemName: Wheat Bread Price: 1.49
//ID: 2ItemName: Skim Milk Price: 2.49
//ID: 1ItemName: OJ Price: 3.49
//
//---------------------------------------------------------------------------------------------------------------------
//Sort employees by PERSON AGE (OLDEST FIRST)...
//Employee names: 
//Emp ID: 1	FirstName: Bob 	LastName: James 	Age: 31 	Wage: 15.99
//Emp ID: 2	FirstName: Don 	LastName: Hope 	Age: 27 	Wage: 14.99
//Emp ID: 3	FirstName: James 	LastName: Pope 	Age: 21 	Wage: 12.99
//Items: 
//ID: 3ItemName: Wheat Bread Price: 1.49
//ID: 2ItemName: Skim Milk Price: 2.49
//ID: 1ItemName: OJ Price: 3.49
//
//---------------------------------------------------------------------------------------------------------------------
//Sort employees by HIGHEST WAGE...
//Employee names: 
//Emp ID: 1	FirstName: Bob 	LastName: James 	Age: 31 	Wage: 15.99
//Emp ID: 2	FirstName: Don 	LastName: Hope 	Age: 27 	Wage: 14.99
//Emp ID: 3	FirstName: James 	LastName: Pope 	Age: 21 	Wage: 12.99
//Items: 
//ID: 3ItemName: Wheat Bread Price: 1.49
//ID: 2ItemName: Skim Milk Price: 2.49
//ID: 1ItemName: OJ Price: 3.49
//
//CSYE6200 Midterm July 2022 ... done!