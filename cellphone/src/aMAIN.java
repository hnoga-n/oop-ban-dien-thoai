import java.io.IOException;
import java.util.Scanner;

public class aMAIN {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    tk_list dstk = new tk_list();
    DANHSACHKHACHHANG dskh = new DANHSACHKHACHHANG();
    DANHSACHNHANVIEN dsnv = new DANHSACHNHANVIEN();

    int mode;
    System.out.println("1. Dang ki");
    System.out.println("2. Dang nhap");
    System.out.println("3. Thoat chuong trinh");
    mode = sc.nextInt();

    switch (mode) {
      case 1: {
        dstk.dangKi();

        dstk.dangNhap();
      }
    }

    sc.close();
  }
}
