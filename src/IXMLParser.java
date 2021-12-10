public interface IXMLParser {
    CurrencyList createList();

    String[] parse_data();

    void setData(byte[] data);
}
