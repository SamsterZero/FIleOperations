package in.vvm.FileOperations.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import in.vvm.FileOperations.entity.Pincode;
import in.vvm.FileOperations.repo.PincodeRepository;
import in.vvm.FileOperations.service.DataSavingService;
import in.vvm.FileOperations.util.ExcelConverter;

@Service
public class DataSavingServiceImpl implements DataSavingService {

	@Autowired
	PincodeRepository pincodeRepository;

	@Override
	public String savePincodeData(MultipartFile file) {
		ExcelConverter<Pincode> excelConverter = new ExcelConverter<>();
		List<Pincode> pincodeList = excelConverter.excelToObjectList(file, Pincode.class);
		List<Pincode> flag = pincodeRepository.saveAll(pincodeList);
		if (!flag.isEmpty()) {
			System.out.println(pincodeList);
			System.out.println("Original size : 154797");
			System.out.println("Current size : " + pincodeList.size());
			return StringUtils.cleanPath(file.getOriginalFilename());
		}
		return "failed";
	}
}