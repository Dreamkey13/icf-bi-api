package com.icf.api;

import com.icf.model.AssetInformation;
import com.icf.model.StringDoubleKeyValuePair;
import com.icf.repository.AssetLogsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
public class CollectorInterfaceImpl implements AssetsApi {

    @Autowired
    AssetLogsRespository logsRespository;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return AssetsApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> assetsSerialNumberAssetInformationPost(String serialNumber,
            AssetInformation assetInformation) {
        return AssetsApi.super.assetsSerialNumberAssetInformationPost(serialNumber, assetInformation);
    }

    private static final double RPM_TARGET = 2750;
    private static final double SECONDS_TARGET = 96;
    private static final double TEMPERATURE_TARGET = 32;
    private static final double CYCLES_TARGET = 1530;

    private static final String TEMPERATURE = "Temperature";
    private static final String CYCLES = "Cyles";
    private static final String RPM = "RPM";
    private static final String PSI = "PSI";
    private static final String SECONDS = "SECONDS";

    private void checkKeyValue(StringDoubleKeyValuePair kv, String serialNo) {
        String targetKey = kv.getKey();
        Double targetValue = kv.getValue();

        if (serialNo.equals("MX53-923-43-AX")) {
            if (targetKey.equals(TEMPERATURE)) {
                // target value is 27.2
            }
        } else if (serialNo.equals("12FG-2453422345-2")) {
            if (targetKey.equals(TEMPERATURE)) {
                // target value is 22
            }
        } else if (serialNo.equals("BTA2354573453467")) {
            if (targetKey.equals(TEMPERATURE)) {
                // target value is 22
            } else if (targetKey.equals(CYCLES)) {
                // target value is 1530
            } else if (targetKey.equals(RPM)) {
                // target value is 2750
            }
        } else if (serialNo.equals("DHDF-24535674-434")) {
            if (targetKey.equals(CYCLES)) {
                // target value is 1530
            } else if (targetKey.equals(PSI)) {
                // target value is 2750
            }
        } else if (serialNo.equals("3453434224EFHF4FR4")) {
            if (targetKey.equals(CYCLES)) {
                // target value is 1530
            } else if (targetKey.equals(RPM)) {
                // target value is 652
            } else if (targetKey.equals(PSI)) {
                // target value is 2750
            }
        } else if (serialNo.equals("23534FDDF45Y645")) {
            if (targetKey.equals(TEMPERATURE)) {
                // target value is 245
            } else if (targetKey.equals(SECONDS)) {
                // target value is 96
            }
        } else if (serialNo.equals("23534FDDF45Y645")) {
            if (targetKey.equals(TEMPERATURE)) {
                // target value is 245
            } else if (targetKey.equals(SECONDS)) {
                // target value is 96
            }
        }
    }

    @Override
    public ResponseEntity<Void> assetsSerialNumberMetricsPost(String serialNumber,
            List<StringDoubleKeyValuePair> stringDoubleKeyValuePair) {
        // ArrayList<StringDoubleDb> logs = new ArrayList<>();

        for (StringDoubleKeyValuePair kv : stringDoubleKeyValuePair) {
            //checkKeyValue(kv, serialNumber);

            logsRespository.saveAssetLog(serialNumber, kv.getKey(), kv.getValue());

            // StringDoubleDb log = new StringDoubleDb();
            // log.setId(UUID.randomUUID().toString().replace("-", ""));
            // log.setAssetSerialNo(serialNumber);
            // log.setKey(kv.getKey());
            // log.setValue(kv.getValue());
            // logs.add(log);
        }
        // logsRespository.saveAll(logs);
        return new ResponseEntity(HttpStatus.OK);
    }
}
