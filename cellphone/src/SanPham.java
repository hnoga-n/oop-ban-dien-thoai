
//import java.util.Scanner;

import java.util.Scanner;

public class SanPham implements Comparable<SanPham> {
    Scanner sc = new Scanner(System.in);
    public SanPham() {
    }

    private String masp;
    private String tensp;
    private String hang;
    private int gia;
    private String thoiGianBaoHanh;
    private int soluong;
    private ChiTietSanPham chitietsp;

    public SanPham(String masp) {
        this.masp = masp;
    }

    public SanPham(String masp, String tensp, String hang, int gia, String thoiGianBaoHanh, int soluong,
            ChiTietSanPham chitietsp) {
        this.masp = masp;
        this.tensp = tensp;
        this.hang = hang;
        this.gia = gia;
        this.soluong = soluong;
        this.chitietsp = chitietsp;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public SanPham(String masp, String tensp, String hang, int gia, int soLuong, String thoiGianBaoHanh) {
        this.masp = masp;
        this.tensp = tensp;
        this.hang = hang;
        this.gia = gia;
        this.soluong = soLuong;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp() {
        System.out.println("Nhap ma san pham moi: ");
        String newMasp = sc.nextLine();
        do {
            if(newMasp.matches("[a-z]{1}[0-9]{1,}")==true){
                this.masp=newMasp;
                break;
            }
            else{
                System.out.println("Ma san pham bat dau bang chu cai dau cua hang roi den so!");
                System.out.println("Nhap ma san pham moi: ");
                newMasp = sc.nextLine();
            }
        } while (true);
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp() {
        System.out.print("Nhap ten san pham moi: ");
        String newTenSp = sc.nextLine();
        this.tensp=newTenSp;
    }

    public String getHang() {
        return hang;
    }

    public void setHang() {
        System.out.print("Nhap hang san pham moi: ");
        String newHangSp = sc.nextLine();
        this.hang=newHangSp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia() {
        System.out.print("Nhap gia san pham moi: ");
        int newGia = sc.nextInt();
        sc.nextLine();
        this.gia=newGia;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh() {
        System.out.print("Nhap thoi gian bao hanh moi: ");
        String newThoiGianBaoHanh = sc.nextLine();
        this.thoiGianBaoHanh=newThoiGianBaoHanh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong() {
        System.out.print("Nhap so luong san pham moi: ");
       int newSoLuong= sc.nextInt();
       sc.nextLine();
       this.soluong=newSoLuong;
    }

    public ChiTietSanPham getChitietsp() {
        return chitietsp;
    }

    public void setChitietsp(ChiTietSanPham chitietsp) {
        this.chitietsp = chitietsp;
    }

    @Override
    public String toString() {
        return masp + "," + tensp + "," + hang + "," + gia + "," + soluong + "," + thoiGianBaoHanh + ","
                + this.getChitietsp().toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((masp == null) ? 0 : masp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        SanPham other = (SanPham) obj;
        if (masp == null) {
            if (other.masp != null)
                return false;
        } else if (!masp.equals(other.masp))
            return false;
        return true;
    }

    @Override
    public int compareTo(SanPham o) {
        // TODO Auto-generated method stub
        return this.masp.compareTo(o.masp);
    }

    // xuất thông tin chi tiết
    public void XuatThongTinChiTiet() {
        System.out.println("---------------------------------------------------");
        System.out.println("Thong tin chi tiet:");
        System.out.println("---------------------------------------------------" + "\nMa san pham: " + masp
                + "\n---------------------------------------------------" + "\nTen san pham: " + tensp
                + "\n---------------------------------------------------" + "\nHang: " + hang
                + "\n---------------------------------------------------" + "\nGia: " + gia
                + "\n---------------------------------------------------" + "\nSo luong: " + soluong
                + "\n---------------------------------------------------"
                + "\nThoi gian bao hanh: " + thoiGianBaoHanh + "\n---------------------------------------------------"
                + "\nChi tiet: ");
        this.chitietsp.XuatMoTaSanPham();

    }

    // xuất thông tin dùng cho phương thức tìmkiếm ở quản lí danh sách
    public String XuatThongTin() {
        return "Ma san pham: " + masp + ";  Ten san pham: " + tensp + ";  Hang: " + hang + ";  Gia: " + gia
                + ";  Thoi gian bao hanh: " + thoiGianBaoHanh + ";  So luong: " + soluong;

    }

}
