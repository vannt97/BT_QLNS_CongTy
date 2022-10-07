import java.util.Scanner;

public class Person implements NhapVaXuat,TinhLuong {
    private int maSo;
    private String hoTen;
    private int soDt;
    private int soNgayLamViec;
    private String chucVu;
    private int luong1Ngay;

    private int luongThang;

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getLuong1Ngay() {
        return luong1Ngay;
    }

    public void setLuong1Ngay(int luong1Ngay) {
        this.luong1Ngay = luong1Ngay;
    }

    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSoDt() {
        return soDt;
    }

    public void setSoDt(int soDt) {
        this.soDt = soDt;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public String getChucVu() {
        return chucVu;
    }

    public int getLuongThang() {
        return luongThang;
    }

    public Person() {
    }

    public Person(int maSo, String hoTen, int soDt, int soNgayLamViec, String chucVu, int luong1Ngay) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDt = soDt;
        this.soNgayLamViec = soNgayLamViec;
        this.chucVu = chucVu;
        this.luong1Ngay = luong1Ngay;
    }

    public Person(int maSo, String hoTen, int soDt, int soNgayLamViec) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDt = soDt;
        this.soNgayLamViec = soNgayLamViec;
    }

    public void Nhap(Scanner scanner){
        System.out.println("Nhap ma so: ");
        this.maSo = scanner.nextInt();
        System.out.println("Nhap ten: ");
        this.hoTen = scanner.next();
        System.out.println("Nhap So Dt: ");
        this.soDt = scanner.nextInt();
        System.out.println("Nhap So Ngay Lam Viec: ");
        this.soNgayLamViec = scanner.nextInt();
    }
    public void Xuat(){
        System.out.print("Ma so:" + this.maSo);
        System.out.print(" - ten:" + this.hoTen);
        System.out.print(" - Sdt:" + this.soDt);
        System.out.print(" - so ngay lam viec:" + this.soNgayLamViec);
        System.out.print(" - chuc vu:" + this.chucVu);
        System.out.print(" - Luong 1 ngay:" + this.luong1Ngay);
        System.out.print(" - Luong thang: " + this.luongThang);
    }

    @Override
    public void TinhLuong() {
        TinhLuong.super.TinhLuong();
        this.luongThang = this.luong1Ngay * this.soNgayLamViec;
    }
}
