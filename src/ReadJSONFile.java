import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadJSONFile {
    public List<Person> ReadFile(){
        JSONParser jsonParser = new JSONParser();
        List<Person> listPerson = new ArrayList<>();

        try (FileReader reader = new FileReader("data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray dsNhanSu = (JSONArray) obj;
//            System.out.println(dsNhanSu);

            for(Object nhanSu : dsNhanSu){
                JSONObject nhanSuFake = (JSONObject) nhanSu;
                int maSo = (int) ((long) nhanSuFake.get("maSo"));
                String hoTen = (String) nhanSuFake.get("hoTen");
                int soDt = (int) ((long) nhanSuFake.get("soDt"));
                int soNgayLamViec = (int) ((long) nhanSuFake.get("soNgayLamViec"));
                String chucVu = (String) nhanSuFake.get("chucVu");
                switch (chucVu){
                    case "GiamDoc":{
                        float coPhan = (float) ((long) nhanSuFake.get("coPhan"));
                        GiamDoc giamDoc = new GiamDoc(maSo,hoTen,soDt,soNgayLamViec,coPhan);

                        listPerson.add(giamDoc);
                        break;
                    }
                    case "TruongPhong":{
                        TruongPhong truongPhong = new TruongPhong(maSo,hoTen,soDt,soNgayLamViec,null);
                        listPerson.add(truongPhong);
                        break;
                    }
                    case "NhanVien":{
                        NhanVien nhanVien = new NhanVien(maSo,hoTen,soDt,soNgayLamViec,null);
                        listPerson.add(nhanVien);
                        break;
                    }
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return listPerson;
    }

    private void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }
}
