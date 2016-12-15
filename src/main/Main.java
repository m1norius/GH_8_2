package main;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) {
		
		/*
		 	int maxCount;
			String model;
			String type;
			String color;
			int maxSpeed;
		 */
		
		
		
		Car car1 = new Car(38, "m3", "sedan", "black", 230);
		Car car2 = new Car(34, "m5", "sedan", "red", 230);
		
		compare(car1, car2);
		
	}
	
	public static void compare(Car car1, Car car2){
	
		Class<Car> clazz = main.Car.class;
		
		for(Field f : clazz.getDeclaredFields()){
			f.setAccessible(true);
			try {
				Object o1 = f.get(car1);
				Object o2 = f.get(car2);
				
				String s;
				
				if(o1.equals(o2)){
					s = "+";
				}else{
					s = "-";
				}
				
				System.out.println(f.getName()  + ": " + o1 + "/"+ o2 +"..."+s);
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}	
		}
	}
}
