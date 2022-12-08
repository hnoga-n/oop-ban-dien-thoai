import java.util.Scanner;

public class kiemtra {
    Scanner sc = new Scanner(System.in);

    public String KiemTraNhapMa() {
        String DauVao;
        while (true) {
            DauVao=sc.nextLine();
            if(DauVao.matches("[0-9]{1,2}")){
                return DauVao;
            }
            else{
                System.out.println("Sai dinh dang ma! vd:'1'");
            }
            System.out.print("Moi nhap lai: ");
        }
    }
    public String KiemTraNhapMaSP(){
        String DauVao;
        while (true) {
            DauVao=sc.nextLine();
            if(DauVao.matches("[isvx]"+"[0-9]{1,2}")){
                return DauVao;
            }
            else{
                System.out.println("Sai dinh dang ma! vd:'i1,s1,x1,v1'");
            }
            System.out.print("Moi nhap lai: ");
        }
    }

    public String KiemTraNhapSDT() {
        String DauVao;
        while (true) {
            DauVao = sc.nextLine();
            if (DauVao.matches("0" + "[0-9]{9}")) {
                return DauVao;
            } else {
                System.out.println("Sai dinh dang so dien thoai!");
            }
            System.out.print("Moi nhap lai: ");
        }
    }

    public String KiemTraNamSinh() {
        String year;
        while (true) {
            year = sc.nextLine();
            if (Integer.parseInt(year) > 1900 && Integer.parseInt(year) <= 2022) {
                return year;
            } else {
                System.out.println("Sai dinh dang nam sinh!");
            }
            System.out.print("Moi nhap lai: ");
        }
    }

    public String KiemTraNhapChucVu() {
        String chucvu;
        while (true) {
            chucvu = sc.nextLine();
            if (chucvu.equalsIgnoreCase("quan ly") || chucvu.equalsIgnoreCase("nhan vien")) {
                return chucvu;
            } else {
                System.out.println("Sai chuc vu ! Chi nhap 'quan ly' hoac 'nhan vien' ");
            }
            System.out.print("Moi nhap lai: ");
        }
    }
    public String KiemTraNhapNgay() {
        String DauVao;
        while (true) {
            DauVao=sc.nextLine();
            if(DauVao.matches("[0-9]{1,2}" + "/" + "[0-9]{1,2}" + "/" + "[0-9]{4}")){
                return DauVao;
            }
            else{
                System.out.println("Sai dinh dang ngay! VD: '11/1/2003' ");
            }
            System.out.print("Moi nhap lai: ");
        }
    } 
}
