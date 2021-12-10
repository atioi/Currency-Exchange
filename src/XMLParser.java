import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Pattern;

public class XMLParser implements IXMLParser {
    private byte[] data;

    @Override
    public String[] parse_data() {
        Charset ISO_8859_2 = Charset.forName("ISO-8859-2");
        String file_content = new String(data, ISO_8859_2);

        String regex_open_tag = "<nazwa_waluty>|<przelicznik>|<kod_waluty>|<kurs_sredni>";
        String regex_closing_tag = "</nazwa_waluty>|</przelicznik>|</kod_waluty>|</kurs_sredni>";

        Pattern pattern = Pattern.compile(regex_open_tag);

        String[] currencies_array = Arrays.stream(file_content.split("\n"))
                .filter(pattern.asPredicate())
                .map(String::trim)
                .map(line -> line.split(regex_open_tag + "|" + regex_closing_tag)[1])
                .toArray(String[]::new);

        Arrays.copyOfRange(currencies_array, 0, currencies_array.length + 4);
        currencies_array[currencies_array.length - 4] = "polski złoty";
        currencies_array[currencies_array.length - 3] = "1";
        currencies_array[currencies_array.length - 2] = "PLN";
        currencies_array[currencies_array.length - 1] = "1";

        return currencies_array;
    }

    @Override
    public CurrencyList createList() {
        String[] parsed_data = parse_data();
        CurrencyList list = new CurrencyList();

        for (int i = 0; i < parsed_data.length; i += 4) {
            list.append(parsed_data[i], parsed_data[i + 1], parsed_data[i + 2], parsed_data[i + 3]);
        }
//

        return list;
    }

    @Override
    public void setData(byte[] data) {
        this.data = data;
    }

}
