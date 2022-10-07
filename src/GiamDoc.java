import java.util.Scanner;

public class GiamDoc extends Person {
    private float coPhan;
    private int thuNhap;
    public float getCoPhan() {
        return coPhan;
    }

    public int getThuNhap() {
        return thuNhap;
    }

    public void setCoPhan(float coPhan) {
        this.coPhan = coPhan;
    }

    public GiamDoc() {
        this.setChucVu("GiamDoc");
        this.setLuong1Ngay(300);
    }
    public GiamDoc(int maSo, String hoTen, int soDt, int soNgayLamViec, float coPhan) {
        super(maSo, hoTen, soDt, soNgayLamViec);
        this.coPhan = coPhan;
        this.setChucVu("GiamDoc");
        this.setLuong1Ngay(300);
    }

    @Override
    public void Nhap(Scanner scanner) {
        super.Nhap(scanner);
        System.out.println("Luong 1 ngay cua Giam Doc: " + this.getLuong1Ngay());
        System.out.println("Nhap co phan: ");
        this.coPhan = scanner.nextFloat();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println(" - Co phan: " + this.coPhan);
    }

    public void TinhThuNhap(int loiNhuanCty){
        this.thuNhap = (int) (this.getLuongThang()  + (this.coPhan/100)*loiNhuanCty);
    }

}
