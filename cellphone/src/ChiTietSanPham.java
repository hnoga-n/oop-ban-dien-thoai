
import java.util.Scanner;

public class ChiTietSanPham {
    Scanner sc = new Scanner(System.in);
    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String manHinh, String vxl, String camera, String pin, String boNho) {
        this.manHinh = manHinh;
        this.vxl = vxl;
        this.camera = camera;
        this.pin = pin;
        this.boNho = boNho;

    }

    private String manHinh;
    private String vxl;
    private String camera;
    private String pin;
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

    public String getboNho() {
        return boNho;
    }

    public void setboNho(String boNho) {
        this.boNho = boNho;
    }

    @Override
    public String toString() {
        return manHinh + "," + vxl + "," + camera + "," + pin + "," + boNho;
    }

    // xuất mô tả sản phẩm
    public void XuatMoTaSanPham() {
        System.out.println("  manHinh: " + manHinh + "\n  vxl: " + vxl + "\n  camera: " + camera + "\n  pin: " + pin
                + "\n  boNho: " + boNho);
    }
}
