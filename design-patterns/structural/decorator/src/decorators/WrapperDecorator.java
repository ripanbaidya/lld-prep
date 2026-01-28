package decorators;

import gift.Gift;

/**
 * Concrete Decorator
 * Adds wrapping functionality to a Gift.
 */
public class WrapperDecorator extends GiftDecorator {

    public WrapperDecorator(Gift gift) {
        super(gift);
    }

    @Override
    public String prepare() {
        return gift.prepare() + " wrapped in paper";
    }
}
