import java.util.ArrayList;

public class example {
    public static void main(String[] args) {
        ArrayList<Animal> animal_arr = new ArrayList<>();
        animal_arr.add(new Cat("Тузик", 100, 30, "Зеленый"));
        animal_arr.add(new Cat("Мурзик", 120, 15, "Красный"));
        animal_arr.add(new Worm("Червь_1", 10, 5, 20));
        animal_arr.add(new Worm("Червь_2", 15, 10, 30));

        for(var animal: animal_arr) {
            if(animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println(String.format("Это кот %s, у него %s сердечек, его скорость %sкм/ч, и он цвета %s", cat.name, cat.HP, cat.getSpeed(), cat.getColor()));
                cat.walking();
                System.out.println();
            }
            if(animal instanceof Worm) {
                Worm worm = (Worm) animal;
                System.out.println(String.format("Это червь %s, у него %d сердечек, его скорость %sкм/ч, и длинна у него %sсм.", worm.name, worm.HP, worm.getSpeed(), worm.getLong()));
                worm.walking();
                worm.underGround();
            }
        }
    }
}

abstract class Animal {
    protected String name;
    public int HP;
    private int speed;

    public Animal(String name, int HP, int speed) {
        this.name = name;
        this.HP = HP;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void eat() {
        System.out.println("Я питаюсь");
    }
}

interface terrinesAnimal {
    void walking();
}

interface surfaceTerrinesAnimal extends terrinesAnimal {
    @Override
    default void walking() {
        System.out.println("я ползаю");
    }
    default void underGround() {
        System.out.println("я ухожу под землю");
    }
}

class Worm extends Animal implements surfaceTerrinesAnimal {
    private int Long;

    public Worm(String name, int HP, int speed, int Long) {
        super(name, HP, speed);
        this.Long = Long;
    }

    public int getLong() {
        return Long;
    }
}

class Cat extends Animal implements terrinesAnimal {
    private String color;

    public Cat(String name, int HP, int speed, String color) {
        super(name, HP, speed);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void walking() {
        System.out.println("Я хожу");
    }
}

