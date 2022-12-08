
import java.util.Scanner;

public class ChiTietSanPham {
    Scanner sc = new Scanner(System.in);
    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String manHinh, String vxl, String camera, String pin, String ram, String boNho) {
        this.manHinh = manHinh;
        this.vxl = vxl;
        this.camera = camera;
        this.pin = pin;
        this.ram = ram;
        this.boNho = boNho;

    }

    private String manHinh;
    private String vxl;
    private String camera;
    private String pin;
    private String ram;
    private String boNho;
    

    public String getmanHinh() {
        return manHinh;
    }

    public void setmanHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getvxl() {
        return vxl;
    }

    public void setvxl(String vxl) {
        this.vxl = vxl;
    }

    public String getcamera() {
        return camera;
    }

    public void setcamera(String camera) {
        this.camera = camera;
    }

    public String getpin() {
        return pin;
    }

    public void setpin(String pin) {
        this.pin = pin;
    }

    public String getram() {
        return ram;
    }

    public void setram(String ram) {
        this.ram = ram;
    }

    public String getboNho() {
        return boNho;
    }

    public void setboNho(String boNho) {
        this.boNho = boNho;
    }

    @Override
    public String toString() {
        return manHinh + "," + vxl + "," + camera
                + "," + pin + "," + ram + "," + boNho;
    }

    // xuất mô tả sản phẩm
    public void XuatMoTaSanPham() {
        System.out.println(
                "---------------------------------------------------"
                        + "\n  Man hinh: " + manHinh
                        + "\n---------------------------------------------------"
                        + "\n  Vi xu li: " + vxl
                        + "\n---------------------------------------------------"
                        + "\n  Camera: " + camera
                        + "\n---------------------------------------------------"
                        + "\n  Pin: " + pin
                        + "\n---------------------------------------------------"
                        + "\n  Ram: " + ram
                        + "\n---------------------------------------------------"
                        + "\n  Bo nho: " + boNho
                        +"\n---------------------------------------------------");
    }

    // sửa các chi tiết sản phẩm
    public void sua() {
        try (Scanner sc = new Scanner(System.in)) {
            int luaChon = 0;
            do {
                System.out.println("MENU ----------");

                System.out.println(
                        "1. Man hinh.\n"
                                + "2. Vi xu ly.\n"
                                + "3. Camera.\n"
                                + "4. Pin\n"
                                + "5. Bo nho.\n"
                                + "6. Ram.\n"
                                + "0. Thoat.\n");
                System.out.print("Lua chon chi tiet san pham can sua: ");
                luaChon = sc.nextInt();
                sc.nextLine();
                if (luaChon == 1) {
                    System.out.println("Nhap thong so man hinh moi: ");
                    String newManHinh = sc.nextLine();
                    this.setmanHinh(newManHinh);
                }
                if (luaChon == 2) {
                    System.out.println("Nhap thong so vi xu ly moi: ");
                    String newVxl = sc.nextLine();
                    this.setvxl(newVxl);
                }
                if (luaChon == 3) {
                    System.out.println("Nhap thong so camera moi: ");
                    String newCamera = sc.nextLine();
                    this.setcamera(newCamera);
                }
                if (luaChon == 4) {
                    System.out.println("Nhap thong so pin moi: ");
                    String newPin = sc.nextLine();
                    this.setpin(newPin);
                }
                if (luaChon == 5) {
                    System.out.println("Nhap thong so bo nho moi: ");
                    String newBoNho = sc.nextLine();
                    this.setboNho(newBoNho);
                }
                if (luaChon == 6) {
                    System.out.println("Nhap thong so ram moi: ");
                    String newRam = sc.nextLine();
                    this.setram(newRam);
                }
            } while (luaChon != 0);
        }
    }

    public void suaChiTiet() 
    {
        int luaChon = 0;
        do 
        {
            System.out.println("MENU ----------");
            
            System.out.println(
                            "1. Man hinh.\n"
                            + "2. Vi xu li.\n"
                            + "3. Camera.\n"
                            + "4. Pin\n"
                            + "5. Ram.\n"
                            + "6. Bo nho\n"
                            + "0. Thoat.\n");
            luaChon = sc.nextInt();
            System.out.print("Chon chi tiet can sua: ");
            sc.nextLine();
            if (luaChon == 1) 
            {
                System.out.print("Nhap thong so man hinh moi: ");
                String newManHinh = sc.nextLine();
                this.setmanHinh(newManHinh);
            }
            if (luaChon == 2) 
            {
                System.out.print("Nhap thong so vi xu li moi: ");
                String newVxl = sc.nextLine();
                this.setvxl(newVxl);
            }
            if (luaChon == 3) 
            {
                System.out.print("Nhap thong so camera moi: ");
                String newCamera = sc.nextLine();
                this.setcamera(newCamera);
            }
            if (luaChon == 4) 
            {
                System.out.print("Nhap thong so pin moi: ");
                String newPin = sc.nextLine();
                this.setpin(newPin);
            }
            if (luaChon == 5) 
            {
                System.out.print("Nhap thong ram moi: ");
                String newRam = sc.nextLine();
                this.setram(newRam);
            }
            if (luaChon == 6) 
            {
                System.out.print("Nhap thong so bo nho moi: ");
                String newBoNho = sc.nextLine();
                this.setboNho(newBoNho);
            }
            
        } while (luaChon != 0);
    }
}
