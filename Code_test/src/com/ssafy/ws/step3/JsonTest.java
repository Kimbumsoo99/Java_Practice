package com.ssafy.ws.step3;

//import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Person {

	private String name;
	private int age;
	private int height;

//	public Person() {
//		// TODO Auto-generated constructor stub
//	}

	public Person(String name, int age, int height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

}
public class JsonTest {

	public static void main(String[] args) throws IOException {
//		Gson gson = new Gson();
//		Person person1 = new Person("임윤섭", 27, 187);
//
//		String personToJson = gson.toJson(person1);
//		System.out.println(personToJson);
//
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("person.json")));
//		gson.toJson(person1, bw);
//		bw.close();
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("person.json")));
//
//		Person person2 = gson.fromJson(br, Person.class);
//
//		// Q. person2의 내용을 출력해봅시다.
//		System.out.println("이름 : " + person2.getName());
//		System.out.println("나이 : " + person2.getAge());
//		System.out.println("키 : " + person2.getHeight());

	}
}
