import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        RemoteProvider remote = new RemoteProvider();
        byte[] data = new byte[0];

        try {
            data = remote.getData("https://www.nbp.pl/kursy/xml/lasta.xml");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }


        XMLParser xml = new XMLParser();
        xml.setData(data);
        CurrencyList list = xml.createList();


// Buffers for currencies:
        Currency currency_1;
        Currency currency_2;
        float amount;
        boolean flag;
        do {

            UserData ud = new UserData();

            String code_1 = ud.getCode_1();
            String code_2 = ud.getCode_2();


            currency_1 = list.getByCode(code_1);
            amount = ud.getValue();
            currency_2 = list.getByCode(code_2);

            flag = currency_1 == null || currency_2 == null;

            if (flag)
                System.out.println("Podałeś złe dane");

        } while (flag);


        Convert conv = new Convert(currency_1, amount, currency_2);
        System.out.println(conv.getResult());

    }
}
