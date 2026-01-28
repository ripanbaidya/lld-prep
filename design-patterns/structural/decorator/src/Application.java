import decorators.BowDecorator;
import decorators.NameTagDecorator;
import decorators.WrapperDecorator;
import gift.Gift;
import gift.Watch;

// Client
public class Application {
    public static void main(String[] args) {
        Gift gift = new Watch("Peter England");
        System.out.println(gift.prepare());

        Gift wrappedGift = new WrapperDecorator(gift);
        System.out.println(wrappedGift.prepare());

        Gift wrappedBowGift = new BowDecorator(new WrapperDecorator(gift));
        System.out.println(wrappedBowGift.prepare());

        Gift fullyDecoratedGift = new NameTagDecorator(
                new BowDecorator(new WrapperDecorator(gift)));

        System.out.println(fullyDecoratedGift.prepare());
    }
}
