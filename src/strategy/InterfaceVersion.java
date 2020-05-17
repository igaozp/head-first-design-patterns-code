package strategy;

public class InterfaceVersion {

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

    /**
     * MallardDuck 实现 Flyable、Quackable 接口，具有 fly、quack 行为
     */
    static class MallardDuck extends Duck implements Flyable, Quackable {
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
     * RedheadDuck 实现 Flyable、Quackable 接口，具有 fly、quack 行为
     */
    static class RedheadDuck extends Duck implements Flyable, Quackable {
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
    }

    /**
     * RubberDuck 实现 Flyable 接口，只有 fly 行为
     */
    static class RubberDuck extends Duck implements Flyable {
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
    }

    /**
     * DecoyDuck 实现 Quackable 接口，只有 quack 行为
     */
    static class DecoyDuck extends Duck implements Quackable {
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
    }

    /**
     * 书中接口形式的示例
     * <p>
     * 使用接口的形式，将非必要的行为抽象为接口，某些类需要该行为时则实现该接口即可。
     * 一定程度上避免了继承关系中父类增加了行为，但非必要的子类默认增加行为的弊端。
     * 但如果需要扩展该行为的子类非常多时，使用接口来实现需要每个子类都要实现该接口，
     * 导致需要新增大量的代码，且子类的实现中可能存在重复的代码，破坏代码的重用性。
     */
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.quack();
        mallardDuck.fly();
        mallardDuck.swim();

        RedheadDuck redheadDuck = new RedheadDuck();
        redheadDuck.display();
        redheadDuck.quack();
        redheadDuck.fly();
        redheadDuck.swim();

        RubberDuck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.swim();
        rubberDuck.fly();

        DecoyDuck decoyDuck = new DecoyDuck();
        decoyDuck.display();
        decoyDuck.swim();
        decoyDuck.quack();
    }
}
