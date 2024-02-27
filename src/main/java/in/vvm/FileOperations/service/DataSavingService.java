package in.vvm.FileOperations.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface DataSavingService {

	public String savePincodeData(MultipartFile mFile);
}