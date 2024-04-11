package in.vvm.FileOperations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pincode")
@Data
@Builder
@AllArgsConstructor
public class Pincode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pincode;
	private String state;
	private String district;
	private String city;

}