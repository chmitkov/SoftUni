package P03_GraphicEditor;

public abstract class Shape {

    public void print() {
        String className = this.getClass().getSimpleName();
        System.out.println("I'm " + className);
    }
}
