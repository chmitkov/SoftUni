package problem_01_and_02;

public class Person {
    private Long id;
    private String name;

    public Person(){
    }

    public Person(Long id, String name){
        setId(id);
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}
