package in.vvm.FileOperations.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import in.vvm.FileOperations.entity.Pincode;
import in.vvm.FileOperations.repo.PincodeRepository;
import in.vvm.FileOperations.service.FileFetchingService;
import in.vvm.FileOperations.util.FileGenerator;

@Service
public class FileFetchingServiceImpl implements FileFetchingService {

	@Autowired
	PincodeRepository pincodeRepository;

	@Override
	public ByteArrayResource pinExcel() {
		List<Pincode> pincodeList = pincodeRepository.findAll();
		FileGenerator<Pincode> pinfile = new FileGenerator<>();
		return pinfile.generateExcel(pincodeList);
	}
}