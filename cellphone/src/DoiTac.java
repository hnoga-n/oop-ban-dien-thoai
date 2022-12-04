import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//import java.io.FileOutputStream;
public class DoiTac {
    Scanner sc = new Scanner(System.in);

    private String MADT;
    private String tenDoiTac;
    private String Tel;
    private String Mail;

    public DoiTac() {
        MADT = "";
        tenDoiTac = "";
        Tel = "";
        Mail = "";
    }

    public DoiTac(String MADT, String tenDoiTac, String Tel, String Mail) {
        this.MADT = MADT;
        this.tenDoiTac = tenDoiTac;
        this.Tel = Tel;
        this.Mail = Mail;
    }

    // SET METHOD
    public void setMADT(String MADT) {
        this.MADT = MADT;
    }

    public void setTenDoiTac(String tenDoiTac) {
        this.tenDoiTac = tenDoiTac;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    // GET METHOD
    public String getMADT() {
        return MADT;
    }

    public String getTenDoiTac() {
        return tenDoiTac;
    }

    public String getTel() {
        return Tel;
    }

    public String getMail() {
        return Mail;
    }

    // IO METHOD
    public void loadInfoDoiTac() {
        File load = new File("DSDT.txt");
        try {

            Scanner reader = new Scanner(load);
            if (reader.hasNext()) {
                String s = "";
                s = s + reader.next();
                MADT = s;
            }
            if (reader.hasNext()) {
                String s = "";
                s = s + reader.next();
                tenDoiTac = s;
            }
            if (reader.hasNext()) {
                String s = "";
                s = s + reader.next();
                Tel = s;
            }
            if (reader.hasNext()) {
                String s = "";
                s = s + reader.next();
                Mail = s;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Loi");
            e.printStackTrace();
        }

    }

    public void xuatDoiTac() {
        System.out.printf("%-10s%-20s%-15s%-30s", MADT, tenDoiTac, Tel, Mail);
    }

    // FILE
    public String getFileFline() {
        return MADT + "," + tenDoiTac + "," + Tel + "," + Mail + "\n";
    }

    public void parseDT(String line) {
        String[] params = line.split(",");
        try {
            this.MADT = params[0];
            this.tenDoiTac = params[1];
            this.Tel = params[2];
            this.Mail = params[3];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {
        DoiTac d1 = new DoiTac();
        d1.loadInfoDoiTac();
        d1.xuatDoiTac();
    }
}