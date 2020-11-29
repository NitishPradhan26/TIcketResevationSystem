package Theatre_elements;

public class Movie {
    private String name;//Movie Name
    private int length;//Runtime in minutes

    public Movie(){
        name = null;
        length = 0;
    }

    public Movie(String name){
        this.name = name;
        length = 120;
    }

    public Movie(String name, int length){
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
