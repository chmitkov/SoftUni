package P03_GraphicEditor;

public class Main {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Square square = new Square();

        graphicEditor.drawShape(circle);
        graphicEditor.drawShape(rectangle);
        graphicEditor.drawShape(square);
    }
}
