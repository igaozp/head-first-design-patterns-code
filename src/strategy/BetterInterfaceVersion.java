package strategy;

public class BetterInterfaceVersion {
    static class Duck {
        public void swim() {
            System.out.println("Duck swim");
        }

        public void display() {
            System.out.println("Duck");
        }
    }

    interface Flyable {
        void fly();
    }

    interface Quackable {
        void quack();
    }

    interface Eatable {
        default void eat() {
            System.out.println("Duck eat");
        }
    }

    /**
     * MallardDuck 实现 Flyable、Quackable、Eatable 接口，具有 fly、quack、default eat 行为
     */
    static class MallardDuck extends Duck implements Flyable, Quackable, Eatable {
        @Override
        public void swim() {
            System.out.println("MallardDuck swim");
        }

        @Override
        public void display() {
            System.out.println("MallardDuck");
        }

        @Override
        public void fly() {
            System.out.println("MallardDuck fly");
        }

        @Override
        public void quack() {
            System.out.println("MallardDuck quack");
        }
    }

    /**
     * RedheadDuck 实现 Flyable、Quackable、Eatable 接口，具有 fly、quack、eat 行为
     */
    static class RedheadDuck extends Duck implements Flyable, Quackable, Eatable {
        @Override
        public void swim() {
            System.out.println("RedheadDuck swim");
        }

        @Override
        public void display() {
            System.out.println("RedheadDuck");
        }

        @Override
        public void fly() {
            System.out.println("RedheadDuck fly");
        }

        @Override
        public void quack() {
            System.out.println("RedheadDuck quack");
        }

        @Override
        public void eat() {
            System.out.println("RedheadDuck eat");
        }
    }

    /**
     * RubberDuck 实现 Flyable、Eatable 接口，只有 fly、eat 行为
     */
    static class RubberDuck extends Duck implements Flyable, Eatable {
        @Override
        public void swim() {
            System.out.println("RubberDuck swim");
        }

        @Override
        public void display() {
            System.out.println("RubberDuck");
        }

        @Override
        public void fly() {
            System.out.println("RubberDuck fly");
        }

        @Override
        public void eat() {
            System.out.println("RubberDuck eat");
        }
    }

    /**
     * DecoyDuck 实现 Quackable、Eatable 接口，只有 quack、eat 行为
     */
    static class DecoyDuck extends Duck implements Quackable, Eatable {
        @Override
        public void swim() {
            System.out.println("DecoyDuck swim");
        }

        @Override
        public void display() {
            System.out.println("Decoy");
        }

        @Override
        public void quack() {
            System.out.println("DecoyDuck quack");
        }

        @Override
        public void eat() {
            System.out.println("DecoyDuck eat");
        }
    }

    /**
     * 该版本是对普通接口版本的扩充，在普通接口版本中通过接口增加通用的行为时，
     * 所有的子类都要实现该行为的接口，导致子类中可能出现大量的重复代码。
     * 该版本使用 Java 8 中的特性，给接口中的方法以默认的实现，
     * 子类实现该接口时可以不用实现自己的方法，而是直接复用默认的方法。
     * <p>
     * 这种场景为什么要用接口实现？直接在父类中添加不行吗？
     * 该版本只是提供一种思路，并无太多实际的意义。
     * 且该版本只能在部分场景中能够做到代码的较高复用度，
     * 即扩展的行为在大部分子类的实现一致（直接复用默认实现），
     * 如果扩展的行为在子类中差异过大，还是需要在子类中去单独实现。
     */
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.quack();
        mallardDuck.fly();
        mallardDuck.swim();
        mallardDuck.eat();

        RedheadDuck redheadDuck = new RedheadDuck();
        redheadDuck.display();
        redheadDuck.quack();
        redheadDuck.fly();
        redheadDuck.swim();
        redheadDuck.eat();

        RubberDuck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.swim();
        rubberDuck.fly();
        rubberDuck.eat();

        DecoyDuck decoyDuck = new DecoyDuck();
        decoyDuck.display();
        decoyDuck.swim();
        decoyDuck.quack();
        decoyDuck.eat();
    }
}
