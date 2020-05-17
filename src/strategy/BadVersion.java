package strategy;

public class BadVersion {
    /**
     * 基础 Duck 类，实现 Duck 基础行为（方法）
     */
    static class Duck {

        public void quack() {
            System.out.println("Duck quack");
        }

        public void swim() {
            System.out.println("Duck swim");
        }

        public void display() {
            System.out.println("Duck");
        }

        /**
         * 增加 fly 方法，子类可调用该方法
         */
        public void fly() {
            System.out.println("Duck fly");
        }
    }

    /**
     * 继承父类 Duck，实现父类的方法
     */
    static class MallardDuck extends Duck {
        @Override
        public void quack() {
            System.out.println("MallardDuck quack");
        }

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
    }

    /**
     * 继承父类 Duck，实现父类的方法
     */
    static class RedheadDuck extends Duck {
        @Override
        public void quack() {
            System.out.println("RedheadDuck quack");
        }

        @Override
        public void swim() {
            System.out.println("RedheadDuck swim");
        }

        @Override
        public void display() {
            System.out.println("RedheadDuck");
        }
    }

    /**
     * 基于书中的示例
     *
     * 使用继承关系扩展父类的方法时，即使子类不需要，但子类也默认扩展了该方法。
     * 这种扩展行为的方式会给不需要该行为的子类带来副作用。
     */
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.quack();
        mallardDuck.swim();
        mallardDuck.display();
        mallardDuck.fly();

        RedheadDuck redheadDuck = new RedheadDuck();
        redheadDuck.quack();
        redheadDuck.swim();
        redheadDuck.display();
        // RedheadDuck 假设不应该有 fly 行为（方法），但它仍可以调用（调用父类的方法）
        redheadDuck.fly();
    }
}
