package lotto.domain;

import java.util.Objects;

public class LottoSize {
    private static final String EMPTY_INPUT_MSG = "%s이(가) 입력되지 않았습니다.";
    private static final String NOT_NUMBER_MSG = "잘못된 숫자입니다.";
    private static final String NOT_VALIDATE_LOTTO_SIZE_MSG = "%s는 유효하지 않은 로또 개수입니다.";

    private final int lottoSize;

    public LottoSize(PaidPrice paidPrice, int lottoSize) {
        validateNotNull(paidPrice);
        validateLottoSize(paidPrice, lottoSize);
        this.lottoSize = lottoSize;
    }

    public LottoSize(PaidPrice paidPrice, String lottoSize) {
        this(paidPrice, validateNumber(lottoSize));
    }

    private void validateNotNull(PaidPrice paidPrice) {
        Objects.requireNonNull(paidPrice, String.format(EMPTY_INPUT_MSG, "구입 금액"));
    }

    private static void validateNotNull(String number) {
        Objects.requireNonNull(number, String.format(EMPTY_INPUT_MSG, "로또 개수"));
    }

    private static int validateNumber(String number) {
        validateNotNull(number);
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MSG);
        }
    }

    private void validateLottoSize(PaidPrice paidPrice, int lottoSize) {
        int paidLottoSize = paidPrice.getTotalLottoSize();

        if (paidLottoSize >= lottoSize && lottoSize > 0) {
            return;
        }
        String msg = String.format(NOT_VALIDATE_LOTTO_SIZE_MSG, lottoSize);
        throw new IllegalArgumentException(msg);
    }

    public int getLottoSize() {
        return this.lottoSize;
    }
}