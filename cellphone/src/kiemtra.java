import java.util.Scanner;
public class kiemtra {
    Scanner sc=new Scanner(System.in);
    public String KiemTraNhapMa(){
        String DauVao;
        while (true) {
            DauVao=sc.nextLine();
            if(DauVao.matches("[0-9]{1,2}")){
                return DauVao;
            }
            else{
                System.out.println("Ma nhan vien gom 2 chu so");
            }
            System.out.print("Moi nhap lai: ");
        }
    }
    public String KiemTraNhapSDT(){
        String DauVao;
        while (true) {
            DauVao=sc.nextLine();
            if(DauVao.matches("0"+"[0-9]{9}")){
                return DauVao;
            }
            else{
                System.out.println("Sai dinh dang so dien thoai!");
            }
            System.out.print("Moi nhap lai: ");
        }
    }
    public String KiemTraNamSinh(){
        String year;
        while (true) {
            year=sc.nextLine();
            if(Integer.parseInt(year)>1900 && Integer.parseInt(year)<=2022){
                return year;
            }
            else{
                System.out.println("Sai dinh dang nam sinh!");
            }
            System.out.print("Moi nhap lai: ");
        }
    }
}
