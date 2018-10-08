package entity;
import org.apache.solr.client.solrj.beans.Field; 

public class Person {
	
	private String id;
	private String name;
	private String description;
	
	
	public Person() {
	}
	
	public Person(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}
	 @Field("id") 
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	 @Field("name") 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	 @Field("description") 
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	

}
