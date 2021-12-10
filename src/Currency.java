public class Currency implements ICurrency {
    private final String name;
    private final String code;
    private final String conversionRate;
    private final String exchangeRate;


    public Currency(String name, String conversionRate, String code, String exchangeRate) {
        this.name = name;
        this.code = code;
        this.conversionRate = conversionRate;
        this.exchangeRate = exchangeRate;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getExchangeRate() {
        return this.exchangeRate;
    }

    @Override
    public String getConversionRate() {
        return this.conversionRate;
    }
}
