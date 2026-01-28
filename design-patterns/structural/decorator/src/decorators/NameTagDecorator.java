package decorators;

import gift.Gift;

/**
 * Concrete Decorator
 * Adds name tag functionality to a Gift.
 */
public class NameTagDecorator extends GiftDecorator {

    public NameTagDecorator(Gift gift) {
        super(gift);
    }

    @Override
    public String prepare() {
        return gift.prepare() + " and a name tag";
    }
}
