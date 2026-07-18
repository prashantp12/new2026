package ReadJsonFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJsonFile {

    static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        RetrieveDataClass readValue = mapper.readValue(
                new File("E:\\Selenium\\June2026\\TestNGProject\\src\\test\\resources\\test.json"),
                RetrieveDataClass.class);

        System.out.println(readValue.getName());
        System.out.println(readValue.getPassword());
        System.out.println(readValue.getRole());

        List<RetrieveDataClass> list = new ArrayList<>();
        RetrieveDataClass addData1 = new RetrieveDataClass();
        addData1.setName("Prashant");
        addData1.setPassword("Patil");
        addData1.setRole("QA Analyst");

        RetrieveDataClass addData2 = new RetrieveDataClass();
        addData2.setName("Prashant1");
        addData2.setPassword("Patil1");
        addData2.setRole("QA Analyst1");

        list.add(addData1);
        list.add(addData2);

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("E:\\Selenium\\June2026\\TestNGProject\\src\\test\\resources\\test.json"), list);

    }
}
