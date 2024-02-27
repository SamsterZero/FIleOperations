package in.vvm.FileOperations.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.vvm.FileOperations.entity.Pincode;

@Repository
public interface PincodeRepository extends JpaRepository<Pincode, Integer> {

}
