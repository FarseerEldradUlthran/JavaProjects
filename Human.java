class Head {
    String color = "Black ", longe = "short ", shape = "triangle ", size = " medium";
    public String getHair() {
        return color + longe;
    }
    String getShape() {
        return shape;
    }
    String getSize() {
        return size;
    }
    void show()  {
        System.out.println("His haircut is " + getHair() + ", his face has shape of " + getShape() + " and it size is" + getSize());
    }

}
class Leg {
    String longe = "Medium ", weight = "Normal";
    String getLonge() {
        return longe;
    }
    String getWeight() {
        return weight;
    }
    void show()  {
        System.out.println( "His legs length is " + getLonge() + " and weight of them is " + getWeight());
    }
}
class Hand {
    String longe_ = "Medium ", weight_ = "Normal";
    String getLonge_() {
        return longe_;
    }
    String getWeight_() {
        return weight_;
    }
    void show()  {
        System.out.println( "His arms length is " + getLonge_() + " and weight of them is " + getWeight_());
    }
}
class Human {
    void call() {
        Head social = new Head();
        social.getHair();
        social.getShape();
        social.getSize();
        social.show();
        Leg social_2 = new Leg();
        social_2.getLonge();
        social_2.getWeight();
        social_2.show();
        Hand social_3 = new Hand();
        social_3.getLonge_();
        social_3.getWeight_();
        social_3.show();
    }
}
class HumanTest {
    public static void main(String[] args) {
        Human test = new Human();
        test.call();
    }
}
