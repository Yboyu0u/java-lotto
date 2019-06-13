package lotto.domain;

import org.junit.jupiter.api.Test;

import lotto.exceptions.PurchaseAmountException;
import lotto.domain.game.Count;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CountTest {
    @Test
    void game_counts_constructor_argument_must_be_divisible_by_1000() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Count(PurchaseAmount.of(1002));
        });
    }
}