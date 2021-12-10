public class Convert {

    private float value;

    public Convert(Currency currency_1, float amount, Currency currency_2) {

        float exchange_rate_1 = Float.parseFloat(currency_1.getExchangeRate().replace(",", "."));
        float exchange_rate_2 = Float.parseFloat(currency_2.getExchangeRate().replace(",", "."));

        float conversion_rate_1 = Float.parseFloat(currency_1.getConversionRate().replace(",", "."));
        float conversion_rate_2 = Float.parseFloat(currency_2.getConversionRate().replace(",", "."));

        this.value = (amount * exchange_rate_1 * conversion_rate_2) / (exchange_rate_2 * conversion_rate_1);

    }

    public float getResult() {
        return value;
    }

}
