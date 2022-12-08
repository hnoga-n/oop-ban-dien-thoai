
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

    public void setmanHinh() {
        System.out.print("Nhap thong so man hinh moi: ");
        String newManHinh = sc.nextLine();
        this.manHinh=newManHinh;
    }

    public String getvxl() {
        return vxl;
    }

    public void setvxl() {
        System.out.print("Nhap thong so vi xu li moi: ");
        String newVxl = sc.nextLine();
        this.vxl=newVxl;
    }

    public String getcamera() {
        return camera;
    }

    public void setcamera() {
        System.out.print("Nhap thong so camera moi: ");
        String newCamera = sc.nextLine();
        this.camera=newCamera;
    }

    public String getpin() {
        return pin;
    }

    public void setpin() {
        System.out.print("Nhap thong so pin moi: ");
        String newPin = sc.nextLine();
        this.pin=newPin;
    }

    public String getram() {
        return ram;
    }

    public void setram() {
        System.out.print("Nhap thong so ram moi: ");
        String newRam = sc.nextLine();
        this.ram=newRam;
    }

    public String getboNho() {
        return boNho;
    }

    public void setboNho() {
        System.out.println("Nhap thong so bo nho moi: ");
        String newBoNho = sc.nextLine();
        this.boNho=newBoNho;
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
                    this.setmanHinh();
                }
                if (luaChon == 2) {
                    this.setvxl();
                }
                if (luaChon == 3) {
                    this.setcamera();
                }
                if (luaChon == 4) {
                    this.setpin();
                }
                if (luaChon == 5) {
                    this.setboNho();
                }
                if (luaChon == 6) {
                    this.setram();
                }
            } while (luaChon != 0);
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
                this.setmanHinh();
            }
            if (luaChon == 2) 
            {
                this.setvxl();
            }
            if (luaChon == 3) 
            {
                this.setcamera();
            }
            if (luaChon == 4) 
            {
                this.setpin();
            }
            if (luaChon == 5) 
            {
                this.setram();
            }
            if (luaChon == 6) 
            {
                this.setboNho();
            }
            
        } while (luaChon != 0);
    }
}
