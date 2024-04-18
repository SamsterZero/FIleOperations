package in.vvm.FileOperations.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import in.vvm.FileOperations.entity.Pincode;
import in.vvm.FileOperations.repo.PincodeRepository;
import in.vvm.FileOperations.service.FileFetchingService;
import in.vvm.FileOperations.util.FileGenerator;

@Service
@RequiredArgsConstructor
public class FileFetchingServiceImpl implements FileFetchingService {

	private final PincodeRepository pincodeRepository;

	@Override
	public ByteArrayResource pinExcel() {
		List<Pincode> pincodeList = pincodeRepository.findAll();
		FileGenerator<Pincode> pinfile = new FileGenerator<>();
		return pinfile.generateExcel(pincodeList);
	}
}