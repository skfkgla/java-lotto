package lotto;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ServiceTest {

    private Service service;

    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @DisplayName("문자열을 정수로 변경시키는 메서드 테스트")
    @Test
    void stringToIntTest_success() {
        assertThat(service.stringToInt("1234"))
                .isEqualTo(1234);
    }

    @DisplayName("문자열이 정수로만 이루어져 있지 않다면 예외 발생")
    @Test
    void stringToIntTest_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.stringToInt("1로또234"));
    }

    @DisplayName("1000으로 나눠 값을 반환하는 메서드")
    @Test
    void numberOfLotteryTest_success() {
        assertThat(service.numberOfLottery(20000))
                .isEqualTo(20);
    }

    @DisplayName("1000으로 나눠 나머지가 있을 경우 예외가 발생")
    @Test
    void numberOfLotteryTest_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.numberOfLottery(20001));
    }

    @DisplayName("로또 티켓을 원하는 개수만큼 생성해 반환하는 메서드 테스트")
    @Test
    void createLotteryTicketsTest() {
        int numberOfLotteryTickets = 10;

        assertThat(service.createLotteryTickets(numberOfLotteryTickets).size())
                .isEqualTo(numberOfLotteryTickets);
    }

    @DisplayName("','를 기준으로 문자열 리스트를 반환하는 기능 테스트")
    @Test
    void splitByCommasTest() {
        String testString = "1,2,3";

        assertThat(service.splitByCommas(testString)).isEqualTo(List.of("1", "2", "3"));
    }

    @DisplayName("문자열 리스트를 정수 리스트로 반환하는 기능 테스트")
    @Test
    void stringsToIntegersTest() {
        assertThat(service.stringsToIntegers(List.of("1", "2", "3"))).isEqualTo(List.of(1, 2, 3));
    }

    @DisplayName("문자열 리스트가 정수가 아니라면 예외 발생")
    @Test
    void stringToIntegerExceptionTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.stringsToIntegers(List.of("1", "2", "문자열")));
    }
}
