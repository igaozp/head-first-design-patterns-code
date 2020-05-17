package strategy;

public class StrategyPattern {
    // 飞行行为接口
    interface FlyBehavior {
        void fly();
    }

    // 叫声行为接口
    interface QuackBehavior {
        void quack();
    }

    // 飞行行为的具体实现
    static class FlyWithWings implements FlyBehavior {
        @Override
        public void fly() {
            System.out.println("Fly with wings");
        }
    }

    // 飞行行为的具体实现
    static class FlyNoWay implements FlyBehavior {
        @Override
        public void fly() {
            System.out.println("Fly no way");
        }
    }

    // 飞行行为的具体实现
    static class FlyRocketPowered implements FlyBehavior {
        @Override
        public void fly() {
            System.out.println("Fly rocket powered");
        }
    }

    // 叫声行为的具体实现
    static class Quack implements QuackBehavior {
        @Override
        public void quack() {
            System.out.println("Quack");
        }
    }

    // 叫声行为的具体实现
    static class Squeak implements QuackBehavior {
        @Override
        public void quack() {
            System.out.println("Squeak");
        }
    }

    // 叫声行为的具体实现
    static class MuteQuack implements QuackBehavior {
        @Override
        public void quack() {
            System.out.println("Mute quack");
        }
    }

    static class Duck {
        // 鸭子具有叫声的行为
        QuackBehavior quackBehavior;

        // 鸭子具有飞行的行为
        FlyBehavior flyBehavior;

        // 触发叫声行为
        public void performQuack() {
            quackBehavior.quack();
        }

        // 触发飞行行为
        public void performFly() {
            flyBehavior.fly();
        }

        // 可设置具体的飞行行为
        public void setBehavior(FlyBehavior flyBehavior) {
            this.flyBehavior = flyBehavior;
        }

        // 可设置具体的叫声行为
        public void setQuackBehavior(QuackBehavior quackBehavior) {
            this.quackBehavior = quackBehavior;
        }

        public void swim() {
            System.out.println("Duck swim");
        }

        public void display() {
            System.out.println("Duck");
        }
    }

    static class MallardDuck extends Duck {
        // 设置默认的行为策略
        public MallardDuck() {
            this.quackBehavior = new Quack();
            this.flyBehavior = new FlyWithWings();
        }

        @Override
        public void display() {
            System.out.println("MallardDuck");
        }

        @Override
        public void swim() {
            System.out.println("MallardDuck swim");
        }
    }

    /**
     * 策略模式示例
     * <p>
     * 通过接口来触发类所具有的行为，接口提供共用的方法来对外提供调用的入口，具体的行为策略通过继承接口来实现；
     * 触发行为时只调用接口的方法，具体的行为策略可以预先配置或者是动态指定；
     * <p>
     * 这样的好处是父类想要具有某些行为，直接包含该行为的接口即可，具体的行为策略可以在子类中去指定，
     * 父类只依赖接口不依赖实现，子类中为接口赋予具体的实现。
     * 将相对固定的行为（父类包含的行为接口）和相对动态的行为策略（子类确定行为的实现）相分离；
     * 扩展类时无需关心行为的实现（只继承了行为的接口），扩展行为时也无需关心有哪些类调用。
     */
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        // 触发行为，内部通过接口调用行为
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.swim();

        // 动态修改行为策略
        mallardDuck.setBehavior(new FlyRocketPowered());
        mallardDuck.performFly();
    }
}
