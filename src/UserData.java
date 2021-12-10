import java.util.Scanner;

public class UserData {
    private String code_1;
    private String code_2;
    private float value;

    public UserData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj kod waluty, w której masz gotówkę: ");
        this.code_1 = sc.next();

        System.out.print("Podaj ile masz tej waluty: ");
        this.value = sc.nextFloat();

        System.out.print("Podaj kod waluty na jaką chcesz wymienić gotówkę: ");
        this.code_2 = sc.next();
    }

    public float getValue() {
        return value;
    }

    public String getCode_1() {
        return code_1;
    }

    public String getCode_2() {
        return code_2;
    }
}
