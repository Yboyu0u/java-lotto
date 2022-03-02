package domain;

import java.util.List;

public class TicketCount {
	private static final int TICKET_PRICE = 1000;
	private static final int ZERO_COUNT = 0;

	private static final String INVALID_MONEY_ERROR = "구입 금액은 1000원 이상이어야 합니다.";
	private static final String NEGATIVE_COUNT_ERROR = "구매할 로또 수는 음수일 수 없습니다.";
	private static final String OVER_COUNT_ERROR = "구매할 로또 수는 구입 금액으로 살 수 있어야 합니다.";
	private static final String COUNT_TICKETS_SIZE_NOT_EQUALS_ERROR = "구매할 개수와 입력받은 수동 로또 개수는 같아야 합니다.";

	private final int manualCount;
	private final int autoCount;


	public TicketCount(final int money, final int manualCount) {
		validateMoney(money);
		validateManualCount(money, manualCount);

		this.manualCount = manualCount;
		this.autoCount = money - (manualCount * TICKET_PRICE);
	}

	private void validateMoney(final int money) {
		if(money < TICKET_PRICE) {
			throw new IllegalArgumentException(INVALID_MONEY_ERROR);
		}
	}

	private void validateManualCount(final int money, final int manualCount) {
		if(manualCount < ZERO_COUNT) {
			throw new IllegalArgumentException(NEGATIVE_COUNT_ERROR);
		}

		if(manualCount * TICKET_PRICE > money) {
			throw new IllegalArgumentException(OVER_COUNT_ERROR);
		}
	}

	public void validateManualCountEqualsTicketsSize(List<List<Integer>> lottoTickets) {
		if(manualCount != lottoTickets.size()) {
			throw new IllegalArgumentException(COUNT_TICKETS_SIZE_NOT_EQUALS_ERROR);
		}
	}

	public int getAutoCount() {
		return autoCount;
	}
}
