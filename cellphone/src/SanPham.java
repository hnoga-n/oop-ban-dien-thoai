
//import java.util.Scanner;

public class SanPham implements Comparable<SanPham> {

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

    public SanPham(SanPham sp) {
        this.masp = sp.masp;
        this.tensp = sp.tensp;
        this.hang = sp.hang;
        this.gia = sp.gia;
        this.soluong = sp.soluong;
        this.thoiGianBaoHanh = sp.thoiGianBaoHanh;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
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
        System.out.println("Thông tin chi tiết sản phẩm:");
        System.out.println("---------------------------------------------------" + "\nMã sản phẩm: " + masp
                + "\n---------------------------------------------------" + "\nTên sản phảm: " + tensp
                + "\n---------------------------------------------------" + "\nHãng: " + hang
                + "\n---------------------------------------------------" + "\nGiá: " + gia
                + "\n---------------------------------------------------" + "\nSố lượng: " + soluong
                + "\n---------------------------------------------------"
                + "\nThời gian bảo hành: " + thoiGianBaoHanh + "\n---------------------------------------------------"
                + "\nChi tiết: ");
        this.chitietsp.XuatMoTaSanPham();

    }

    // xuất thông tin dùng cho phương thức tìmkiếm ở quản lí danh sách
    public String XuatThongTin() {
        return "Mã sản phẩm: " + masp + ";  Tên sản phảm: " + tensp + ";  Hãng: " + hang + ";  Giá: " + gia
                + ";  Thời gian bảo hành: " + thoiGianBaoHanh + ";  Số lượng: " + soluong;

    }

}
