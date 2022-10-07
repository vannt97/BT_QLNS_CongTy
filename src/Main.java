import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CongTy congTy = new CongTy();
        DSNhanSu dsNhanSu = new DSNhanSu();
        congTy.setDsNhanSu(dsNhanSu);
        dsNhanSu.setCongTy(congTy);
        dsNhanSu.Nhap(scanner);
//        congTy.Nhap(scanner);
//        congTy.Xuat();

    }
}
