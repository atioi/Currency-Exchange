import java.util.Arrays;

public class CurrencyList implements ICurrencyList {

    private int size = 0;
    private int capacity = 0;
    private Currency[] elements = new Currency[this.capacity];

    public void append(String name, String conversion_rate, String code, String exchange_rate) {
        if (this.size == this.capacity) {
            this.capacity += 1;
            this.elements = Arrays.copyOf(this.elements, this.capacity);
        }

        this.size += 1;

        Currency currency = new Currency(name, conversion_rate, code, exchange_rate);
        this.elements[size - 1] = currency;
    }

    public int length() {
        return this.size;
    }

    @Override
    public Currency getByCode(String code) {
        return Arrays.stream(elements).filter(currency -> currency.getCode().equals(code)).findFirst().orElse(null);
    }
}
