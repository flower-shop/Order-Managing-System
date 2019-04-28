//Create an interface
interface area{
    //method signatures
    double circleArea(double radius);
    void sqaureArea(int side);
}
//Create a class Shape to implements area interface
class Shape implements area{
    //implement circleArea method
    @Override 
    public double circleArea(double radius){
        return (3.14*radius*radius);
    }
    //implement sqaureArea method
    @Override 
    public void sqaureArea(int side) {
	//Print square area
	System.out.println("Square area: "+side*side);		
    }	
}
//Create a driver class to test implemented methods
public class FindArea extends Shape {
     public static void main(String []args) {
         //Create an object of extended class Shape
    	 Shape object=new Shape();
    	 System.out.println("Circle area: "+object.circleArea(5.0));
    	 //Call sqaureArea method
    	 object.sqaureArea(5);
     }	
}