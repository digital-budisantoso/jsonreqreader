import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonexample.DataSuratPmt;
import com.jsonexample.MdlPermintaanDtl;

import java.io.File;
import java.util.List;

/**
 * Created by usrdjp on 7/23/2021.
 */
public class JsonExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<DataSuratPmt> lsData = objectMapper.readValue(new File("src/test/data-permintaan-768.json"),new TypeReference<List<DataSuratPmt>>(){});
        for(DataSuratPmt data : lsData ){
            System.out.println(data.getPmtHdr().getNoSurat()+"-"+data.getPmtHdr().getTglSurat());
            for(MdlPermintaanDtl dtl : data.getPmtDtls()){
                System.out.println(dtl.getNpwpNasabah()+"-"+dtl.getNikNasabah()+"-"+dtl.getNmNasabah());
            }
        }
    }
}
